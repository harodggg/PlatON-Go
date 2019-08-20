// Package evidence implements recording duplicate blocks and votes for cbft consensus.
package evidence

import (
	"bytes"
	"encoding/binary"
	"encoding/json"
	"fmt"

	"github.com/PlatONnetwork/PlatON-Go/core/cbfttypes"

	"github.com/PlatONnetwork/PlatON-Go/common/consensus"
	"github.com/PlatONnetwork/PlatON-Go/consensus/cbft/protocols"
	"github.com/PlatONnetwork/PlatON-Go/consensus/cbft/types"
	"github.com/PlatONnetwork/PlatON-Go/node"
	"github.com/PlatONnetwork/PlatON-Go/rlp"
	"github.com/syndtr/goleveldb/leveldb"
	"github.com/syndtr/goleveldb/leveldb/opt"
)

var (
	// Duplicate prepare block prefix
	prepareDualPrefix = byte(0x1)
	// Duplicate prepare vote prefix
	voteDualPrefix = byte(0x2)
	// Duplicate viewChange prefix
	viewDualPrefix = byte(0x3)
)

// EvidencePool encapsulates functions required to record duplicate blocks and votes.
type EvidencePool interface {
	consensus.EvidencePool
	AddPrepareBlock(pb *protocols.PrepareBlock, node *cbfttypes.ValidateNode) error
	AddPrepareVote(pv *protocols.PrepareVote, node *cbfttypes.ValidateNode) error
	AddViewChange(vc *protocols.ViewChange, node *cbfttypes.ValidateNode) error
}

// emptyEvidencePool is a empty implementation for EvidencePool
type emptyEvidencePool struct {
}

func (pool *emptyEvidencePool) AddPrepareBlock(pb *protocols.PrepareBlock, node *cbfttypes.ValidateNode) error {
	return nil
}

func (pool *emptyEvidencePool) AddPrepareVote(pv *protocols.PrepareVote, node *cbfttypes.ValidateNode) error {
	return nil
}

func (pool *emptyEvidencePool) AddViewChange(vc *protocols.ViewChange, node *cbfttypes.ValidateNode) error {
	return nil
}

func (pool *emptyEvidencePool) Evidences() consensus.Evidences {
	return nil
}

func (pool *emptyEvidencePool) Clear(epoch uint64, viewNumber uint64) {
}

func (pool *emptyEvidencePool) Close() {
}

// baseEvidencePool is a default implementation for EvidencePool
type baseEvidencePool struct {
	pb PrepareBlockEvidence
	pv PrepareVoteEvidence
	vc ViewChangeEvidence
	db *leveldb.DB
}

// NewEvidencePool creates a new baseEvidencePool to record duplicate blocks and votes.
func NewEvidencePool(ctx *node.ServiceContext, evidenceDir string) (EvidencePool, error) {
	path := ""
	if ctx != nil {
		path = ctx.ResolvePath(evidenceDir)
	}
	if len(path) == 0 {
		return &emptyEvidencePool{}, nil
	}
	return NewBaseEvidencePool(path)
}

func NewBaseEvidencePool(path string) (*baseEvidencePool, error) {
	// Open or create evidence database
	db, err := leveldb.OpenFile(path, nil)
	if err != nil {
		return nil, err
	}

	return &baseEvidencePool{
		pb: make(PrepareBlockEvidence),
		pv: make(PrepareVoteEvidence),
		vc: make(ViewChangeEvidence),
		db: db,
	}, nil
}

// AddPrepareBlock tries to record duplicate prepare block
func (pool *baseEvidencePool) AddPrepareBlock(pb *protocols.PrepareBlock, node *cbfttypes.ValidateNode) (err error) {
	id := verifyIdentity(pb)
	var evidencePrepare *EvidencePrepare
	if evidencePrepare, err = NewEvidencePrepare(pb, node); err != nil {
		return fmt.Errorf("CannibalizeBytes error")
	}
	if err := pool.pb.Add(evidencePrepare, id); err != nil {
		if evidence, ok := err.(*DuplicatePrepareBlockEvidence); ok {
			// record duplicate prepare block to db
			if err := pool.commit(evidence, id); err != nil {
				return err
			}
			return err
		}
	}
	return nil
}

// AddPrepareVote tries to record duplicate prepare vote
func (pool *baseEvidencePool) AddPrepareVote(pv *protocols.PrepareVote, node *cbfttypes.ValidateNode) (err error) {
	id := verifyIdentity(pv)
	var evidenceVote *EvidenceVote
	if evidenceVote, err = NewEvidenceVote(pv, node); err != nil {
		return fmt.Errorf("CannibalizeBytes error")
	}
	if err := pool.pv.Add(evidenceVote, id); err != nil {
		if evidence, ok := err.(*DuplicatePrepareVoteEvidence); ok {
			// record duplicate prepare vote to db
			if err := pool.commit(evidence, id); err != nil {
				return err
			}
			return err
		}
	}
	return nil
}

// AddViewChange tries to record duplicate viewChange
func (pool *baseEvidencePool) AddViewChange(vc *protocols.ViewChange, node *cbfttypes.ValidateNode) (err error) {
	id := verifyIdentity(vc)
	var evidenceView *EvidenceView
	if evidenceView, err = NewEvidenceView(vc, node); err != nil {
		return fmt.Errorf("CannibalizeBytes error")
	}
	if err := pool.vc.Add(evidenceView, id); err != nil {
		if evidence, ok := err.(*DuplicateViewChangeEvidence); ok {
			// record duplicate viewChange to db
			if err := pool.commit(evidence, id); err != nil {
				return err
			}
			return err
		}
	}
	return nil
}

// Evidences retrieves the duplicate evidence by querying the database
func (pool *baseEvidencePool) Evidences() consensus.Evidences {
	var evds consensus.Evidences
	it := pool.db.NewIterator(nil, nil)
	for it.Next() {
		flag := it.Key()[0]
		switch flag {
		case prepareDualPrefix:
			var e DuplicatePrepareBlockEvidence
			if err := rlp.DecodeBytes(it.Value(), &e); err == nil {
				evds = append(evds, &e)
			}
		case voteDualPrefix:
			var e DuplicatePrepareVoteEvidence
			if err := rlp.DecodeBytes(it.Value(), &e); err == nil {
				evds = append(evds, &e)
			}
		case viewDualPrefix:
			var e DuplicateViewChangeEvidence
			if err := rlp.DecodeBytes(it.Value(), &e); err == nil {
				evds = append(evds, &e)
			}
		}
	}

	it.Release()
	return evds
}

// NewEvidences retrieves the duplicate evidence by parsing string
func NewEvidences(data string) (consensus.Evidences, error) {
	var eds EvidenceData
	if err := json.Unmarshal([]byte(data), &eds); err != nil {
		return nil, err
	}

	var res consensus.Evidences
	for _, e := range eds.DP {
		res = append(res, e)
	}
	for _, e := range eds.DV {
		res = append(res, e)
	}
	for _, e := range eds.DC {
		res = append(res, e)
	}
	return res, nil
}

//func (pool *baseEvidencePool) UnmarshalEvidence(data string) (consensus.Evidences, error) {
//	var ed EvidenceData
//	if err := json.Unmarshal([]byte(data), &ed); err != nil {
//		return nil, err
//	}
//	evds := make(consensus.Evidences, 0)
//	for _, e := range ed.DP {
//		evds = append(evds, e)
//	}
//	for _, e := range ed.DV {
//		evds = append(evds, e)
//	}
//	for _, e := range ed.DC {
//		evds = append(evds, e)
//	}
//	return evds, nil
//}

// Clear tries to clear stale intermediate data
func (pool *baseEvidencePool) Clear(epoch uint64, viewNumber uint64) {
	pool.pb.Clear(epoch, viewNumber)
	pool.pv.Clear(epoch, viewNumber)
	pool.vc.Clear(epoch, viewNumber)
}

func (pool *baseEvidencePool) Close() {
	pool.db.Close()
}

// "epoch|viewNumber|nodeIndex" represents a set of consensusMsg
func verifyIdentity(msg types.ConsensusMsg) Identity {
	msgID := ""
	switch m := msg.(type) {
	case *protocols.PrepareBlock:
		msgID = fmt.Sprintf("%d|%d|%d", m.Epoch, m.ViewNumber, m.ProposalIndex)
	case *protocols.PrepareVote:
		msgID = fmt.Sprintf("%d|%d|%d", m.Epoch, m.ViewNumber, m.ValidatorIndex)
	case *protocols.ViewChange:
		msgID = fmt.Sprintf("%d|%d|%d", m.Epoch, m.ViewNumber, m.ValidatorIndex)
	}
	return Identity(msgID)
}

func encodeKey(e consensus.Evidence, id Identity) []byte {
	buf := bytes.NewBuffer(nil)
	switch e.(type) {
	case *DuplicatePrepareBlockEvidence:
		buf.WriteByte(prepareDualPrefix)
	case *DuplicatePrepareVoteEvidence:
		buf.WriteByte(voteDualPrefix)
	case *DuplicateViewChangeEvidence:
		buf.WriteByte(viewDualPrefix)
	}

	// epoch
	epoch := [8]byte{}
	binary.BigEndian.PutUint64(epoch[:], e.Epoch())
	buf.Write(epoch[:])
	// viewNumber
	viewNum := [8]byte{}
	binary.BigEndian.PutUint64(viewNum[:], e.ViewNumber())
	buf.Write(viewNum[:])
	// blockNumber
	num := [8]byte{}
	binary.BigEndian.PutUint64(num[:], e.BlockNumber())
	buf.Write(num[:])
	// node identity
	buf.Write(id.Bytes())
	// Evidence hash
	buf.Write(e.Hash())
	return buf.Bytes()
}

// commit tries to record duplicate evidence to db
func (ev *baseEvidencePool) commit(e consensus.Evidence, id Identity) error {
	key := encodeKey(e, id)
	var buf []byte
	var err error
	ok := false
	if ok, err = ev.db.Has(key, nil); !ok {
		if buf, err = rlp.EncodeToBytes(e); err == nil {
			err = ev.db.Put(key, buf, &opt.WriteOptions{Sync: true})
		}
	}
	return err
}

package network.platon.contracts;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.GasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 0.7.5.0.
 */
public class Overload extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b506101b7806100206000396000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c806313d1aa2e1461005c57806315d55b28146100a8578063587dcf18146100c6578063b3de648b146100e4578063e2179b8e14610126575b600080fd5b6100926004803603604081101561007257600080fd5b810190808035906020019092919080359060200190929190505050610130565b6040518082815260200191505060405180910390f35b6100b0610140565b6040518082815260200191505060405180910390f35b6100ce610146565b6040518082815260200191505060405180910390f35b610110600480360360208110156100fa57600080fd5b810190808035906020019092919050505061014f565b6040518082815260200191505060405180910390f35b61012e61015c565b005b6000818301905080905092915050565b60005481565b60008054905090565b6000819050809050919050565b600061016a60026003610130565b9050610176600261014f565b9050806000819055505056fea265627a7a72315820b3b58a557a1877ec4a9aeb69cef81ef185cdbd2816fede6befa5ac626c4aad8064736f6c634300050d0032";

    public static final String FUNC_F = "f";

    public static final String FUNC_G = "g";

    public static final String FUNC_GETRE = "getRe";

    public static final String FUNC_RE = "re";

    @Deprecated
    protected Overload(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Overload(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Overload(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Overload(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> f(BigInteger a, BigInteger b) {
        final Function function = new Function(
                FUNC_F, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a), 
                new org.web3j.abi.datatypes.generated.Uint256(b)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> f(BigInteger a) {
        final Function function = new Function(
                FUNC_F, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(a)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> g() {
        final Function function = new Function(
                FUNC_G, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getRe() {
        final Function function = new Function(FUNC_GETRE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> re() {
        final Function function = new Function(FUNC_RE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public static RemoteCall<Overload> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return deployRemoteCall(Overload.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Overload> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Overload.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Overload> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return deployRemoteCall(Overload.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Overload> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Overload.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static Overload load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Overload(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Overload load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Overload(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Overload load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new Overload(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Overload load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new Overload(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
package network.platon.contracts.wasm;

import java.util.Arrays;
import org.web3j.abi.WasmFunctionEncoder;
import org.web3j.abi.datatypes.WasmFunction;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.WasmContract;
import org.web3j.tx.gas.GasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 0.7.5.5-SNAPSHOT.
 */
public class MemoryFunction_1 extends WasmContract {
    private static String BINARY_0 = "0x0061736d0100000001410b60000060027f7f006000017f60017f0060017f017f60027f7f017f60037f7f7f017f60037f7f7f0060057f7f7f7f7f017f60047f7f7f7f0060047f7f7f7f017f02700503656e760c706c61746f6e5f6465627567000103656e760c706c61746f6e5f70616e6963000003656e7617706c61746f6e5f6765745f696e7075745f6c656e677468000203656e7610706c61746f6e5f6765745f696e707574000303656e760d706c61746f6e5f72657475726e0001036b6a00040303050100050006060605050403030004030606030507060408060503010504050403040305030604030404040901070403060a01050a060409090604010105010501050107010706010101090401090301010105050609050a01040509030601000404060503000405017001040405030100020615037f0141b08c040b7f0041b08c040b7f0041b00c0b072e04066d656d6f727902000b5f5f686561705f6261736503010a5f5f646174615f656e64030206696e766f6b65000b0909010041010b0307292d0aaf636a0800100d1068106e0b2201017f024020002802002201450d002000200136020420011098808080000b20000b0f00418088808000109f808080001a0b4401027f0240024020002d000022014101710d00200041016a2102200141017621000c010b20002802082102200028020421000b200220001080808080001081808080000b270020004200370200200041086a4100360200200020012001109380808000109d8080800020000bb00101047f23808080800041106b220224808080800002400240200241c98a80800010898080800022032d000022044101710d00200441017641016a220510ea808080002204410020051090808080001a200341016a21050c010b200328020441016a220510ea808080002204410020051090808080001a200328020821050b20002004200510928080800022041089808080001a200410ed808080002003109f808080001a200241106a2480808080000bf90c01077f23808080800041d0016b220024808080800020004180016a4100360200200042003703784100210102404100410c460d000340200041f8006a20016a4100360200200141046a2201410c470d000b0b2000410036027020004200370368024002400240024002401082808080002201450d002001417f4c0d02200041f0006a2001109780808000220241002001109080808000220320016a22013602002000200136026c20002003360268200321030c010b4100210141002102410021030b2003108380808000200020023602a8012000200120026b3602ac01200020002903a801370310200041386a200041d0006a200041106a411c10ae80808000410010b68080800002400240024002400240024002400240200028023c450d0020002802382d000041c0014f0d000240200041386a10b2808080002204200028023c22024d0d00200041a8016a41998b80800010898080800022011088808080002001109f808080001a200028023c21020b200028023821052002450d014100210320052c00002201417f4a0d04200141ff0171220641bf014b0d0241002103200141ff017141b801490d03200641c97e6a21030c030b200041b0016a4100360200200042003703a801410021014100410c460d060340200041a8016a20016a4100360200200141046a2201410c470d000c070b0b4101210320050d02410021060c030b41002103200141ff017141f801490d00200641897e6a21030b200341016a21030b41002106200320046a20024b0d0020022004490d004100210120022003490d01200220036b20042004417f461b2106200520036a21010c010b410021010b200041386a10b28080800021020240024002402001450d0020062002490d00200041b0016a4100360200200042003703a801200620022002417f461b220441704f0d05200120046a21032004410a4d0d01200441106a41707122061097808080002102200020043602ac01200020064101723602a801200020023602b0010c020b41002104200041b0016a4100360200200042003703a80141002101410021030b200020044101743a00a801200041a8016a41017221020b024020032001460d000340200220012d00003a0000200241016a21022003200141016a2201470d000b0b200241003a00000b0240024020002d00784101710d00200041003b01780c010b20002802800141003a00002000410036027c20002d0078410171450d0020004180016a280200109880808000200041003602780b200041f8006a41086a200041a8016a41086a280200360200200020002903a8013703784100210102404100410c460d000340200041a8016a20016a4100360200200141046a2201410c470d000b0b200041a8016a109f808080001a02400240024002400240200028027c20002d0078220141017620014101711b450d00200041f8006a41e08a808000108c808080000d04200041f8006a41e58a808000108c80808000450d0120004188016a20004187016a108a80808000200041b8016a22024200370300200041b0016a4200370300200042003703a801200020004198016a20004188016a109c808080002201280208200141016a20002d009801220341017122041b3602c00120002001280204200341017620041b3602c401200020002903c00137030841002103200041a8016a200041086a410010cf808080001a2001109f808080001a024020002802b4012002280200460d00200041c0016a41828b80800010898080800022011088808080002001109f808080001a0b200041003602c801200042003703c00120002802ac0120002802a80122046b2202450d022002417f4c0d07200041c8016a2002109780808000220120026a2203360200200020013602c001200020013602c401200120042002108f808080001a200020033602c4010c030b200041286a41d28a80800010898080800022011088808080002001109f808080001a0c030b200041186a41ef8a80800010898080800022011088808080002001109f808080001a0c020b410021010b2001200320016b108480808000200041c0016a1086808080001a0240200041b4016a2802002201450d00200041b8016a200136020020011098808080000b200041a8016a1086808080001a20004188016a109f808080001a0b200041e8006a1086808080001a200041f8006a109f808080001a200041d0016a2480808080000f0b200041e8006a10a380808000000b200041a8016a109b80808000000b200041c0016a10a380808000000b4201037f41002102024020011093808080002203200028020420002d0000220441017620044101711b470d0020004100417f2001200310a0808080004521020b20020b5501017f410042003702808880800041004100360288888080004174210002404174450d0003402000418c888080006a4100360200200041046a22000d000b0b4181808080004100418088808000108e808080001a0bcd0101027f418c88808000109480808000024041002802908880800022030d0041988880800021034100419888808000360290888080000b0240024041002802948880800022044120470d00418402410110ec808080002203450d01410021042003410028029088808000360200410020033602908880800041004100360294888080000b4100200441016a36029488808000200320044102746a22034184016a2001360200200341046a2000360200418c8880800010958080800041000f0b418c88808000109580808000417f0bc60a010b7f2002410f6a210341002104410020026b21052002410e6a2106410120026b21072002410d6a2108410220026b210902400340200020046a210b200120046a210a20022004460d01200a410371450d01200b200a2d00003a00002003417f6a2103200541016a21052006417f6a2106200741016a21072008417f6a2108200941016a2109200441016a21040c000b0b200220046b210c02400240024002400240200b410371220d450d00200c4120490d03200d4101460d01200d4102460d02200d4103470d03200b200120046a28020022063a0000200041016a210c200220046b417f6a21092004210b0240034020094113490d01200c200b6a220a2001200b6a220741046a2802002208411874200641087672360200200a41046a200741086a2802002206411874200841087672360200200a41086a2007410c6a2802002208411874200641087672360200200a410c6a200741106a2802002206411874200841087672360200200b41106a210b200941706a21090c000b0b2002417f6a2005416d2005416d4b1b20036a4170716b20046b210c2001200b6a41016a210a2000200b6a41016a210b0c030b200c210a02400340200a4110490d01200020046a220b200120046a2207290200370200200b41086a200741086a290200370200200441106a2104200a41706a210a0c000b0b02400240200c4108710d00200120046a210a200020046a21040c010b200020046a220b200120046a2204290200370200200441086a210a200b41086a21040b0240200c410471450d002004200a280200360200200a41046a210a200441046a21040b0240200c410271450d002004200a2f00003b0000200441026a2104200a41026a210a0b200c410171450d032004200a2d00003a000020000f0b200b200120046a220a28020022063a0000200b41016a200a41016a2f00003b0000200041036a210c200220046b417d6a21052004210b0240034020054111490d01200c200b6a220a2001200b6a220741046a2802002203410874200641187672360200200a41046a200741086a2802002206410874200341187672360200200a41086a2007410c6a2802002203410874200641187672360200200a410c6a200741106a2802002206410874200341187672360200200b41106a210b200541706a21050c000b0b2002417d6a2009416f2009416f4b1b20086a4170716b20046b210c2001200b6a41036a210a2000200b6a41036a210b0c010b200b200120046a220a28020022083a0000200b41016a200a41016a2d00003a0000200041026a210c200220046b417e6a21052004210b0240034020054112490d01200c200b6a220a2001200b6a220941046a2802002203411074200841107672360200200a41046a200941086a2802002208411074200341107672360200200a41086a2009410c6a2802002203411074200841107672360200200a410c6a200941106a2802002208411074200341107672360200200b41106a210b200541706a21050c000b0b2002417e6a2007416e2007416e4b1b20066a4170716b20046b210c2001200b6a41026a210a2000200b6a41026a210b0b0240200c411071450d00200b200a2d00003a0000200b200a280001360001200b200a290005370005200b200a2f000d3b000d200b200a2d000f3a000f200b41106a210b200a41106a210a0b0240200c410871450d00200b200a290000370000200b41086a210b200a41086a210a0b0240200c410471450d00200b200a280000360000200b41046a210b200a41046a210a0b0240200c410271450d00200b200a2f00003b0000200b41026a210b200a41026a210a0b200c410171450d00200b200a2d00003a00000b20000bfb0202027f017e02402002450d00200020013a0000200020026a2203417f6a20013a000020024103490d00200020013a0002200020013a00012003417d6a20013a00002003417e6a20013a000020024107490d00200020013a00032003417c6a20013a000020024109490d002000410020006b41037122046a2203200141ff017141818284086c22013602002003200220046b417c7122046a2202417c6a200136020020044109490d002003200136020820032001360204200241786a2001360200200241746a200136020020044119490d002003200136021820032001360214200320013602102003200136020c200241706a20013602002002416c6a2001360200200241686a2001360200200241646a20013602002001ad220542208620058421052004200341047141187222016b2102200320016a2101034020024120490d0120012005370300200141186a2005370300200141106a2005370300200141086a2005370300200141206a2101200241606a21020c000b0b20000bbd0101047f0240024002402001200073410371450d0020002102200121030c010b024003402001410371450d01200020012d000022023a00002002450d03200041016a2100200141016a21010c000b0b410021040340200020046a2102200120046a22032802002205417f73200541fffdfb776a71418081828478710d0120022005360200200441046a21040c000b0b02400340200220032d000022013a00002001450d01200241016a2102200341016a21030c000b0b200221000b20000b0f00200020011091808080001a20000b7a01027f200021010240024003402001410371450d0120012d0000450d02200141016a21010c000b0b2001417c6a21010340200141046a22012802002202417f73200241fffdfb776a7141808182847871450d000b0340200241ff0171450d01200141016a2d00002102200141016a21010c000b0b200120006b0b0900200041013602000b0900200041003602000b02000b3a01027f2000410120001b210102400340200110ea8080800022020d01410028029c8a8080002200450d012000118080808000000c000b0b20020b0a00200010ed808080000bce0301067f024020002001460d000240024002400240200120006b20026b410020024101746b4d0d0020012000734103712103200020014f0d012003450d02200021030c030b200020012002108f808080000f0b024020030d002001417f6a210402400340200020026a2203410371450d012002450d052003417f6a200420026a2d00003a00002002417f6a21020c000b0b2000417c6a21032001417c6a2104034020024104490d01200320026a200420026a2802003602002002417c6a21020c000b0b2001417f6a210103402002450d03200020026a417f6a200120026a2d00003a00002002417f6a21020c000b0b200241046a21052002417f7321064100210402400340200120046a2107200020046a2208410371450d0120022004460d03200820072d00003a00002005417f6a2105200641016a2106200441016a21040c000b0b200220046b2101410021030240034020014104490d01200820036a200720036a280200360200200341046a21032001417c6a21010c000b0b200720036a2101200820036a210320022006417c2006417c4b1b20056a417c716b20046b21020b03402002450d01200320012d00003a00002002417f6a2102200341016a2103200141016a21010c000b0b20000b4201027f0240024003402002450d0120002d0000220320012d00002204470d02200141016a2101200041016a21002002417f6a21020c000b0b41000f0b200320046b0b0900109680808000000b5201017f20004200370200200041086a22024100360200024020012d00004101710d00200020012902003702002002200141086a28020036020020000f0b200020012802082001280204109d8080800020000b7701027f0240200241704f0d00024002402002410a4b0d00200020024101743a0000200041016a21030c010b200241106a417071220410978080800021032000200236020420002004410172360200200020033602080b200320012002109e808080001a200320026a41003a00000f0b109680808000000b1a0002402002450d00200020012002108f8080800021000b20000b1d00024020002d0000410171450d0020002802081098808080000b20000b9a0101027f0240024020002d0000220541017122060d00200541017621050c010b200028020421050b02402004417f460d0020052001490d00200520016b2205200220052002491b21020240024020060d00200041016a21000c010b200028020821000b0240200020016a200320042002200220044b22001b10a1808080002201450d0020010f0b417f200020022004491b0f0b109680808000000b190002402002450d00200020012002109a808080000f0b41000b270020004200370200200041086a4100360200200020012001109380808000109d8080800020000b0900109680808000000b6001017f23808080800041206b2202248080808000200241186a420037030020024200370310200242003703082000200241086a200110a58080800010a68080800010a7808080001a200241086a10a8808080001a200241206a2480808080000b4101017f23808080800041106b220224808080800020002002200110a280808000220110db8080800021002001109f808080001a200241106a24808080800020000b5401027f23808080800041106b22012480808080000240200028020c200041106a280200460d00200141908c80800010a280808000220210b0808080002002109f808080001a0b200141106a24808080800020000b4e01017f20004200370200200041003602080240200128020420012802006b2202450d002000200210d280808000200041086a2001280200200141046a280200200041046a10d3808080000b20000b19002000410c6a10d4808080001a200010aa808080001a20000b0f0041a08a80800010aa808080001a0b2201017f024020002802002201450d002000200136020420011098808080000b20000b4701027f23808080800041206b22012480808080002000200141086a410010ac80808000220210a68080800010a7808080001a200210a8808080001a200141206a2480808080000b24002000420037020820004200370200200041106a42003702002000200110c6808080000b0f0041ac8a80800010aa808080001a0bdb0101027f23808080800041206b220324808080800020004200370210200042ffffffff0f3702082000200129020037020002402002410871450d00200010af8080800020012802044f0d00024020024104710d00200042003702000c010b200341106a41a38b80800010a280808000220410b0808080002004109f808080001a0b02402002411071450d00200010af8080800020012802044d0d00024020024104710d00200042003702000c010b200341b18b80800010a280808000220210b0808080002002109f808080001a0b200341206a24808080800020000b3400024002402000280204450d0020002802002c0000417f4c0d0141010f0b41000f0b200010b180808000200010b2808080006a0b4401027f0240024020002d000022014101710d00200041016a2102200141017621000c010b20002802082102200028020421000b200220001080808080001081808080000b280002402000280204450d0020002802002c0000417f4c0d0041000f0b200010b78080800041016a0bab0601057f23808080800041b0016b22012480808080000240024002402000280204450d00200010b8808080004101210220002802002c00002203417f4a0d02200341ff0171220241b7014b0d01200241807f6a21020c020b410021020c010b02400240200341ff0171220341bf014b0d000240200041046a22042802002203200241c97e6a22054b0d00200141a0016a41c08b80800010a280808000220210b0808080002002109f808080001a200428020021030b024020034102490d0020002802002d00010d0020014190016a41c08b80800010a280808000220210b0808080002002109f808080001a0b024020054105490d0020014180016a41b18b80800010a280808000220210b0808080002002109f808080001a0b024020002802002d00010d00200141f0006a41c08b80800010a280808000220210b0808080002002109f808080001a0b41002102410021030240034020052003460d012002410874200028020020036a41016a2d0000722102200341016a21030c000b0b200241384f0d01200141e0006a41c08b80800010a280808000220310b0808080002003109f808080001a0c020b0240200341f7014b0d00200241c07e6a21020c020b0240200041046a22042802002203200241897e6a22054b0d00200141d0006a41c08b80800010a280808000220210b0808080002002109f808080001a200428020021030b024020034102490d0020002802002d00010d00200141c0006a41c08b80800010a280808000220210b0808080002002109f808080001a0b024020054105490d00200141306a41b18b80800010a280808000220210b0808080002002109f808080001a0b024020002802002d00010d00200141206a41c08b80800010a280808000220210b0808080002002109f808080001a0b41002102410021030240034020052003460d012002410874200028020020036a41016a2d0000722102200341016a21030c000b0b200241384f0d00200141106a41c08b80800010a280808000220310b0808080002003109f808080001a0c010b200241ff7d490d00200141b18b80800010a280808000220310b0808080002003109f808080001a0b200141b0016a24808080800020020b5102017f017e23808080800041306b220124808080800020012000290200220237031020012002370308200141186a200141086a411410ae8080800010af808080002100200141306a24808080800020000b6a01037f02400240024020012802002204450d0041002105200320026a200128020422064b0d0120062002490d014100210120062003490d02200620026b20032003417f461b2101200420026a21050c020b410021050b410021010b20002001360204200020053602000b6801037f23808080800041106b22022480808080000240200110b280808000220320012802044d0d00200241a78c80800010a280808000220410b0808080002004109f808080001a0b20002001200110b180808000200310b480808000200241106a2480808080000bd003020a7f017e23808080800041c0006b220324808080800002402001280208220420024d0d00200341386a200110b580808000200320032903383703182001200341186a10b38080800036020c200341306a200110b580808000410021044100210541002106024020032802302207450d00410021054100210620032802342208200128020c2209490d00200820092009417f461b2105200721060b20012006360210200141146a2005360200200141086a41003602000b200141106a2106200141146a21092001410c6a2107200141086a210802400340200420024f0d012009280200450d01200341306a200110b58080800041002104024002402003280230220a450d00410021052003280234220b2007280200220c490d01200a200c6a2105200b200c6b21040c010b410021050b20092004360200200620053602002003200436022c2003200536022820032003290328370310200341306a20064100200341106a10b38080800010b48080800020062003290330220d37020020072007280200200d422088a76a3602002008200828020041016a22043602000c000b0b20032006290200220d3703202003200d3703082000200341086a411410ae808080001a200341c0006a2480808080000b4701017f4100210102402000280204450d00024020002802002d0000220041bf014b0d00200041b801490d01200041c97e6a0f0b200041f801490d00200041897e6a21010b20010bc10101027f23808080800041306b2201248080808000024020002802040d00200141206a41c08b80800010a280808000220210b0808080002002109f808080001a0b0240200028020022022d0000418101470d000240200041046a28020041014b0d00200141106a41c08b80800010a280808000220210b0808080002002109f808080001a200028020021020b20022c00014100480d00200141c08b80800010a280808000220010b0808080002000109f808080001a0b200141306a2480808080000b2d01017f2000200028020420012802002203200320012802046a10ba808080001a2000200210bb8080800020000b970201057f23808080800041206b22042480808080000240200320026b22054101480d00024020052000280208200028020422066b4c0d00200441086a2000200520066a20002802006b10bc80808000200120002802006b200041086a10bd8080800021060240034020032002460d01200641086a220528020020022d00003a00002005200528020041016a360200200241016a21020c000b0b20002006200110be808080002101200610bf808080001a0c010b024002402005200620016b22074c0d00200041086a200220076a22082003200041046a10c080808000200741014e0d010c020b200321080b200020012006200120056a10c18080800020022008200110c2808080001a0b200441206a24808080800020010b950301097f23808080800041206b220224808080800002402001450d002000410c6a2103200041106a2104200041046a21050340200428020022062003280200460d010240200641786a28020020014f0d00200241106a41c88b80800010a280808000220610b0808080002006109f808080001a200428020021060b200641786a2207200728020020016b220136020020010d0120042007360200200528020020002802006b2006417c6a28020022016b220610c38080800021072000200528020020002802006b22084101200741016a20064138491b22096a10c480808000200120002802006a220a20096a200a200820016b1099808080001a02400240200641374b0d00200028020020016a200641406a3a00000c010b0240200741f7016a220841ff014b0d00200028020020016a20083a00002000280200200720016a6a210103402006450d02200120063a0000200641087621062001417f6a21010c000b0b200241dc8b80800010a280808000220610b0808080002006109f808080001a0b410121010c000b0b200241206a2480808080000b4c01017f02402001417f4c0d0041ffffffff0721020240200028020820002802006b220041feffffff034b0d0020012000410174220020002001491b21020b20020f0b200010a380808000000b5401017f410021042000410036020c200041106a200336020002402001450d00200110978080800021040b200020043602002000200420026a22023602082000410c6a200420016a3602002000200236020420000b8c0101027f20012802042103200041086a220420002802002002200141046a10d680808000200420022000280204200141086a10de80808000200028020021022000200128020436020020012002360204200028020421022000200128020836020420012002360208200028020821022000200128020c3602082001200236020c2001200128020436020020030b2301017f200010d780808000024020002802002201450d0020011098808080000b20000b2e000240200220016b22024101480d00200328020020012002108f808080001a2003200328020020026a3602000b0b5c01037f200041046a21042000280204220521062001200520036b6a2203210002400340200020024f0d01200620002d00003a00002004200428020041016a2206360200200041016a21000c000b0b20012003200510dd808080001a0b21000240200120006b2201450d002002200020011099808080001a0b200220016a0b2501017f41002101024003402000450d0120004108762100200141016a21010c000b0b20010b4001027f02402000280204200028020022026b220320014f0d002000200120036b10c5808080000f0b0240200320014d0d00200041046a200220016a3602000b0b920101027f23808080800041206b2202248080808000024002402000280208200028020422036b20014f0d00200241086a2000200320016a20002802006b10bc80808000200041046a28020020002802006b200041086a10bd808080002203200110d9808080002000200310d580808000200310bf808080001a0c010b2000200110da808080000b200241206a2480808080000b7501017f23808080800041106b2202248080808000024002402001450d00200220013602002002200028020420002802006b3602042000410c6a200210c7808080000c010b20024100360208200242003703002000200210c8808080001a200210aa808080001a0b200241106a24808080800020000b3d01017f02402000280204220220002802084f0d0020022001290200370200200041046a2200200028020041086a3602000f0b2000200110c9808080000b5101027f23808080800041106b22022480808080002002200128020022033602082002200128020420036b36020c200220022903083703002000200210ca808080002101200241106a24808080800020010b840101027f23808080800041206b2202248080808000200241086a2000200028020420002802006b41037541016a10df80808000200028020420002802006b410375200041086a10e080808000220328020820012902003702002003200328020841086a3602082000200310e180808000200310e2808080001a200241206a2480808080000b800102027f017e23808080800041206b2202248080808000024002402001280204220341374b0d002002200341406a3a001f20002002411f6a10cb808080000c010b2000200341f70110cc808080000b200220012902002204370310200220043703082000200241086a410110b9808080002100200241206a24808080800020000b3d01017f02402000280204220220002802084f0d00200220012d00003a0000200041046a2200200028020041016a3602000f0b2000200110cd808080000b7a01037f23808080800041206b22032480808080000240200110c380808000220420026a2202418002480d00200341106a41f88b80800010a280808000220510b0808080002005109f808080001a0b200320023a000f20002003410f6a10cb8080800020002001200410ce80808000200341206a2480808080000b7e01027f23808080800041206b2202248080808000200241086a2000200028020441016a20002802006b10bc80808000200028020420002802006b200041086a10bd80808000220328020820012d00003a00002003200328020841016a3602082000200310d580808000200310bf808080001a200241206a2480808080000b44002000200028020420026a20002802006b10c4808080002000280204417f6a2100024003402001450d01200020013a00002000417f6a2100200141087621010c000b0b0bfc0101037f23808080800041206b22032480808080002001280200210420012802042105024002402002450d004100210102400340200420016a2102200120054f0d0120022d00000d01200141016a21010c000b0b200520016b21050c010b200421020b0240024002400240024020054101470d0020022c00004100480d012000200210d0808080000c040b200541374b0d010b20032005418001733a001f20002003411f6a10cb808080000c010b2000200541b70110cc808080000b2003200536021420032002360210200320032903103703082000200341086a410010b9808080001a0b2000410110bb80808000200341206a24808080800020000b3d01017f0240200028020422022000280208460d00200220012d00003a0000200041046a2200200028020041016a3602000f0b2000200110d1808080000b7e01027f23808080800041206b2202248080808000200241086a2000200028020441016a20002802006b10bc80808000200028020420002802006b200041086a10bd80808000220328020820012d00003a00002003200328020841016a3602082000200310d580808000200310bf808080001a200241206a2480808080000b3801017f02402001417f4c0d00200020011097808080002202360200200020023602042000200220016a3602080f0b200010a380808000000b2e000240200220016b22024101480d00200328020020012002108f808080001a2003200328020020026a3602000b0b2201017f024020002802002201450d002000200136020420011098808080000b20000b7001017f200041086a20002802002000280204200141046a10d680808000200028020021022000200128020436020020012002360204200028020421022000200128020836020420012002360208200028020821022000200128020c3602082001200236020c200120012802043602000b2f01017f20032003280200200220016b22026b2204360200024020024101480d00200420012002108f808080001a0b0b0f002000200028020410d8808080000b2d01017f20002802082102200041086a21000240034020012002460d0120002002417f6a22023602000c000b0b0b3401017f20002802082102200041086a21000340200241003a00002000200028020041016a22023602002001417f6a22010d000b0b3401017f20002802042102200041046a21000340200241003a00002000200028020041016a22023602002001417f6a22010d000b0b4501017f23808080800041106b22022480808080002002200241086a200110dc8080800029020037030020002002410010cf808080002100200241106a24808080800020000b360020002001280208200141016a20012d00004101711b3602002000200128020420012d0000220141017620014101711b36020420000b23000240200120006b2201450d00200220016b2202200020011099808080001a0b20020b2e000240200220016b22024101480d00200328020020012002108f808080001a2003200328020020026a3602000b0b5301017f024020014180808080024f0d0041ffffffff0121020240200028020820002802006b220041037541feffffff004b0d0020012000410275220020002001491b21020b20020f0b200010a380808000000b5c01017f410021042000410036020c200041106a200336020002402001450d002003200110e38080800021040b200020043602002000200420024103746a22033602082000410c6a200420014103746a3602002000200336020420000b7001017f200041086a20002802002000280204200141046a10e480808000200028020021022000200128020436020020012002360204200028020421022000200128020836020420012002360208200028020821022000200128020c3602082001200236020c200120012802043602000b2301017f200010e580808000024020002802002201450d0020011098808080000b20000b0e0020002001410010e6808080000b2f01017f20032003280200200220016b22026b2204360200024020024101480d00200420012002108f808080001a0b0b0f002000200028020410e7808080000b2300024020014180808080024f0d0020014103741097808080000f0b109680808000000b2d01017f20002802082102200041086a21000240034020012002460d012000200241786a22023602000c000b0b0b4a0041a08a80800041a28b80800010a4808080004182808080004100418088808000108e808080001a41ac8a80800010ab808080004183808080004100418088808000108e808080001a0b3901017f23808080800041106b2201410036020c2000200128020c28020041076a41787122013602042000200136020020003f0036020c20000b120041b88a8080002000410810eb808080000bb20101037f0240024002402001450d0041002d00c88a808000450d01200028020c2103200028020421040c020b41000f0b20003f0041107422043602043f002103410041013a00c88a8080002000200336020c0b20002003200141107622056a220336020c20002002200420016a6a417f6a410020026b7122013602040240200341107420014b0d002000410c6a200341016a360200200541016a21050b200540001a200441002000410c6a2802003f00461b0b2e00024041b88a808000200120006c2200410810eb808080002201450d002001410020001090808080001a0b20010b02000b0f0041b88a80800010e9808080001a0b0bbf0402004180080bc90200000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000041c90a0be7015761736d546573740076616c6964206d6574686f640a00696e6974006765746d616c6c6f63006e6f206d6574686f6420746f2063616c6c0a006c697374537461636b206973206e6f7420656d70747900626164206361737400006f7665722073697a6520726c7000756e6465722073697a6520726c700062616420726c70006974656d436f756e7420746f6f206c61726765006974656d436f756e7420746f6f206c6172676520666f7220524c5000436f756e7420746f6f206c6172676520666f7220524c50006c697374537461636b206973206e6f7420656d70747900626164206361737400";

    public static String BINARY = BINARY_0;

    public static final String FUNC_GETMALLOC = "getmalloc";

    protected MemoryFunction_1(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    protected MemoryFunction_1(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<MemoryFunction_1> deploy(Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(MemoryFunction_1.class, web3j, credentials, contractGasProvider, encodedConstructor);
    }

    public static RemoteCall<MemoryFunction_1> deploy(Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        String encodedConstructor = WasmFunctionEncoder.encodeConstructor(BINARY, Arrays.asList());
        return deployRemoteCall(MemoryFunction_1.class, web3j, transactionManager, contractGasProvider, encodedConstructor);
    }

    public RemoteCall<String> getmalloc() {
        final WasmFunction function = new WasmFunction(FUNC_GETMALLOC, Arrays.asList(), String.class);
        return executeRemoteCall(function, String.class);
    }

    public static MemoryFunction_1 load(String contractAddress, Web3j web3j, Credentials credentials, GasProvider contractGasProvider) {
        return new MemoryFunction_1(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MemoryFunction_1 load(String contractAddress, Web3j web3j, TransactionManager transactionManager, GasProvider contractGasProvider) {
        return new MemoryFunction_1(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}

package cairh.community.api.point.util;


/**
 * @Title: 集中交易密码加密解密
 * @Package com.kingstar.securities.bc.wskh.pkg.util
 * @Description:
 * @author Si.Dai
 * @date 2014年10月8日 下午3:54:26
 * @version V1.0
 */
public class PwdUtil {

    private static String CYHPubKey = "Designed by ChenYongHua";

    /**
     * @Title: PwdEncode
     * @Description: 加密
     * @param source
     *            需要加密的明文密码
     * @param key
     * @return
     * @return String 返回类型
     * @throws Exception
     * @author Cheng.Zhong
     */
    public static String PwdEncode(String source, String key) throws Exception {
        String pwd = null;
        if (null == key || "" == key || null == source || "" == source) {
            throw new Exception("source或key不能为空");
        }
        char[] p = source.toCharArray();
        for (int i = 0; i < p.length; i++) {
            if (p[i] >= 0x80) {
                throw new Exception("source含有无效的字符");
            }
        }
        p = key.toCharArray();
        for (int i = 0; i < p.length; i++) {
            if (p[i] >= 0x80) {
                throw new Exception("key含有无效的字符");
            }
        }
        char[] k = null;
        char[] c = null;
        k = key.toCharArray();
        c = CYHPubKey.toCharArray();
        p = source.toCharArray();
        for (int i = 0,j=0,m=0; i < p.length; i++,j++,m++) {
            if (j > k.length - 1) {
                j=0;
                k = key.toCharArray();
            }
            if (m > c.length - 1) {
                m=0;
                c = CYHPubKey.toCharArray();
            }
            p[i] ^= ((k[j]) ^ (c[m]) ^ 0x80);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p.length; i++) {
            String hex = Integer.toHexString(p[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        pwd = sb.toString();
        return pwd;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(PwdUtil.PwdEncode("123321", "0041091092"));
    }

}

package Test.AddMerInfo;

import java.io.UnsupportedEncodingException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


/**
* @author 作者 :wangbeibei
* @version 创建时间：2019年8月20日 下午7:56:37
* desc:
*/
public class UTFEncode {


    /**
     * @param args在java中调用sun公司提供的3DES加密解密算法时
     *            ，需要使
     *            用到$JAVA_HOME/jre/lib/目录下如下的4个jar包：
     *            jce.jar
     *            security/US_export_policy.jar
     *            security/local_policy.jar
     *            ext/sunjce_provider.jar
     */

    private static final String Algorithm = "DESede"; // 定义加密算法,可用
    // DES,DESede,Blowfish

    // keybyte为加密密钥，长度为24字节

    // src为被加密的数据缓冲区（源）

    public static byte[] encryptMode(byte[] keybyte, byte[] src) {

        try {

            // 生成密钥

            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);

            // 加密

            Cipher c1 = Cipher.getInstance(Algorithm);

            c1.init(Cipher.ENCRYPT_MODE, deskey);

            return c1.doFinal(src);// 在单一方面的加密或解密

        } catch (java.security.NoSuchAlgorithmException e1) {

            // TODO: handle exception

            e1.printStackTrace();

        } catch (javax.crypto.NoSuchPaddingException e2) {

            e2.printStackTrace();

        } catch (java.lang.Exception e3) {

            e3.printStackTrace();

        }

        return null;

    }

    // keybyte为加密密钥，长度为24字节

    // src为加密后的缓冲区

    public static byte[] decryptMode(byte[] keybyte, byte[] src) {

        try {

            // 生成密钥

            SecretKey deskey = new SecretKeySpec(keybyte, Algorithm);

            // 解密

            Cipher c1 = Cipher.getInstance(Algorithm);

            c1.init(Cipher.DECRYPT_MODE, deskey);

            return c1.doFinal(src);

        } catch (java.security.NoSuchAlgorithmException e1) {

            // TODO: handle exception

            e1.printStackTrace();

        } catch (javax.crypto.NoSuchPaddingException e2) {

            e2.printStackTrace();

        } catch (java.lang.Exception e3) {

            e3.printStackTrace();

        }

        return null;

    }

    /*
     * 根据字符串生成密钥字节数组
     * @param keyStr 密钥字符串
     * @return
     * @throws UnsupportedEncodingException
     */
    public static byte[] build3DesKey(String keyStr) throws UnsupportedEncodingException{
        byte[] key = new byte[24];    //声明一个24位的字节数组，默认里面都是0
        byte[] temp = keyStr.getBytes("UTF-8");    //将字符串转成字节数组

        /*
         * 执行数组拷贝
         * System.arraycopy(源数组，从源数组哪里开始拷贝，目标数组，拷贝多少位)
         */
        if(key.length > temp.length){
            //如果temp不够24位，则拷贝temp数组整个长度的内容到key数组中
            System.arraycopy(temp, 0, key, 0, temp.length);
        }else{
            //如果temp大于24位，则拷贝temp数组24个长度的内容到key数组中
            System.arraycopy(temp, 0, key, 0, key.length);
        }
        return key;
    }

    public static byte[] build3DesKey(byte[] temp) throws UnsupportedEncodingException{
        byte[] key = new byte[24];    //声明一个24位的字节数组，默认里面都是0
//        byte[] temp = keyStr.getBytes("UTF-8");    //将字符串转成字节数组
        /*
         * 执行数组拷贝
         * System.arraycopy(源数组，从源数组哪里开始拷贝，目标数组，拷贝多少位)
         */
        if(temp.length < key.length){
            System.arraycopy(temp,0,key,0,16);
            System.arraycopy(temp,0,key,16,8);
        }else{
            System.arraycopy(temp,0,key,0,24);
        }
        return key;
    }

    /**
     * 十六进制转换为二进制
     *
     * @param s
     * @return
     */
    public static byte[] hex2b(String s) {
        return hex2b(s.getBytes(), 0, s.length() >> 1);
    }
    public static byte[] hex2b(byte b[], int offset, int len) {
        byte d[] = new byte[len];
        for (int i = 0; i < len * 2; i++) {
            int shift = i % 2 == 1 ? 0 : 4;
            d[i >> 1] |= Character.digit((char) b[offset + i], 16) << shift;
        }

        return d;
    }
    /**
     * desc:解密
     * <p>创建人：范冬旭, 2016年11月5日 下午9:41:39</p>
     * @param str
     * @return
     */
    public static String getStr(String str){
        byte[] keyBytes=null;
        try {
            keyBytes = UTFEncode.build3DesKey(UTFEncode.hex2b("8E5036DFD29F2383D04DB1DA35F9D6B5"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] reqStr= UTFEncode.hex2b(str);
        byte[] srcBytes = decryptMode(keyBytes, reqStr);
        String result=new String(srcBytes);
        return  result;
    }

    public static String byte2hex(byte b) {
        StringBuilder sb = new StringBuilder();
        int h = (b & 240) >> 4;
        int l = b & 15;
        sb.append(new Character((char) (h <= 9 ? 48 + h : (97 + h) - 10)));
        sb.append(new Character((char) (l <= 9 ? 48 + l : (97 + l) - 10)));
        return sb.toString();
    }

    public static String byte2hex(byte buf[]) {
        StringBuffer sb = new StringBuffer(2 * buf.length);
        for (int i = 0; i < buf.length; i++)
            sb.append(byte2hex(buf[i]));

        return sb.toString();
    }

    /**
     * desc:加密
     * <p>创建人：范冬旭, 2016年11月5日 下午9:41:48</p>
     * @param str
     * @return
     * @throws UnsupportedEncodingException 
     */
    public static String encode(String str) throws UnsupportedEncodingException{
        byte[] keyBytes=null;
        try {
            keyBytes = UTFEncode.build3DesKey(UTFEncode.hex2b("8E5036DFD29F2383D04DB1DA35F9D6B5"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] encoded = encryptMode(keyBytes, str.getBytes("UTF-8"));
        String encodeStr=UTFEncode.byte2hex(encoded);
        return encodeStr;
    }
    public static void main(String[] args) throws UnsupportedEncodingException {
        String aa="你好";
        System.out.println("加密后的字符串:" + encode(aa));
        try {
			System.out.println("解密后:" + getStr("c57f06df75d32ffb66eb851b15799dd936e0465f3144eb605024cc317e386470c65cabf468f25af8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
    }


}

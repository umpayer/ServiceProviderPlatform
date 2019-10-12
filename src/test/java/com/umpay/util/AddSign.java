package com.umpay.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umpay.demo.step0_准备工作.EnvConfig;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * Hello world!
 *
 */
public class AddSign
{
    public static String privateKey = EnvConfig.privateKey;	//商户私钥

    public static String certFilePath = EnvConfig.serverCert;	//联动证书

    public static void main( String[] args )
    {
        String aa ="{\"respCode\":\"00\",\"respMsg\":\"处理成功\",\"signature\":\"rhQeeSpv9E80c3FS0etJDdN/WlPwtSJUXXSp1m1brNbnyik0xJqp9eJKo8doVOlgxkKpS2ent2s+s9y2WhPud51QUMld8SESOvF0vgb2k/HarO6BbZSt2Cl+/4T5L6lNvcPTeUMlBq2vZ4b58tPzrsoeDohiaX4ku/+a7XEBN1k=\",\"platDate\":\"20191008102237\",\"orderNo\":\"20191008102235\",\"transactionId\":\"2019100810220000072703\",\"txnAmt\":\"1\",\"qrCode\":\"https://qr.alipay.com/bax07439jyn80w0qn73f80c0\"}";
        boolean ss =doCheckSign(aa);
        System.out.println(ss);
    }

    /**
     * 加签
     * @param reqMap
     * @return
     * @throws UnsupportedEncodingException
     * @throws GeneralSecurityException
     * @throws IOException
     */
    public static String addSign(TreeMap<String, Object> reqMap) throws UnsupportedEncodingException, GeneralSecurityException, IOException{
        reqMap.remove("signature");
        //获取原请求签名
        String signStr    = new StringBuilder(reqMap.toString().replace(", ", "&").replace("{", "").replace("}", "")).toString();//【待签名明文串】--signStr
//        System.out.println("待签名明文串:" + signStr);
        // 验签

        String sign = CertUtils.sign(signStr, CertUtils.getPrivateKey(privateKey),"UTF-8");//【签名密文串】--sign
//        System.out.println("签名密文串:" + sign);

        reqMap.put("signature", sign);
        //【最终报文串】--res
        String res=JSON.toJSONString(reqMap);
//        System.out.println("最终报文串："+ res);
        return res;
    }

    /**
     * 验签
     * @param object
     * @return
     */
    @SuppressWarnings("unchecked")
    public static boolean doCheckSign(String object) {
        Map<String, Object> treeMap = JSON.parseObject(JSON.toJSONString(JSON.parse(object)), TreeMap.class);
        // 【响应的签名】
        String signKey = (String) treeMap.get("signature");
        treeMap.remove("signature");
        // 【待签明文串】--去除响应签名后获取待签明文串
        StringBuilder sb = new StringBuilder();
        assemSign(treeMap, sb);

        sb.deleteCharAt(sb.length() - 1);
        String befSgin = sb.toString();
        //【验签】
        boolean signresult = false;
        try {
            signresult = SignTools.doCheckSign(certFilePath, befSgin, signKey);
        } catch (Exception e) {
            System.out.println("验签异常");
        }
        //【 验签结果】
        return signresult;
    }

    private static void assemSign(Map<String, Object> treeMap, StringBuilder sb) {
        for (String key : treeMap.keySet()) {
            if(treeMap.get(key) instanceof JSONObject){
                JSONObject js=(JSONObject) treeMap.get(key);
                TreeMap<String, Object> tmap = JSON.parseObject(js.toJSONString(), TreeMap.class);
                assemSign(tmap, sb);
            }else {
                if(null != treeMap.get(key) && !"".equals(treeMap.get(key))){
                    sb.append(treeMap.get(key)).append("|");
                }

            }
        }
    }
}

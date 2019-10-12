package com.umpay.call;

import java.util.Map;
import java.util.TreeMap;

import com.alibaba.fastjson.JSON;
import com.umpay.demo.step0_准备工作.EnvConfig;
import com.umpay.util.TimeUtil;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;
import com.umpay.util.AddSign;
import com.umpay.util.HttpUtilClient;

/**
 * 审核商户开户接口测试类
 */
public class AuditMer {

    public String queryUrl = EnvConfig.url + "test/auditMer";

    private static String acqMerId = (String) EnvConfig.context.get("acqMerId");

    @SuppressWarnings("unchecked")
    @Test
    public void auditMer() throws Exception{
        TreeMap<String, Object> reqPay = new TreeMap<String, Object>();
        reqPay.put("acqMerId", acqMerId);
        reqPay.put("acqSpId", EnvConfig.acqSpId);
        reqPay.put("funCode", "ALIVE");

        reqPay.put("nopassFlag", "true");
        reqPay.put("rpid", TimeUtil.date("yyyyMMddHHmmSSSSS"));
        reqPay.put("merChantType", "3");
        reqPay.put("nopassid", "");
        reqPay.put("nopassinfo", "");
        reqPay.put("userName", "");

        //对请求报文做加签处理
//        String reqpay = AddSign.addSign(reqPay);
//        Map<String, Object> reqMap = JSONObject.parseObject(reqpay);

        try{
            //发送post请求
            String result = HttpUtilClient.doPostJson(queryUrl, new JSONObject(), reqPay);
            System.out.println("输出请求结果:"+result);

            //将响应报文转成map
            Map<String, Object> resMap = JSON.parseObject(result, TreeMap.class);
            String respCode = (String) resMap.get("respCode");
            if ("0000".equals(respCode)) {
                //开户成功
                Assert.assertTrue("审核商户开户成功", true);
            }else{
                //开户失败
                String respMsg = (String) resMap.get("respMsg");
                Assert.assertTrue("审核商户开户失败：" + respMsg, false);
            }
        }catch (Exception e) {
            Assert.assertTrue("审核商户开户异常", false);
        }


    }
}

package com.umpay.call;

import java.util.Map;
import java.util.TreeMap;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umpay.util.HttpUtilClient;
import org.junit.Assert;
import org.junit.Test;

import com.umpay.demo.step0_准备工作.EnvConfig;

public class VerifyCode extends BaseAPI{

    public String queryUrl = EnvConfig.url + "test/verifyCode";

	@SuppressWarnings("unchecked")
	@Test
	public void getVerifyCode() throws Exception{
		TreeMap<String, Object> reqPay = new TreeMap<String, Object>();
		String merid= (String) EnvConfig.context.get("merId");
		reqPay.put("merId", merid);

		try{
			//发送post请求
			String result = HttpUtilClient.doPostJson(queryUrl, new JSONObject(), reqPay);
			System.out.println("输出请求结果:"+result);

			//将响应报文转成map
			Map<String, Object> resMap = JSON.parseObject(result, TreeMap.class);
			String respCode = (String) resMap.get("respCode");
			if ("0000".equals(respCode)) {
				String VERIFYCODE = (String) resMap.get("respMsg");
				EnvConfig.context.put("verifyCode", VERIFYCODE);

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

	public static void main(String[] args) throws Exception {
		EnvConfig.context.put("merId", "M2019092700001137");
		VerifyCode doheandel2=new VerifyCode();
		doheandel2.getVerifyCode();

	}

}

package com.umpay.demo.step5_交易撤销_退费;

import com.alibaba.fastjson.JSONObject;
import com.umpay.util.AddSign;
import com.umpay.util.HttpUtilClient;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

/**
 * description: 退费查询接口测试类
 * author: zhanghuanqi
 * date: 2019/8/19
 * time: 下午4:18
 */
public class RefundQueryAPI {
//	public String queryUrl ="http://106.120.215.230:8011/entry-provider-plat-client/pay/refundQuery";
	public String queryUrl ="http://10.10.55.66:6904/pay/refundQuery";
	

	@SuppressWarnings("unchecked")
	@Test
	public void refundQuery() throws Exception{
		TreeMap<String, Object> reqPay = new TreeMap<String, Object>();
		reqPay.put("acqSpId", "Y471790403");//代理商编号	10	M	代理商编号(联动平台分配)
		reqPay.put("acqMerId", "41509208");//商户号	8	M	商户号(联动平台分配)
		reqPay.put("orderNo", "JD201908190417440001");//商户订单号	64	M	商户的支付订单号
		reqPay.put("signature", "");
		
		//对请求报文做加签处理
		String reqpay = AddSign.addSign(reqPay);
		Map<String, Object> reqMap = JSONObject.toJavaObject(JSONObject.parseObject(reqpay), Map.class);

		//发送post请求
		String result = HttpUtilClient.doPostJson(queryUrl, new JSONObject(), reqMap);
		System.out.println("输出请求结果:"+result);
	}
	
}

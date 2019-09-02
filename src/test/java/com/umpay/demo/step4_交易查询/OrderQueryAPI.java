package com.umpay.demo.step4_交易查询;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;
import org.testng.Assert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umpay.util.AddSign;
import com.umpay.util.HttpUtilClient;

/**
 * @author: zhangjing
 * @date:2019年8月6日 下午2:30:09
 * @类说明:订单查询接口
 * @产品号:
 */
public class OrderQueryAPI {
	//public String queryUrl ="http://106.120.215.230:8011/entry-provider-plat-client/pay/queryOrder";
	public String queryUrl ="http://10.10.55.66:6904/pay/queryOrder";
	
	@Test
	@SuppressWarnings("unchecked")
	public void orderQuery() throws Exception{
		TreeMap<String, Object> reqPay = new TreeMap<String, Object>();
		reqPay.put("acqSpId", "Y471790403");//代理商编号	10	M	代理商编号(联动平台分配)
		reqPay.put("acqMerId", "41509208");//商户号	8	M	商户号(联动平台分配)
		reqPay.put("orderNo", "JD201908190346410001");//商户订单号	64	M	商户的支付订单号
		reqPay.put("transactionId", "");//联动订单号	32	O	联动优势的订单号，建议优先使用	
		reqPay.put("signature", "");	
		
		//对请求报文做加签处理
		String reqpay = AddSign.addSign(reqPay);
		Map<String, Object> reqMap = JSONObject.toJavaObject(JSONObject.parseObject(reqpay), Map.class);

		//发送post请求
		String result = HttpUtilClient.doPostJson(queryUrl, new JSONObject(), reqMap);
		System.out.println("输出请求结果:"+result);
		
		//将响应报文转成map
		Map<String, Object> treeMap = JSON.parseObject(result, TreeMap.class);		
		Assert.assertEquals(treeMap.get("respCode"), "00");
		Assert.assertEquals(treeMap.get("respMsg"), "处理成功");
	}

}

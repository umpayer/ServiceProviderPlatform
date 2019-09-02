package com.umpay.demo.step5_交易撤销_退费;

import com.alibaba.fastjson.JSONObject;
import com.umpay.util.AddSign;
import com.umpay.util.Common;
import com.umpay.util.HttpUtilClient;
import com.umpay.util.TimeUtil;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

/**
 * description: 退费接口测试类
 * author: zhanghuanqi
 * date: 2019/8/19
 * time: 下午3:59
 */
public class RefundAPI {
	//public String queryUrl ="http://106.120.215.230:8011/entry-provider-plat-client/pay/refund";
	public String queryUrl ="http://10.10.55.66:6904/pay/refund";
	

	@SuppressWarnings("unchecked")
	@Test
	public void refund() throws Exception{
		TreeMap<String, Object> reqPay = new TreeMap<String, Object>();
		reqPay.put("orderTime", TimeUtil.datetime14());//订单时间	16	M	yyyyMMddHHmms
		reqPay.put("acqSpId", "Y471790403");//代理商编号	10	M	代理商编号(联动平台分配)
		reqPay.put("acqMerId", "41509208");//商户号	8	M	商户号(联动平台分配)
		reqPay.put("origOrderNo", "JD201908190402060001");//原单流水号	64	M	原交易的订单号
		reqPay.put("origTxnAmt", "1");//原单交易金额	13	M	单位:原交易的总金额
		reqPay.put("orderNo", Common.genOrderId());//退款流水号	64	M	本次退货交易的订单号
		reqPay.put("txnAmt", "1");//退款金额	13	M	本次退货的金额
		reqPay.put("signature", "");
		
		//对请求报文做加签处理
		String reqpay = AddSign.addSign(reqPay);
		Map<String, Object> reqMap = JSONObject.toJavaObject(JSONObject.parseObject(reqpay), Map.class);

		//发送post请求
		String result = HttpUtilClient.doPostJson(queryUrl, new JSONObject(), reqMap);
		System.out.println("输出请求结果:"+result);
		
	}

}

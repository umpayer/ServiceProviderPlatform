package com.umpay.demo.step2_入网成功配置参数;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Map;
import java.util.TreeMap;

import com.alibaba.fastjson.JSON;
import com.umpay.demo.step0_准备工作.EnvConfig;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSONObject;
import com.umpay.util.AddSign;
import com.umpay.util.Common;

/**
 * @author: zhangjing
 * @date:2019年8月6日 下午4:54:02
 * @类说明:
 * @产品号:
 */
public class API_5微信参数配置_子商户appid {
	private String payUrl = EnvConfig.url + "merchants/subAppid";
	/** 商户号，由商户信息录入成功后返回信息 */
	private static String merId = (String) EnvConfig.context.get("merId");

	@Test
	public void config_子商户appid() throws UnsupportedEncodingException, GeneralSecurityException, IOException{
		TreeMap<String, Object> reqPay = new TreeMap<String, Object>();
		reqPay.put("acqSpId", EnvConfig.acqSpId);//代理商编号	10	M	代理商编号(联动平台分配)
		reqPay.put("acqMerId", merId);//商户编号	8	C	merId和acqMerId至少存在一个
		reqPay.put("subAppid", "");//子商户SubAPPID
		reqPay.put("signature", "");

		String reqpay = AddSign.addSign(reqPay);
		JSONObject jsonObject1 =JSONObject.parseObject(reqpay);


		try{
			//发送post请求
			String result = Common.runJsonPost(payUrl, jsonObject1,"UTF-8");
			System.out.println("输出请求结果:"+result);

			//将响应报文转成map
			Map<String, Object> resMap = JSON.parseObject(result, TreeMap.class);
			String respCode = (String) resMap.get("respCode");
			if ("00".equals(respCode)) {
				String merId = (String) resMap.get("merId");
				EnvConfig.context.put("merId", merId);
				//开户成功
				Assert.assertTrue("微信参数配置_子商户appid成功", true);
			}else{
				//开户失败
				String respMsg = (String) resMap.get("respMsg");
				Assert.assertTrue("微信参数配置_子商户appid失败：" + respMsg, false);
			}
		}catch (Exception e) {
			Assert.assertTrue("微信参数配置_子商户appid异常", false);
		}
	}
}

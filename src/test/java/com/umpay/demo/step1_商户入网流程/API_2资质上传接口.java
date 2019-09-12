package com.umpay.demo.step1_商户入网流程;

import com.umpay.demo.step0_准备工作.EnvConfig;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class API_2资质上传接口 extends API_2资质上传接口parent {

	public static void main(String[] args) throws Exception {
		API_2资质上传接口 group = new API_2资质上传接口();
		//小微
		group.test_小微();
		//个休
		//group.test_个体_企业商户();
	}
	/**
	 * @throws Exception 
	 * @Description: 自然人 流程
	 * @date 2019年8月16日 下午3:20:58
	 */
	@Test
	public void test_小微() throws Exception {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("acqSpId", EnvConfig.acqSpId);
		paramMap.put("merId", merId);

		try{
			//1、上传身份证正面
			test_idCardFront(paramMap);
			System.out.println("2.2.1资质上传接口_小微:身份证正面上传成功！");

			//2、上传身份证反面
			test_idCardBack(paramMap);
			System.out.println("2.2.2资质上传接口_小微:身份证反面上传成功！");

			//3、签约授权书
			test_signAuthLetterPhoto(paramMap);
			System.out.println("2.2.3资质上传接口_小微:签约授权书上传成功！");

			//4、上传银行卡正面
			test_bankCardPhotoFront(paramMap);
			System.out.println("2.2.4资质上传接口_小微:银行卡正面上传成功！");

			//5、上传银行卡反面
			test_bankCardPhotoBack(paramMap);
			System.out.println("2.2.5资质上传接口_小微:银行卡反面上传成功！");

			//6、签约授权书
			test_signAuthLetterPhoto(paramMap);
			System.out.println("2.2.6资质上传接口_小微:签约授权书上传成功！");

			//门店门头照
			test_storeHeadPhoto(paramMap);
			System.out.println("2.2.7资质上传接口_小微:门店门头照上传成功！");

			//门店外景照
			test_storeShopPhoto(paramMap);
			System.out.println("2.2.8资质上传接口_小微:门店外景照上传成功！");

			//门店内景照
			test_storeHallPhoto(paramMap);
			System.out.println("2.2.9资质上传接口_小微:门店内景照上传成功！");

			//门店收银台照
			test_storeCashierPhoto(paramMap);
			System.out.println("2.2.10资质上传接口_小微:门店收银台照上传成功！");

		}catch (Exception e) {
			Assert.assertTrue(e.getMessage(), false);
		}
		Assert.assertTrue("资质上传成功", true);

	}
	
	/**
	 * @throws Exception 
	 * @Description: 个体+企业商户 流程
	 * @date 2019年8月16日 下午3:20:58
	 */
	@Test
	public void test_个体_企业商户() throws Exception {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("acqSpId", EnvConfig.acqSpId);
		paramMap.put("merId", merId);

		try{
			//1、上传身份证正面
			test_idCardFront(paramMap);
			System.out.println("2.2.1资质上传接口_个体_企业商户:身份证正面上传成功！");

			//2、上传身份证反面
			test_idCardBack(paramMap);
			System.out.println("2.2.2资质上传接口_个体_企业商户:身份证反面上传成功！");

			//3、签约授权书
			test_signAuthLetterPhoto(paramMap);
			System.out.println("2.2.3资质上传接口_个体_企业商户:签约授权书上传成功！");

			//4、上传银行卡正面
			test_bankCardPhotoFront(paramMap);
			System.out.println("2.2.4资质上传接口_个体_企业商户:银行卡正面上传成功！");

			//5、上传银行卡反面
			test_bankCardPhotoBack(paramMap);
			System.out.println("2.2.5资质上传接口_个体_企业商户:银行卡反面上传成功！");

			//6、营业执照照片
			test_businessLicensePhoto(paramMap);
			System.out.println("2.2.6资质上传接口_个体_企业商户:营业执照照片上传成功！");
		}catch (Exception e) {
			Assert.assertTrue(e.getMessage(), false);
		}
		Assert.assertTrue("资质上传成功", true);
	}
}

package com.umpay.demo.step1_商户入网流程;

import com.alibaba.fastjson.JSON;
import com.umpay.call.BaseAPI;
import com.umpay.demo.step0_准备工作.EnvConfig;
import com.umpay.util.HttpUtilClient;
import com.umpay.util.StringUtil;
import com.umpay.util.TimeUtil;
import org.springframework.util.Base64Utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

/**
 * @ClassName: ImageInput 
 * @Description: 资质上传接口 
 * {交易服务根地址}/merchant/qualification
 * @author Zengfu Jiang
 * @date 2019年8月7日 下午6:05:34
 */
public class API_2资质上传接口parent extends BaseAPI {

	private String filePath_资质 = EnvConfig.filePath_资质;

	/**
	 * @param paramMap 
	 * @throws Exception 
	 * @Description: 身份证正面上传测试类
	 * @date 2019年8月14日 下午12:57:18
	 */
	public void test_idCardFront(Map<String, Object> paramMap) throws Exception {
		String filePath = filePath_资质 + "//idCardFront.jpg";
		paramMap.put("imageType", "idCardFront");
		paramMap.put("imageName", "idCard_front.jpg");
		String resCode = sendData("身份证正面上传",filePath,"/upload/qualification",paramMap);
		if (!"00".equals(resCode)) {
			throw new Exception("身份证正面上传失败，流程中止！");
		}
	}
	/**
	 * @param paramMap
	 * @throws Exception 
	 * @Description: 身份证背面上传测试类
	 * @date 2019年8月14日 下午1:00:11
	 */
	public void test_idCardBack(Map<String, Object> paramMap) throws Exception {
		String filePath = filePath_资质 + "//idCardBack.jpg";
		paramMap.put("imageType", "idCardBack");
		paramMap.put("imageName", "idCard_back.jpg");
		String resCode = sendData("身份证背面上传",filePath,"/upload/qualification",paramMap);
		if (!"00".equals(resCode)) {
			throw new Exception("身份证背面上传失败，流程中止！");
		}
	}
	/**
	 * @param paramMap
	 * @throws Exception 
	 * @Description: 法人手持身份证上传测试类
	 * @date 2019年8月14日 下午1:00:11
	 */
	
	public void test_idCardHandle(Map<String, Object> paramMap) throws Exception {
		String filePath = filePath_资质 + "//idCardHandle.jpg";
		paramMap.put("imageType", "idCardHandle");
		paramMap.put("imageName", "idCardHandle.jpg");
		String resCode = sendData("法人手持身份证上传",filePath,"/upload/qualification",paramMap);
		if (!"00".equals(resCode)) {
			throw new Exception("法人手持身份证上传失败，流程中止！");
		}
	}
	/**
	 * @param paramMap
	 * @throws Exception 
	 * @Description: 银行卡正面上传测试类
	 * @date 2019年8月14日 下午1:00:11
	 */
	
	public void test_bankCardPhotoFront(Map<String, Object> paramMap) throws Exception {
		String filePath = filePath_资质 + "//bankCardPhotoFront.jpg";
		paramMap.put("imageType", "bankCardPhotoFront");
		paramMap.put("imageName", "bankCardPhotoFront.jpg");
		String resCode = sendData("银行卡正面上传",filePath,"/upload/qualification",paramMap);
		if (!"00".equals(resCode)) {
			throw new Exception("银行卡正面上传失败，流程中止！");
		}
	}
	/**
	 * @param paramMap
	 * @throws Exception 
	 * @Description: 银行卡背面上传测试类
	 * @date 2019年8月14日 下午1:00:11
	 */
	
	public void test_bankCardPhotoBack(Map<String, Object> paramMap) throws Exception {
		String filePath = filePath_资质 + "//bankCardPhotoBack.jpg";
		paramMap.put("imageType", "bankCardPhotoBack");
		paramMap.put("imageName", "bankCardPhotoBack.jpg");
		String resCode = sendData("银行卡背面上传",filePath,"/upload/qualification",paramMap);
		if (!"00".equals(resCode)) {
			throw new Exception("银行卡背面上传失败，流程中止！");
		}
	}
	/**
	 * @param paramMap
	 * @throws Exception 
	 * @Description: 开户许可证上传测试类
	 * @date 2019年8月14日 下午1:00:11
	 */
	
	public void test_openingLicenseAccountPhoto(Map<String, Object> paramMap) throws Exception {
		String filePath = filePath_资质 + "//openingLicenseAccountPhoto.jpg";
		paramMap.put("imageType", "openingLicenseAccountPhoto");
		paramMap.put("imageName", "openingLicenseAccountPhoto.jpg");
		String resCode = sendData("开户许可证上传",filePath,"/upload/qualification",paramMap);
		if (!"00".equals(resCode)) {
			throw new Exception("开户许可证上传失败，流程中止！");
		}
	}
	/**
	 * @param paramMap
	 * @throws Exception 
	 * @Description: 商户收单协议照片上传测试类
	 * @date 2019年8月14日 下午1:00:11
	 */
	
	public void test_acquiringAgreementPhoto(Map<String, Object> paramMap) throws Exception {
		String filePath = filePath_资质 + "//acquiringAgreementPhoto.jpg";
		paramMap.put("imageType", "acquiringAgreementPhoto");
		paramMap.put("imageName", "acquiringAgreementPhoto.jpg");
		String resCode = sendData("商户收单协议照片上传",filePath,"/upload/qualification",paramMap);
		if (!"00".equals(resCode)) {
			throw new Exception("商户收单协议照片上传失败，流程中止！");
		}
	}
	/**
	 * @param paramMap
	 * @throws Exception 
	 * @Description: 签约授权书上传测试类
	 * @date 2019年8月14日 下午1:00:11
	 */
	
	public void test_signAuthLetterPhoto(Map<String, Object> paramMap) throws Exception {
		String filePath = filePath_资质 + "//signAuthLetterPhoto.jpg";
		paramMap.put("imageType", "signAuthLetterPhoto");
		paramMap.put("imageName", "signAuthLetterPhoto.jpg");
		String resCode = sendData("签约授权书上传",filePath,"/upload/qualification",paramMap);
		if (!"00".equals(resCode)) {
			throw new Exception("签约授权书上传失败，流程中止！");
		}
	}
	/**
	 * @param paramMap
	 * @throws Exception 
	 * @Description: 营业执照照片上传测试类
	 * @date 2019年8月14日 下午1:00:11
	 */
	
	public void test_businessLicensePhoto(Map<String, Object> paramMap) throws Exception {
		String filePath = filePath_资质 + "//businessLicensePhoto.jpg";
		paramMap.put("imageType", "businessLicensePhoto");
		paramMap.put("imageName", "businessLicensePhoto.jpg");
		String resCode = sendData("营业执照照片上传",filePath,"/upload/qualification",paramMap);
		if (!"00".equals(resCode)) {
			throw new Exception("营业执照照片上传失败，流程中止！");
		}
	}
	/**
	 * @param paramMap
	 * @throws Exception 
	 * @Description: 门店门头照上传测试类
	 * @date 2019年8月14日 下午1:00:11
	 */
	
	public void test_storeHeadPhoto(Map<String, Object> paramMap) throws Exception {
		String filePath = filePath_资质 + "//storeHeadPhoto.jpg";
		paramMap.put("imageType", "storeHeadPhoto");
		paramMap.put("imageName", "storeHeadPhoto.jpg");
		String resCode = sendData("门店门头照上传",filePath,"/upload/qualification",paramMap);
		if (!"00".equals(resCode)) {
			throw new Exception("门店门头照上传失败，流程中止！");
		}
	}
	/**
	 * @param paramMap
	 * @throws Exception 
	 * @Description: 门店外景照上传测试类
	 * @date 2019年8月14日 下午1:00:11
	 */
	
	public void test_storeShopPhoto(Map<String, Object> paramMap) throws Exception {
		String filePath = filePath_资质 + "//storeShopPhoto.jpg";
		paramMap.put("imageType", "storeShopPhoto");
		paramMap.put("imageName", "storeShopPhoto.jpg");
		String resCode = sendData("门店外景照上传",filePath,"/upload/qualification",paramMap);
		if (!"00".equals(resCode)) {
			throw new Exception("门店外景照上传失败，流程中止！");
		}
	}
	/**
	 * @param paramMap
	 * @throws Exception 
	 * @Description: 门店内景照上传测试类
	 * @date 2019年8月14日 下午1:00:11
	 */
	
	public void test_storeHallPhoto(Map<String, Object> paramMap) throws Exception {
		String filePath = filePath_资质 + "//storeHallPhoto.jpg";
		paramMap.put("imageType", "storeHallPhoto");
		paramMap.put("imageName", "storeHallPhoto.jpg");
		String resCode = sendData("门店内景照上传",filePath,"/upload/qualification",paramMap);
		if (!"00".equals(resCode)) {
			throw new Exception("门店内景照上传失败，流程中止！");
		}
	}
	/**
	 * @param paramMap
	 * @throws Exception 
	 * @Description: 门店收银台照上传测试类
	 * @date 2019年8月14日 下午1:00:11
	 */
	
	public void test_storeCashierPhoto(Map<String, Object> paramMap) throws Exception {
		String filePath = filePath_资质 + "//storeCashierPhoto.jpg";
		paramMap.put("imageType", "storeCashierPhoto");
		paramMap.put("imageName", "storeCashierPhoto.jpg");
		String resCode = sendData("门店收银台照上传",filePath,"/upload/qualification",paramMap);
		if (!"00".equals(resCode)) {
			throw new Exception("门店收银台照上传失败，流程中止！");
		}
	}
	
	/**
	 * @Description: 统一请求上传接口方法
	 * @date 2019年8月14日 下午12:57:49 
	 * @param desc 描述，说明是哪个功能调用
	 * @param filePath	图片路径
	 * @param urlFuncode 请求的前置功能码
	 * @param paramMap	各独自请求参数
	 * @return	响应结果
	 */
	private String sendData(String desc,String filePath,String urlFuncode, Map<String, Object> paramMap) {
		String reqUrl = EnvConfig.url+urlFuncode;
		String resCode = "";
		try {
			File originalFile = new File(filePath);//指定要读取的图片
			FileInputStream in = new FileInputStream(originalFile);
			//写入相应的文件
			ByteArrayOutputStream outByte = new ByteArrayOutputStream();
			int n = 0;
			while((n=in.read())!=-1){
				 //写入相关文件
	            outByte.write(n);
			}
			paramMap.put("funCode", "PROVIDER_PERSONMERADD");
			paramMap.put("rpid", "JZF"+TimeUtil.datetime14());
			paramMap.put("reqDate", TimeUtil.date8());
			paramMap.put("reqTime", TimeUtil.time6());
//			System.out.println(desc+"请求参数："+paramMap);
			String bStr = Base64Utils.encodeToString(outByte.toByteArray());
			paramMap.put("imageSource", bStr);
			String resMSg= HttpUtilClient.doPostJson(reqUrl, null, paramMap);
//			System.out.println(desc+"响应报文"+resMSg);
			//执行完以上后，磁盘下的该文件才完整，大小是实际大小
			in.close();
			outByte.close();
			Map maps = (Map)JSON.parse(resMSg);
			if (maps.get("respCode")!=null) {
				resCode = StringUtil.trim(maps.get("respCode"));
			}
		}catch (Exception e3) {
			e3.printStackTrace();
		}
		return resCode;
	}

	private String getImagePath() {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File dir = new File(classpathRoot,"");//项目所在根目录
		String imagePath = dir.getAbsolutePath() + "/image/";
		return imagePath;
	}

	public static void main(String[] args) throws Exception {
		API_2资质上传接口parent group = new API_2资质上传接口parent();
		String image = group.getImagePath();
		System.out.println(image);
	}
}

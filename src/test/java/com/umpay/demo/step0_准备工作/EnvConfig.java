package com.umpay.demo.step0_准备工作;

import com.umpay.util.ConfigUtil;
import com.umpay.util.StringUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 环境配置
 */
public class EnvConfig {

    public static final String url = ConfigUtil.getConfig("umpayUrl");
    public static final String acqSpId = ConfigUtil.getConfig("acqSpId");
    public static final String signMobileNo = ConfigUtil.getConfig("signMobileNo");

    public static final String filePath_资质 = ConfigUtil.getConfig("filePath");

    public static final String privateKey = ConfigUtil.getConfig("privateKey");
    public static final String serverCert = ConfigUtil.getConfig("serverCert");

    public static Map context = new HashMap();

    static{
        /** TODO 不依赖上下文调试时在此处赋值 */
        context.put("merId", "M2019090400000478");//报备编号M2019082000000270
        context.put("verifyCode", "098500");//挑战码
        context.put("acqMerId", "42516662");//商户号
//        context.put("orderNo", "JD201909030945440001");//订单号
//        context.put("refundOrderNo", "JD201909030945440001");//退费订单号
    }

    /**
     * 检查初始化配置
     * 1、检查调用联调服务器地址url
     * 2、检查是否配置商户私钥
     * 3、检查是否配置联动公钥
     * 4、检查其他配置参数
     * @throws Exception
     */
    @Test
    public void initConfig() throws Exception {
        System.out.println("1-检查配置信息开始----------start：");

        //1、检查调用联调服务器地址url
        System.out.println("1.1检查调用联调服务器地址url开始----------start：");
        checkUrl();
        System.out.println("1.1检查调用联调服务器地址url成功----------success：");

        //2、检查是否配置商户私钥
        System.out.println("1.2检查商户私钥开始----------start：");
        checkPrivateKey();
        System.out.println("1.2检查商户私钥成功----------success：");

        //3、检查是否配置联动公钥
        System.out.println("1.3检查联动公钥开始----------start：");
        checkServerCert();
        System.out.println("1.3检查联动公钥成功----------success：");

        //4、检查其它初始化配置参数
        System.out.println("1.4检查其它初始化配置参数开始----------start：");
        checkInitConfig();
        System.out.println("1.4检查其它初始化配置参数成功----------success：");

        System.out.println("1-检查配置信息成功始----------success：");
        System.out.println("==================================================================================");
    }

    private void checkUrl() {
        //TODO 修改config/dev.properties文件umpayUrl参数以及其它参数
        boolean urlFlag = false;
        if (StringUtil.isEmpty(EnvConfig.url)) {
            Assert.assertTrue("请在dev.properties配置umpayUrl参数（调用服务器地址）：联调环境地址请联系联动开发人员获取", urlFlag);
        }
    }

    private void checkPrivateKey() {
        boolean privateKeyFlag = false;
        if (StringUtil.isEmpty(EnvConfig.privateKey)) {
            Assert.assertTrue("请在dev.properties配置privateKey参数（商户私钥）：商户私钥文件请联系联动开发人员获取", privateKeyFlag);
        }
        File file = new File(EnvConfig.privateKey);
        if (!file.exists()) {
            Assert.assertTrue("请把商户私钥文件放入cert文件中", privateKeyFlag);
        }
    }

    private void checkServerCert() {
        //TODO 在cert文件下导入联动公钥
        boolean serverCertFlag = false;
        if (StringUtil.isEmpty(EnvConfig.serverCert)) {
            Assert.assertTrue("请在dev.properties配置serverCert参数（联动公钥）：联动公钥文件请联系联动开发人员获取", serverCertFlag);
        }
        File file = new File(EnvConfig.serverCert);
        if (!file.exists()) {
            Assert.assertTrue("请把联动公钥文件放入cert文件中", serverCertFlag);
        }
    }


    private void checkInitConfig() {
        boolean initConfigFlag = false;
        if (StringUtil.isEmpty(EnvConfig.acqSpId)) {
            Assert.assertTrue("请在dev.properties配置acqSpId参数（服务商id）：服务商id请联系联动开发人员获取", initConfigFlag);
        }

        if (StringUtil.isEmpty(EnvConfig.filePath_资质)) {
            Assert.assertTrue("请在dev.properties配置filePath参数（资质文件地址）：资质文件地址配置到本地image路径", initConfigFlag);
        }

        if (StringUtil.isEmpty(EnvConfig.signMobileNo)) {
            Assert.assertTrue("请在dev.properties配置signMobileNo参数（签约手机号）：签约手机号是接收验证码的对应手机号", initConfigFlag);
        }
    }

}

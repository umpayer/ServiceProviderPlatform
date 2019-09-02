package com.umpay.demo.step0_准备工作;

import com.umpay.util.ConfigUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 环境配置
 */
public class EnvConfig {

    public static final String url = ConfigUtil.getConfig("umpayUrl");
    public static final String acqSpId = ConfigUtil.getConfig("acqSpId");

    public static final String filePath_资质 = ConfigUtil.getConfig("filePath");

    public static Map context = new HashMap();

    static{
        /** TODO 不依赖上下文调试时在此处赋值 */
//        context.put("merId", "M2019082000000270");//商户号
    }

    /**
     * 初始化配置
     * 1、设置服务器地址url
     * 2、配置商户私钥
     * 3、配置联动公钥
     * @throws Exception
     */
    @Test
    public void initConfig() throws Exception {
        //TODO 修改config/dev.properties文件umpayUrl参数以及其它参数
        //配置好地址后更改为:true
        boolean urlFlag = true;
        //1、设置服务器地址url
        Assert.assertTrue("请配置调用服务器地址", urlFlag);

        //TODO 在cert文件下导入商户私钥
        //配置好地址后更改为:true
        boolean privateKeyFlag = true;
        //2、配置商户私钥
        Assert.assertTrue("请配置商户私钥", privateKeyFlag);

        //TODO 在cert文件下导入联动公钥
        //配置好地址后更改为:true
        boolean serverCertFlag = true;
        //3、配置联动公钥
        Assert.assertTrue("配置联动公钥", serverCertFlag);


    }
}

package com.umpay.jnuit;

import com.umpay.call.VerifyCode;
import org.junit.Test;

import com.umpay.call.AuditMer;
import com.umpay.demo.step0_准备工作.EnvConfig;
import com.umpay.demo.step1_商户入网流程.API_1商户信息录入;
import com.umpay.demo.step1_商户入网流程.API_2资质上传接口;
import com.umpay.demo.step1_商户入网流程.API_6_7电子签约;
import com.umpay.demo.step2_入网成功配置参数.API_3商户信息查询;
import com.umpay.demo.step2_入网成功配置参数.API_4微信参数配置_支付授权目录;
import com.umpay.demo.step2_入网成功配置参数.API_5微信参数配置_子商户appid;
import com.umpay.demo.step2_入网成功配置参数.API_8电子协议下载;
import com.umpay.util.ConfigUtil;

/**
 * 入网整体流程测试用例执行
 */
public class step1_入网相关接口用例 {

    /**
     * 入网相关接口用例
     * 1、准备工作检查
     * 2、调用商户入网流程
     *  2.1、入网成功调用商户审核流程
     * 3、调用入网成功配置参数
     * @throws Exception
     */
    @Test
    public void test_商户入网() throws Exception {
        //1、准备工作检查
        new EnvConfig().initConfig();
        EnvConfig.context.clear();

        //2、调用商户入网流程
        callMerNetIn();

        //2.1、入网成功调用商户审核流程
        //TODO 联系联动审核该入网商户
        new API_3商户信息查询().queryOrder_商户信息查询();
        System.out.println("3-商户审核流程开始----------start：");
        new AuditMer().auditMer();
        System.out.println("3-商户审核流程成功----------success：");
        System.out.println("==================================================================================");


        //3、调用入网成功配置参数
        callConfig();
    }

    /**
     * 调用商户入网流程
     * 1、2.1商户信息录入
     * 2、2.2资质上传接口
     * 3、2.6获取电子签约挑战码
     * 4、2.7电子签约确认
     * 5、模拟调用商户审核接口
     */
    private void callMerNetIn() throws Exception {
        System.out.println("2-商户入网流程开始----------start：");
        //商户类型：3、小微；1/2、企业/个体配置
        String merchantType = ConfigUtil.getConfig("merchantType");

        if ("3".equals(merchantType)) {//小微
            //1、2.1商户信息录入
            System.out.println("2.1商户信息录入_小微商户入网开始----------start：");
            new API_1商户信息录入().add_小微商户入网();
            System.out.println("2.1商户信息录入_小微商户入网成功----------success：");

            //2、2.2资质上传接口
            System.out.println("2.2资质上传接口_小微开始----------start：");
            new API_2资质上传接口().test_小微();
            System.out.println("2.2资质上传接口_小微成功----------success：");

        }else {//企业/个体配置
            //1、2.1商户信息录入
            System.out.println("2.1商户信息录入_企业个体商户入网开始----------start：");
            new API_1商户信息录入().add_企业个体商户入网();
            System.out.println("2.1商户信息录入_企业个体商户入网成功----------success：");

            //2、2.2资质上传接口
            System.out.println("2.2资质上传接口_个体_企业商户开始----------start：");
            new API_2资质上传接口().test_个体_企业商户();
            System.out.println("2.2资质上传接口_个体_企业商户成功----------success：");

        }
        Thread.sleep(1000);
        //3、2.6获取电子签约挑战码
        System.out.println("2.3获取电子签约挑战码开始----------start：");
        new API_6_7电子签约().verifyCode_获取电子签约挑战码();
        System.out.println("2.3获取电子签约挑战码成功----------success：");

        //TODO 查询签约挑战码
        System.out.println("2.4查询签约挑战码开始----------start：");
        new VerifyCode().getVerifyCode();
        System.out.println("2.4查询签约挑战码成功----------success：");

        //4、2.7电子签约确认
        System.out.println("2.5电子签约确认开始----------start：");
        new API_6_7电子签约().verifyCode_电子签约确认();
        System.out.println("2.5电子签约确认成功----------success：");

        System.out.println("2-商户入网流程成功----------success：");
        System.out.println("==================================================================================");
    }

    /**
     * 调用入网成功配置参数
     * 1、2.3商户信息查询
     * 2、2.4微信参数配置-支付授权目录
     * 3、2.5微信参数配置-子商户appid
     * 4、2.8电子协议下载
     */
    private void callConfig() throws Exception {
        //1、2.3商户信息查询
        new API_3商户信息查询().queryOrder_商户信息查询();

        //2、2.4微信参数配置-支付授权目录
//        new API_4微信参数配置_支付授权目录().config_支付授权目录();

        //3、2.5微信参数配置-子商户appid
//        new API_5微信参数配置_子商户appid().config_子商户appid();

        //4、2.8电子协议下载
        System.out.println("4-电子协议下载开始----------start：");
        new API_8电子协议下载().down_电子协议下载();
        System.out.println("4-电子协议下载成功----------success：");
        System.out.println("==================================================================================");
    }

}

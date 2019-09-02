package com.umpay.jnuit;

import com.umpay.demo.step0_准备工作.EnvConfig;
import com.umpay.demo.step1_商户入网流程.API_1商户信息录入;
import com.umpay.util.ConfigUtil;
import org.junit.Test;

/**
 * 入网整体流程测试用例执行
 */
public class step1_入网相关接口用例 {

    /**
     * 入网相关接口用例
     * 1、准备工作检查
     * 2、调用商户入网流程
     * 3、调用入网成功配置参数
     * @throws Exception
     */
    @Test
    public void test_natPerson() throws Exception {
        //1、准备工作检查
        new EnvConfig().initConfig();
        EnvConfig.context.clear();

        //2、调用商户入网流程
        callMerNetIn();

    }

    /**
     * 调用商户入网流程
     * 1、商户信息录入
     * 2、
     */
    private void callMerNetIn() throws Exception {
        //商户类型：1、小微；2、企业/个体配置
        String merchantType = ConfigUtil.getConfig("merchantType");

        if ("1".equals(merchantType)) {//小微
            //1、商户信息录入
            new API_1商户信息录入().add_小微商户入网();


        }else {//企业/个体配置
            //1、商户信息录入
            new API_1商户信息录入().add_企业个体商户入网();

        }



    }

}

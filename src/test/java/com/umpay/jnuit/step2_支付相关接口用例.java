package com.umpay.jnuit;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付相关接口用例执行
 */
public class step2_支付相关接口用例 {

    /**
     * 支付相关接口用例
     * 1、调用所有收款交易
     * 2、调用交易查询
     * 3、调用交易撤销_退款
     * 4、调用交易关闭
     * 5、调用对账文件下载
     * @throws Exception
     */
    @Test
    public void test_natPerson() throws Exception {
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("acqSpId", "Y471790403");
        paramMap.put("merId", "M2019082700000348");
//		paramMap.put("merId", "M2019080800000067");
    }
}

package com.umpay.call;

import com.umpay.jnuit.step1_入网相关接口用例;

public class WebCallDemo {

    public static String callMerInNet() {
        try{
            new step1_入网相关接口用例().test_商户入网();
        }catch (Exception e) {
            return e.getMessage();
        }
        return "0000";
    }
}

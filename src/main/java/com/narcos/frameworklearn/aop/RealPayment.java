package com.narcos.frameworklearn.aop;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/04/20 14:46
 **/

public class RealPayment implements Payment {
    @Override
    public void pay() {
        System.out.println("作为用户，我只关心支付功能");
    }
}

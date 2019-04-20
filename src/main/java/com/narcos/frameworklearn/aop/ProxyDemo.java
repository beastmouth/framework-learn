package com.narcos.frameworklearn.aop;

/**
 * @author hbj
 * @version 1.0
 * @date 14:48
 **/

public class ProxyDemo {
    public static void main(String[] args) {
        Payment proxy = new AliPay(new RealPayment());
        proxy.pay();
    }
}

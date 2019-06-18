package com.narcos.frameworklearn.ioc.anno.demo;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/4/25 23:12
 */
public class Bmw implements Car {
    @Override
    public void print() {
        System.out.println("I am BMW");
    }
}

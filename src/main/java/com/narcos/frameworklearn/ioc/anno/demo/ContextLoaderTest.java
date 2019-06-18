package com.narcos.frameworklearn.ioc.anno.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/4/25 23:15
 */
public class ContextLoaderTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ParentConfig.class);
        Car bmw = (Car) context.getBean("bmw");
        bmw.print();
        Car toyota = (Car) context.getBean("toyota");
        toyota.print();
    }
}

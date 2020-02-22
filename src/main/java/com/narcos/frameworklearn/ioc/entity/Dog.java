//package com.narcos.frameworklearn.ioc.entity;
//
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;
//
///**
// * Pet 的实现类不止一个 spring 不知道要优先注入哪一个
// * 此时可以使用 @Primary 告诉 Spring 优先注入的 bean
// * @author hbj
// * @version 1.0
// * @date 2019/04/15 16:28
// **/
//@Component
//@Primary
//public class Dog implements Pet {
//
//    @Override
//    public void move() {
//        System.out.println("running");
//    }
//}

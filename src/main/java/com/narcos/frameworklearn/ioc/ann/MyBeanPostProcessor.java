//package com.narcos.frameworklearn.ioc.ann;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
//import org.springframework.stereotype.Component;
//
///**
// * 自己重写接口，自己实例化bean，一般情况下不会使用
// * @author hbj
// * @date 2020/2/25 14:53
// */
//@Component
//public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
//    @Override
//    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//        if (beanName.equals("worker")) {
//            return new Worker();
//        }
//        return null;
//    }
//
//    @Override
//    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
//        if (beanName.equals("worker")) {
//            Worker worker = (Worker) bean;
//            worker.setName("aa");
//        }
//        return false;
//    }
//}

package com.narcos.frameworklearn.processor;

import com.narcos.frameworklearn.bean.BeanOne;
import com.narcos.frameworklearn.bean.BeanTwo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 对所有的Bean都是有效的
 *
 * @author hbj
 * @date 2019/10/21 23:15
 */
@Slf4j
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof BeanOne || bean instanceof BeanTwo) {
            log.info("这是在Bean：{}-{}初始化前执行的前置处理器", bean, beanName);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof BeanOne || bean instanceof BeanTwo) {
            log.info("这是在Bean：{}-{}初始化后执行的后置处理器", bean, beanName);
        }
        return bean;
    }
}

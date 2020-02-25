package com.narcos.frameworklearn.ioc.ann;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * @author hbj
 * @date 2020/2/22 17:18
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition teacher = beanFactory.getBeanDefinition("teacher");
        MutablePropertyValues propertyValues = teacher.getPropertyValues();
        propertyValues.add("name", "ss");
        System.out.println("给bean:teacher设置属性name成功");
    }
}

package com.narcos.frameworklearn;

import com.narcos.frameworklearn.bean.BeanOne;
import com.narcos.frameworklearn.bean.BeanTwo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * SpringBootApplication 包含了 @ComponentScan
 * ComponentScan 只能扫描 FrameworkLearnApplication 所在当前包一下的 如果不在当前包 需要另外指定包的路径
 *
 * @author hbj
 */
@Slf4j
@SpringBootApplication
public class FrameworkLearnApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(FrameworkLearnApplication.class, args);
//        Person personBean = applicationContext.getBean(Person.class);
//        Person person = (Person) applicationContext.getBean("person");
//        System.out.println("personBean : " + personBean.toString() + " personName : " + person.toString());
//        person.call();

        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(BeanOne.class);
        beanDefinitionBuilder.addConstructorArgValue("I am BeanOne");
        beanDefinitionBuilder.setInitMethodName("init");
        beanDefinitionBuilder.setDestroyMethodName("destroy");
        BeanDefinition interceptorBeanDefinition = beanDefinitionBuilder
                .getRawBeanDefinition();
        beanFactory.registerBeanDefinition("beanOne",
                interceptorBeanDefinition);
        BeanOne beanOne = (BeanOne) applicationContext.getBean("beanOne");
        log.info(beanOne.getWords());
        beanOne.destroy();

        BeanDefinitionBuilder beanDefinitionBuilder2 = BeanDefinitionBuilder.genericBeanDefinition(BeanTwo.class);
        beanDefinitionBuilder2.addConstructorArgValue("I am BeanTwo");
        beanDefinitionBuilder2.setInitMethodName("init");
        beanDefinitionBuilder2.setDestroyMethodName("destroy");
        BeanDefinition interceptorBeanDefinition2 = beanDefinitionBuilder2
                .getRawBeanDefinition();
        beanFactory.registerBeanDefinition("beanTwo",
                interceptorBeanDefinition2);
        BeanTwo beanTwo = (BeanTwo) applicationContext.getBean("beanTwo");
        log.info(beanTwo.getWords());
        beanTwo.destroy();
    }
}

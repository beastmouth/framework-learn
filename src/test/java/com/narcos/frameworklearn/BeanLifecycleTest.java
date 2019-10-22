package com.narcos.frameworklearn;

import com.narcos.frameworklearn.bean.BeanOne;
import com.narcos.frameworklearn.bean.BeanTwo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author hbj
 * @date 2019/10/22 17:40
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanLifecycleTest {

    @Autowired
    private WebApplicationContext applicationContext;

    /**
     * bean生命周期测试用例
     */
    @Test
    public void beanLifecycleTest() {
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(BeanOne.class);
        beanDefinitionBuilder.addConstructorArgValue("I am BeanOne");
        beanDefinitionBuilder.setInitMethodName("init");
        beanDefinitionBuilder.setDestroyMethodName("destroy");
        BeanDefinition beanDefinition = beanDefinitionBuilder
                .getRawBeanDefinition();
        beanFactory.registerBeanDefinition("beanOne",
                beanDefinition);
        BeanOne beanOne = (BeanOne) applicationContext.getBean("beanOne");
        log.info(beanOne.getWords());
        beanOne.destroy();

        BeanDefinitionBuilder beanDefinitionBuilder2 = BeanDefinitionBuilder.genericBeanDefinition(BeanTwo.class);
        beanDefinitionBuilder2.addConstructorArgValue("I am BeanTwo");
        beanDefinitionBuilder2.setInitMethodName("init");
        beanDefinitionBuilder2.setDestroyMethodName("destroy");
        BeanDefinition beanDefinition2 = beanDefinitionBuilder2
                .getRawBeanDefinition();
        beanFactory.registerBeanDefinition("beanTwo",
                beanDefinition2);
        BeanTwo beanTwo = (BeanTwo) applicationContext.getBean("beanTwo");
        log.info(beanTwo.getWords());
        beanTwo.destroy();
    }
}

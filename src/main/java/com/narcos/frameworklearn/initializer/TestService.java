package com.narcos.frameworklearn.initializer;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author hbj
 * @date 2020/2/19 22:35
 */
@Component
public class TestService implements ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public String test() {
        return applicationContext.getEnvironment().getProperty("key1");
    }

    public String test2() {
        return applicationContext.getEnvironment().getProperty("key2");
    }

    public String test3() {
        return applicationContext.getEnvironment().getProperty("key3");
    }
}

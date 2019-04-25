package com.narcos.frameworklearn.ioc.anno.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/4/25 23:13
 */
@Configuration
public class ConfigA {
    @Bean("bmw")
    public Bmw getBmw() {
        return new Bmw();
    }
}

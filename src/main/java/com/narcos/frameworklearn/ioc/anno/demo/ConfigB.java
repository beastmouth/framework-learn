package com.narcos.frameworklearn.ioc.anno.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/4/25 23:14
 */
@Configuration
public class ConfigB {
    @Bean("toyota")
    public Toyota getToyota() {
        return new Toyota();
    }
}

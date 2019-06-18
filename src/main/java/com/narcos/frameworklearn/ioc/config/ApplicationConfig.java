package com.narcos.frameworklearn.ioc.config;

import com.narcos.frameworklearn.ioc.entity.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/04/15 16:12
 **/
@Configuration
public class ApplicationConfig {
    /**
     * name 定义bean的名称
     */
    @Primary
    @Bean(name = "personHbj")
    public Person initPerson() {
        Person user = new Person();
        user.setId(1L);
        user.setName("hbj");
        return user;
    }

}

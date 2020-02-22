package com.narcos.frameworklearn.ioc.ann;

import com.narcos.frameworklearn.ioc.xml.Animal;
import com.narcos.frameworklearn.ioc.xml.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hbj
 * @date 2020/2/22 15:12
 */
@Configuration
public class BeanConfiguration {
    @Bean("dog")
    Animal getDog() {
        return new Dog();
    }
}

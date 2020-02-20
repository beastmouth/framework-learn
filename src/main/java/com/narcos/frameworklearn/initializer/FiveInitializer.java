package com.narcos.frameworklearn.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hbj
 * @date 2020/2/19 22:27
 */
@Order(3)
public class FiveInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        Map<String, Object> map = new HashMap<>();
        map.put("key5", "value5");
        MapPropertySource mapPropertySource = new MapPropertySource("fiveInitializer", map);
        environment.getPropertySources().addLast(mapPropertySource);
        System.out.println("run fiveInitializer");
    }
}

package com.narcos.frameworklearn.config;

import com.narcos.frameworklearn.interceptor.TestOneInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/04/23 22:17
 **/
@Configuration
public class OneInterceptorConfig implements WebMvcConfigurer {
    private final TestOneInterceptor testOneInterceptor;

    public OneInterceptorConfig(TestOneInterceptor testOneInterceptor) {
        this.testOneInterceptor = testOneInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(testOneInterceptor);
    }
}

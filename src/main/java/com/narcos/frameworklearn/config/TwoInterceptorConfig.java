package com.narcos.frameworklearn.config;

import com.narcos.frameworklearn.interceptor.TestOneInterceptor;
import com.narcos.frameworklearn.interceptor.TestTwoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/04/23 22:17
 **/
@Configuration
public class TwoInterceptorConfig extends OneInterceptorConfig {
    private final TestTwoInterceptor testTwoInterceptor;
    private final TestOneInterceptor testOneInterceptor;

    public TwoInterceptorConfig(TestOneInterceptor testOneInterceptor, TestTwoInterceptor testTwoInterceptor) {
        super(testOneInterceptor);
        this.testOneInterceptor = testOneInterceptor;
        this.testTwoInterceptor = testTwoInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testOneInterceptor);
        registry.addInterceptor(testTwoInterceptor);
    }
}

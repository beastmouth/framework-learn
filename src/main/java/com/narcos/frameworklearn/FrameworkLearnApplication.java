package com.narcos.frameworklearn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * SpringBootApplication 包含了 @ComponentScan
 * ComponentScan 只能扫描 FrameworkLearnApplication 所在当前包一下的 如果不在当前包 需要另外指定包的路径
 *
 * @author hbj
 */
@EnableAsync
@Slf4j
@SpringBootApplication
public class FrameworkLearnApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(FrameworkLearnApplication.class);
        springApplication.run();
    }
}

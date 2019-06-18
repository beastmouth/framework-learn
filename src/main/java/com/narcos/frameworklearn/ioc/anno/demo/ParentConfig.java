package com.narcos.frameworklearn.ioc.anno.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/4/25 23:15
 */
@Configuration
@Import({ConfigA.class, ConfigB.class})
public class ParentConfig {
}

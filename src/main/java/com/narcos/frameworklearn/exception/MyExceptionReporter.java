package com.narcos.frameworklearn.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.boot.SpringBootExceptionReporter;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author hbj
 * @date 2020/4/16 2:34 下午
 */
@Slf4j
public class MyExceptionReporter implements SpringBootExceptionReporter {
    private ConfigurableApplicationContext context;

    public MyExceptionReporter(ConfigurableApplicationContext context) {
        // 需要初始化上下文，否则会报找不到
        this.context = context;
    }

    @Override
    public boolean reportException(Throwable failure) {
        if (failure instanceof UnsatisfiedDependencyException) {
            UnsatisfiedDependencyException exception = (UnsatisfiedDependencyException) failure;
            log.error("no such bean : {}", exception.getInjectionPoint().getField().getName());
        }
        // 返回false，其他的异常报告器也会处理该异常
        return false;
    }
}

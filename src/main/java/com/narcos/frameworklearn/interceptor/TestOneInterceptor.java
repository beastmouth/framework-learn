package com.narcos.frameworklearn.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/04/23 22:10
 **/
@Slf4j
@Component
public class TestOneInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("I am one interceptor");
        return true;
    }
}

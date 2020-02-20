package com.narcos.frameworklearn.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/04/20 14:02
 **/
@Slf4j
@Aspect
@Component
public class RequestLogAspect {
    @Pointcut("execution(public * com.narcos.frameworklearn.controller..*.*(..))")
    public void webLog() {

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 接受到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 记录以下请求内容
//        log.info("URL : {}", request.getRequestURL().toString());
//        log.info("IP : {}", request.getRemoteAddr());
//        log.info("CLASS SIMPLE NAME : {}", joinPoint.getSignature().getDeclaringType().getSimpleName());
//        log.info("CLASS NAME : {}", joinPoint.getSignature().getDeclaringTypeName());
//        log.info("METHOD TYPE : {}", Modifier.toString(joinPoint.getSignature().getModifiers()));
//        log.info("METHOD NAME : {}", joinPoint.getSignature().getName());
//        log.info("Params : {}", Arrays.toString(joinPoint.getArgs()));

    }

    /**
     * 对返回值进行加工处理
     */
    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
//        log.info("RESPONSE : {}", ret);
    }
}

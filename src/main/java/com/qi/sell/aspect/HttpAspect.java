package com.qi.sell.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 对每次http请求，记录请求信息及返回结果
 * Created by Qi
 * 2018/7/9 10:41
 **/
@Aspect
@Component
@Slf4j
public class HttpAspect {

    @Pointcut("execution(public * com.qi.sell.controller.BuyerOrderController.*(..))")
    public void log() {

    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("url={}", request.getRequestURL());
        log.info("method={}", request.getMethod());
        log.info("ip={}", request.getRemoteAddr());
        log.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName()
                + "." + joinPoint.getSignature().getName());
        log.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        log.info("after");
    }

    @AfterReturning(pointcut = "log()", returning = "object")
    public void doAfterReturning(Object object) {
        log.info("resoponse={}", object.toString());
    }

}

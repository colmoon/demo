package com.moon.demo.service.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author wuxiaojian
 * @Description 系统切面日志
 * @Date  2019/6/6 15:24
 * @Param
 * @return
 **/
@Slf4j
@Aspect
@Component
public class RpcAop {
 
    @Pointcut("@annotation(com.moon.demo.service.aop.Degrade)")
    public void logPointCut() {}
 
    /**
     * 环绕通知 @Around  ， 当然也可以使用 @Before (前置通知)  @After (后置通知)
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        Object[] args = point.getArgs();

        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Degrade annotation = method.getAnnotation(Degrade.class);
        //判断是否需要降级
        boolean needDegrade = annotation.needDegrade();
        if (needDegrade) {
            try {
                return point.proceed(args);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
                return null;
            }
        }
        return point.proceed(args);
    }
 
}
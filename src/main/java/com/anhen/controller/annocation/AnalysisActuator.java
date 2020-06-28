package com.anhen.controller.annocation;

import java.lang.annotation.*;

/**
 * @ClassName AnalysisActuator
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/5/27 15:13
 * @Version 1.0
 **/
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnalysisActuator {
    String note() default "";
}


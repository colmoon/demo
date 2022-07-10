package com.moon.demo.service.annocation.user;

import java.lang.annotation.*;

/**
 * @ClassName Init
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/5/9 13:14
 * @Version 1.0
 **/

@Documented
@Inherited
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Init {
    public String value() default "";
}

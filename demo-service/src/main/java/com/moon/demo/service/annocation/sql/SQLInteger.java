package com.moon.demo.service.annocation.sql;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName SQLInteger
 * @Description 注解Integer类型的字段
 * @Author wuxiaojian
 * @Date 2019/5/27 9:41
 * @Version 1.0
 **/

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInteger {
    String name() default "";
    Constraints constraints() default @Constraints;
}

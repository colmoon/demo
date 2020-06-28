package com.anhen.annotation.sql;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName DBTable
 * @Description 表注解
 * @Author wuxiaojian
 * @Date 2019/5/27 9:37
 * @Version 1.0
 **/

@Target(ElementType.TYPE) //只能作用在类上
@Retention(RetentionPolicy.RUNTIME) //保存到运行时
public @interface DBTable {
    String name() default "";
}

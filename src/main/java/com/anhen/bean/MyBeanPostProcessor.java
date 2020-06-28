package com.anhen.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        super();
        System.out.println("这是BeanPostProcessor实现类构造器！！");
    }

    @Override
    public Object postProcessAfterInitialization(Object arg, String argName)
            throws BeansException {
        System.out.println(arg);
        System.out.println(argName);
        System.out.println("BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");
        return arg;
    }

    @Override
    public Object postProcessBeforeInitialization(Object arg, String argName)
            throws BeansException {
        System.out.println(arg);
        System.out.println(argName);
        System.out.println("BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");
        return arg;
    }
}  
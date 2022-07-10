package com.moon.demo.design.headfirst.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName NonOwnerInvocationHandler
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/19 21:08
 */
public class NonOwnerInvocationHandler implements InvocationHandler {
    PersonBean person;

    public NonOwnerInvocationHandler(PersonBean person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try{
            if (method.getName().startsWith("get")){
                return method.invoke(person, args);
            } else if(method.getName().equals("setHotOrNotRating")){
                return method.invoke(person, args);
            } else if (method.getName().startsWith("set")){
                throw new IllegalAccessException();
            }
        } catch (InvocationTargetException ex){
            ex.printStackTrace();
        }
        return null;
    }
}

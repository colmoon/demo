package com.goldcard.headfirstdesign.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName OwnerInvocationHandler
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/19 21:04
 */
public class OwnerInvocationHandler implements InvocationHandler {
    PersonBean person;

    public OwnerInvocationHandler(PersonBean person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try{
            if (method.getName().startsWith("get")){
                return method.invoke(person, args);
            } else if(method.getName().equals("setHotOrNotRating")){
                throw new IllegalAccessException();
            } else if (method.getName().startsWith("set")){
                return method.invoke(person, args);
            }
        } catch (InvocationTargetException ex){
            ex.printStackTrace();
        }
        return null;
    }
}

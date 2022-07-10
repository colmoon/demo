package com.moon.demo.service.annocation.user;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ClassName UserFactory
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/5/9 13:18
 * @Version 1.0
 **/

public class UserFactory {

    public static void main(String[] args) throws IllegalAccessException,
            IllegalArgumentException, InvocationTargetException
    {
        User user = UserFactory.create();

        System.out.println(user.getName());
        System.out.println(user.getAge());
    }

    public static User create()
    {
        User user = new User();

        // 获取User类中所有的方法（getDeclaredMethods也行）
        Method[] methods = User.class.getMethods();

        try
        {
            for (Method method : methods)
            {
                // 如果此方法有注解，就把注解里面的数据赋值到user对象
                if (method.isAnnotationPresent(Init.class))
                {
                    Init init = method.getAnnotation(Init.class);
                    method.invoke(user, init.value());
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }

        return user;
    }
}

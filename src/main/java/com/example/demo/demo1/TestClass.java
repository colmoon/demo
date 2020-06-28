package com.example.demo.demo1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by garfield on 2016/11/18.
 */
public class TestClass {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class c = Class.forName("com.example.demo.demo1.OuterClass");
        //通过方法名获取方法
        Method method = c.getDeclaredMethod("print");
        //调用外部类方法
        method.invoke(c.newInstance());
        //内部类需要使用$分隔
        Class c2 = Class.forName("com.example.demo.demo1.OuterClass$InnerClass");
        Method method2 = c2.getDeclaredMethod("print2");
        //通过构造函数创建实例,需要将外部类的实例作为参数传递进去，如果没有重写构造方法则不管是不是获取已声明构造方法,结果是一样的
        method2.invoke(c2.getDeclaredConstructors()[0].newInstance(c.newInstance()));
        //获取该内部类的构造函数
        Constructor[] constructors = c2.getDeclaredConstructors();
        for(Constructor constructor : constructors){
            System.out.println(Arrays.toString(constructor.getParameterTypes()));
        }
    }
}
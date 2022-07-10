package com.moon.demo.service.reflect;


import com.moon.study.common.base.utils.GsonUtil;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by zejian on 2017/5/1.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 */
public class ReflectMethod  {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

//        Class<?> clazz = Class.forName("com.goldcard.reflect.Circle");
        Class<?> clazz = Circle.class;
        System.out.println(clazz);

        //根据参数获取public的Method,包含继承自父类的方法
        Method method = clazz.getMethod("draw",int.class,String.class);
        
        System.out.println(method.getName());
        System.out.println(GsonUtil.beanToJson(method.getParameterTypes()));

        System.out.println("method:"+method);

        //获取所有public的方法:
        Method[] methods =clazz.getMethods();
        for (Method m:methods){
            System.out.println("m::"+m);
        }

        System.out.println("=========================================");

        //获取当前类的方法包含private,该方法无法获取继承自父类的method
        Method method1 = clazz.getDeclaredMethod("drawCircle");
        System.out.println("method1::"+method1);
        //获取当前类的所有方法包含private,该方法无法获取继承自父类的method
        Method[] methods1=clazz.getDeclaredMethods();
        for (Method m:methods1){
            System.out.println("m1::"+m);
        }
        
      //创建对象
        Circle circle = (Circle) clazz.newInstance();

        //获取指定参数的方法对象Method
        Method method2 = clazz.getMethod("draw",int.class,String.class);

        //通过Method对象的invoke(Object obj,Object... args)方法调用
        method2.invoke(circle,15,"圈圈");

        //对私有无参方法的操作
        Method method3 = clazz.getDeclaredMethod("drawCircle");
        //修改私有方法的访问标识
        method3.setAccessible(true);
        method3.invoke(circle);

        //对有返回值得方法操作
        Method method4 =clazz.getDeclaredMethod("getAllCount");
        Integer count = (Integer) method4.invoke(circle);
        System.out.println("count:"+count);

        /**
            输出结果:
            draw 圈圈,count=15
            drawCircle
            count:100
        */
        
    }

/**
     输出结果:
     method:public void reflect.Shape.draw(int,java.lang.String)

     m::public int reflect.Circle.getAllCount()
     m::public void reflect.Shape.draw()
     m::public void reflect.Shape.draw(int,java.lang.String)
     m::public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
     m::public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
     m::public final void java.lang.Object.wait() throws java.lang.InterruptedException
     m::public boolean java.lang.Object.equals(java.lang.Object)
     m::public java.lang.String java.lang.Object.toString()
     m::public native int java.lang.Object.hashCode()
     m::public final native java.lang.Class java.lang.Object.getClass()
     m::public final native void java.lang.Object.notify()
     m::public final native void java.lang.Object.notifyAll()

     =========================================
     method1::private void reflect.Circle.drawCircle()

     m1::public int reflect.Circle.getAllCount()
     m1::private void reflect.Circle.drawCircle()
     */
    
    
    
}

class Shape {
    public void draw(){
        System.out.println("draw");
    }

    public void draw(int count , String name){
        System.out.println("draw "+ name +",count="+count);
    }

}
class Circle extends Shape{

    private void drawCircle(){
        System.out.println("drawCircle");
    }
    public int getAllCount(){
        return 100;
    }
}
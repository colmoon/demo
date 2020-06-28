package com.example.demo;

/**
 * @ClassName StaticTest
 * @Description 加载静态方法时静态块会首先加载
 * @Author wuxiaojian
 * @Date 2019/4/8 17:57
 * @Version 1.0
 **/

public class StaticTest {
    static {
        int a = 1;
        System.out.println("a = " + a);
    }

    public static void printA(){
        System.out.println("method~~~~~~~");
    }

    public static void printB(){
        System.out.println("method*******");
    }

    public static void main(String[] args) {
        StaticTest.printA();
        StaticTest.printB();
    }
}

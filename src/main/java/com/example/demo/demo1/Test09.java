package com.example.demo.demo1;


/**
 * @classname: Test09
 * @description: 执行顺序demo
 * @author: wuxiaojian
 * @create: 2020-07-30 14:04
 */
public class Test09 {


    public static class A {
        private Integer a = 0;
        private static final Integer b = 1;
        public A(){
            f();
            f1();
        }
        public void f(){
            System.out.println(a);
        }
        public void f1(){
            System.out.println(b);
        }
    }

    public static class B extends A {
        private static Integer c = 2;
        private Integer d = 3;

        public B(){
            f();
            f1();
        }

        @Override
        public void f(){
            System.out.println(c);
        }

        @Override
        public void f1(){
            System.out.println(d);
        }
    }

    public static void main(String[] args) {
        new B();
    }
}

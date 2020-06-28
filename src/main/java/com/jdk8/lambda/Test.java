package com.jdk8.lambda;

public class Test {
 
    public static void main(String[] args) {
 
        // Java8之前：
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        }).start();
 
        // Java8方式：
        new Thread(() -> System.out.println("hello world")).start();
    }
}
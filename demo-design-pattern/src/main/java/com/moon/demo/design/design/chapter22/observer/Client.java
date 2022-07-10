package com.moon.demo.design.design.chapter22.observer;

/**
 * @classname: Client
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2021-11-08 18:52
 */
public class Client {
    public static void main(String[] args) {
        ConcreteSubject concreteSubject = new ConcreteSubject();
        Observer observer = new ConcreteObserver();
        concreteSubject.addObserver(observer);
        concreteSubject.doSomething();
    }
}

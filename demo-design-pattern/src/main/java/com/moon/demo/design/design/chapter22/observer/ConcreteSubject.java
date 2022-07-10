package com.moon.demo.design.design.chapter22.observer;

/**
 * @classname: ConcreteSubject
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2021-11-08 18:50
 */
public class ConcreteSubject extends Subject {
    public void doSomething(){
        //
        System.out.println("do something");
        super.notifyObservers();
    }
}

package com.anhen.design.chapter22.observer;

/**
 * @classname: ConcreteObserver
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2021-11-08 18:52
 */
public class ConcreteObserver implements Observer{
    @Override
    public void update() {
        System.out.println("收到信息，处理中");
    }
}

package com.anhen.design.chapter19.adapter;

/**
 * @classname: Client
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2021-11-06 11:08
 */
public class Client {
    public static void main(String[] args) {
        Target target = new ConcreteTarget();
        target.request();

        Target target1 = new Adapter(new Adaptee());
        target1.request();
    }
}

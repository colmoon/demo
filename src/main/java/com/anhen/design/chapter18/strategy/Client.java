package com.anhen.design.chapter18.strategy;

/**
 * @classname: Client
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2021-11-06 09:55
 */
public class Client {
    public static void main(String[] args) {
        Strategy strategy = new ConcreteStrategy1();

        Context context = new Context(strategy);

        context.doAnyThing();
    }
}

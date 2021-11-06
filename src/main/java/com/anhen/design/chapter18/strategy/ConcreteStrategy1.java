package com.anhen.design.chapter18.strategy;

/**
 * @classname: ConcreteStrategy1
 * @description: 具体策略1
 * @author: wuxiaojian
 * @create: 2021-11-06 09:50
 */
public class ConcreteStrategy1 implements Strategy {
    @Override
    public void doSomething() {
        System.out.println("具体策略1的运算法则");
    }
}

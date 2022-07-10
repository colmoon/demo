package com.moon.demo.design.design.chapter18.strategy;

/**
 * @classname: ConcreteStrategy2
 * @description: 具体的策略模式2
 * @author: wuxiaojian
 * @create: 2021-11-06 09:51
 */
public class ConcreteStrategy2 implements Strategy {
    @Override
    public void doSomething() {
        System.out.println("具体策略2 的运算法则");
    }
}

package com.moon.demo.design.design.chapter18.strategy;

/**
 * @classname: Context
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2021-11-06 09:53
 */
public class Context {
    //抽象策略
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    //封装后的策略方法
    public void doAnyThing(){
        strategy.doSomething();
    }
}

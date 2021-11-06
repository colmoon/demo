package com.anhen.design.chapter19.adapter;

/**
 * @classname: ConcreteTarget
 * @description: 目标角色实现类
 * @author: wuxiaojian
 * @create: 2021-11-06 10:53
 */
public class ConcreteTarget implements Target{
    @Override
    public void request() {
        System.out.println("具体的角色");
    }
}

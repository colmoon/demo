package com.moon.demo.design.design.chapter19.adapter;

/**
 * @classname: Adapter
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2021-11-06 11:07
 */
public class Adapter implements Target{

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        adaptee.doSomeThing();
    }
}

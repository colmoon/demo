package com.moon.demo.design.design.chapter25.visitor;

/**
 * @classname: Element
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2021-11-11 18:53
 */
public abstract class Element {
    //定义业务逻辑
    public abstract void doSomething();

    //允许谁来访问
    public abstract void accept(IVisitor visitor);
}

package com.moon.demo.design.design.chapter21.composite;

/**
 * @classname: Component
 * @description: 抽象构件
 * @author: wuxiaojian
 * @create: 2021-11-06 16:22
 */
public abstract class Component {

    //定义公共属性及方法

    /**
     * 个体和整体都具体的共享
     * @return: void
     **/
    public void doSomething(){
        System.out.println("doSomething");
    }
}

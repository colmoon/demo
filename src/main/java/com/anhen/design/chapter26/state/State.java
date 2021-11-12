package com.anhen.design.chapter26.state;

/**
 * @classname: State
 * @description: 抽象环境角色
 * @author: wuxiaojian
 * @create: 2021-11-12 19:07
 */
public abstract class State {

    //定义一个环境角色，提供子类访问
    protected Context context ;

    public void setContext(Context context) {
        this.context = context;
    }

    //行为1
    public abstract void handler1();

    //行为2
    public abstract void handler2();
}

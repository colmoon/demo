package com.anhen.design.chapter26.state;

/**
 * @classname: Client
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2021-11-12 19:19
 */
public class Client {
    public static void main(String[] args) {
        //定义环境角色
        Context context = new Context();
        //初始化状态
        context.setCurrentState(new ConcreteState1());
        //行为执行
        context.handle1();
        context.handle2();
    }
}

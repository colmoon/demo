package com.moon.demo.design.design.chapter16.chain;

/**
 * @classname: Client
 * @description: 用户
 * @author: wuxiaojian
 * @create: 2021-10-26 09:41
 */
public class Client {
    public static void main(String[] args) {
        //声明所有的处理节点
        Handler handler1 = new ConCreteHandler1();
        Handler handler2 = new ConCreteHandler2();
        Handler handler3 = new ConCreteHandler3();
        //设置链中的阶段顺序
        handler1.setNext(handler2);
        handler2.setNext(handler3);
        Response response = handler1.handleMessage(new Request());
    }
}

package com.moon.demo.design.design.chapter15.command;

public abstract class Receiver {
    //抽象接收者， 定义每个接收者都必须完成的业务
    public abstract void doSomething();
}
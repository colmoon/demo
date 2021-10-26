package com.anhen.design.chapter16.chain.instance;

public interface IHandler {
    //一个女性（女儿、 妻子或者母亲） 要求逛街， 你要处理这个请求
    public void HandleMessage(IWomen women);
}
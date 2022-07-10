package com.moon.demo.design.design.chapter16.chain;

/**
 * @classname: ConCreteHandler1
 * @description: 具体的处理者1
 * @author: wuxiaojian
 * @create: 2021-10-26 09:38
 */
public class ConCreteHandler1 extends Handler{
    @Override
    protected Level getHandlerLevel() {
        //设置自己的处理级别
        return null;
    }

    @Override
    protected Response echo(Request request) {
        //完成处理逻辑
        return null;
    }
}

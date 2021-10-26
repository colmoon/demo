package com.anhen.design.chapter16.chain;

/**
 * @classname: ConCreteHandler3
 * @description: 具体的处理者3
 * @author: wuxiaojian
 * @create: 2021-10-26 09:39
 */
public class ConCreteHandler3 extends Handler{
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
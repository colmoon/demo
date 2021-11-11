package com.anhen.design.chapter25.visitor;

/**
 * @classname: ConcreteElement1
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2021-11-11 19:01
 */
public class ConcreteElement1 extends Element{

    /**
     * 业务逻辑
     * @return: void
     **/
    @Override
    public void doSomething() {
        //业务处理
    }

    /**
     * 访问者访问
     * @param visitor:
     * @return: void
     **/
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

package com.moon.demo.design.design.chapter25.visitor;

/**
 * @classname: ConcreteElement2
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2021-11-11 19:01
 */
public class ConcreteElement2 extends Element{

    /**
     * 业务逻辑
     * @return: void
     **/
    @Override
    public void doSomething() {

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

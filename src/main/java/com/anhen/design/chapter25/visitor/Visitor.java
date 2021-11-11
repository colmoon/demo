package com.anhen.design.chapter25.visitor;

/**
 * @classname: Visitor
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2021-11-11 19:07
 */
public class Visitor implements IVisitor{
    @Override
    public void visit(ConcreteElement1 element) {
        element.doSomething();
    }

    @Override
    public void visit(ConcreteElement2 element) {
        element.doSomething();
    }
}

package com.anhen.design.chapter25.visitor;

/**
 * @classname: IVisitor
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2021-11-11 18:59
 */
public interface IVisitor {
    //可以访问哪些对象
    void visit(ConcreteElement1 element);
    void visit(ConcreteElement2 element);
}

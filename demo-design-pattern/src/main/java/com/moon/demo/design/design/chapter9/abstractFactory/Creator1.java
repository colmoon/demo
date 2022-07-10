package com.moon.demo.design.design.chapter9.abstractFactory;

/**
 * @classname: Creator1
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2021-10-12 09:57
 */
public class Creator1 extends AbstractCreator {

    @Override
    public AbstractProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public AbstractProductB createProductB() {
        return new ProductB1();
    }
}

package com.moon.demo.design.design.chapter9.abstractFactory;

public class Creator2 extends AbstractCreator {
    //只生产产品等级为2的A产品
    @Override
    public AbstractProductA createProductA() {
        return new ProductA2();
    }

    //只生产产品等级为2的B产品
    @Override
    public AbstractProductB createProductB() {
        return new ProductB2();
    }
}
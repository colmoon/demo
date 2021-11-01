package com.anhen.design.chapter17.decorator;

/**
 * @classname: ConcreteDecorator1
 * @description: 具体的装饰者
 * @author: wuxiaojian
 * @create: 2021-10-27 20:26
 */
public class ConcreteDecorator1 extends Decorator{

    public ConcreteDecorator1(Component component){
        super(component);
    }

    private void method1(){
        System.out.println("method1 修饰");
    }

    @Override
    public void operate(){
        this.method1();
        super.operate();
    }
}

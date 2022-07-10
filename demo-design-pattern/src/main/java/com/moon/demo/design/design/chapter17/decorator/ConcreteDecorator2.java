package com.moon.demo.design.design.chapter17.decorator;

/**
 * @classname: ConcreteDecorator2
 * @description: 具体的装饰者
 * @author: wuxiaojian
 * @create: 2021-10-27 20:26
 */
public class ConcreteDecorator2 extends Decorator{

    public ConcreteDecorator2(Component component){
        super(component);
    }

    private void method2(){
        System.out.println("method2 修饰");
    }

    @Override
    public void operate(){
        this.method2();
        super.operate();
    }
}

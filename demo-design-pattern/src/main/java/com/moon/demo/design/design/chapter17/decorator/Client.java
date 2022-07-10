package com.moon.demo.design.design.chapter17.decorator;

/**
 * @classname: Client
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2021-10-27 20:30
 */
public class Client {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        //第一次修饰
        component = new ConcreteDecorator1(component);
        //第二次修饰
        component = new ConcreteDecorator2(component);
        //修饰后运行
        component.operate();
    }
}

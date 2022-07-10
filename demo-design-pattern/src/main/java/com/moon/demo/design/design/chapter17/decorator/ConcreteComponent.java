package com.moon.demo.design.design.chapter17.decorator;

/**
 * @classname: ConcreteComponent
 * @description: 具体构件
 * @author: wuxiaojian
 * @create: 2021-10-27 20:22
 */
public class ConcreteComponent extends Component{
    @Override
    public void operate() {
        System.out.println("do something");
    }
}

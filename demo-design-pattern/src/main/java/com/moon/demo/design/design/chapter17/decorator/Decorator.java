package com.moon.demo.design.design.chapter17.decorator;

/**
 * @classname: Decorator
 * @description: 抽象装饰者
 * @author: wuxiaojian
 * @create: 2021-10-27 20:23
 */
public abstract class Decorator extends Component{
    private Component component;

    public Decorator(Component component){
        this.component = component;
    }

    @Override
    public void operate() {
        this.component.operate();
    }
}

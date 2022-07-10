package com.moon.demo.design.design.chapter26.state;

/**
 * @classname: ConcreteState1
 * @description: 具体角色1
 * @author: wuxiaojian
 * @create: 2021-11-12 19:09
 */
public class ConcreteState1 extends State {
    @Override
    public void handler1() {
        //本状态下必须处理的逻辑
    }

    @Override
    public void handler2() {
        //设置当前的状态
        super.context.setCurrentState(Context.STATE2);
        //过渡到state2状态，由Context实现
        super.context.handle2();

    }
}

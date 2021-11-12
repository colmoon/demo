package com.anhen.design.chapter26.state;

/**
 * @classname: ConcreteState2
 * @description:
 * @author: wuxiaojian
 * @create: 2021-11-12 19:09
 */
public class ConcreteState2 extends State {
    @Override
    public void handler1() {
        //设置当前的状态
        super.context.setCurrentState(Context.STATE1);
        //过渡到state1状态，由Context实现
        super.context.handle1();
    }

    @Override
    public void handler2() {
        //本状态下必须处理的逻辑
    }
}

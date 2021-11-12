package com.anhen.design.chapter26.state;

/**
 * @classname: Context
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2021-11-12 19:12
 */
public class Context {
    //定义状态
    public final static State STATE1 = new ConcreteState1();
    public final static State STATE2 = new ConcreteState2();

    //当前状态
    private State currentState;

    //获取当前状态
    public State getCurrentState(){
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
        //切换状态
        this.currentState.setContext(this);
    }

    //行为委托
    public void handle1(){
        this.currentState.handler1();
    }
    public void handle2(){
        this.currentState.handler2();
    }
}

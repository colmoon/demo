package com.moon.demo.design.headfirst.state;

/**
 * @ClassName SoldOutState
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/17 10:58
 */
public class SoldOutState implements State {
    GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Oops, out of gumballs");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Oops, out of gumballs");
    }

    @Override
    public void turnCrank() {
        System.out.println("Oops, out of gumballs");
    }

    @Override
    public void dispense() {
        System.out.println("Oops, out of gumballs");
    }
}

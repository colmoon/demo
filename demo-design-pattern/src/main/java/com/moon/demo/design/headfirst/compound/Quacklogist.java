package com.moon.demo.design.headfirst.compound;

/**
 * @ClassName Quacklogist
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/20 20:58
 */
public class Quacklogist implements Observer {
    @Override
    public void update(QuackObservable duck) {
        System.out.println("Quacklogist: " + duck + " just quacked.");
    }
}

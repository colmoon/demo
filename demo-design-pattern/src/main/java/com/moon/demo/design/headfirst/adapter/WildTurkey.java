package com.moon.demo.design.headfirst.adapter;

/**
 * @ClassName WildTurkey
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/12 18:57
 */
public class WildTurkey implements Turkey{
    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly(){
        System.out.println("I'm flying a short distance");
    }
}

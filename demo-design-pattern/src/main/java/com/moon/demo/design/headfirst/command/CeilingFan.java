package com.moon.demo.design.headfirst.command;


import java.util.Stack;

/**
 * @ClassName CeilingFan
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/11 10:28
 */
public class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    String location;
    int speed;
    Stack<Command> historyCommand = new Stack<>();

    public CeilingFan(String location){
        this.location = location;
        speed = OFF;
    }

    public void setHigh(){
        speed = HIGH;
        System.out.println("ceilingFan is high");
    }

    public void setMedium(){
        speed = MEDIUM;
        System.out.println("ceilingFan is medium");
    }

    public void setLow(){
        speed = LOW;
        System.out.println("ceilingFan is low");
    }

    public void  setOff(){
        speed = OFF;
        System.out.println("ceilingFan is off");
    }

    public int getSpeed(){
        return speed;
    }
}

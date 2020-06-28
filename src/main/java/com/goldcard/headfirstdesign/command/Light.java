package com.goldcard.headfirstdesign.command;

/**
 * @ClassName Light
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/10 11:18
 */
public class Light {
    private String name;
    private String address;

    public Light() {
    }

    public Light(String address) {
        this.address = address;
    }

    public void on() {
        System.out.println("打开电灯");
    }

    public void off() {
        System.out.println("关闭电灯");
    }
}

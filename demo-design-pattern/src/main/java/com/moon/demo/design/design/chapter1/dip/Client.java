package com.moon.demo.design.design.chapter1.dip;

public class Client {
    public static void main(String[] args) {
        IDriver zhangSan = new Driver();
        ICar benz = new Benz();
        //张三开奔驰车
        zhangSan.drive(benz);
    }
}
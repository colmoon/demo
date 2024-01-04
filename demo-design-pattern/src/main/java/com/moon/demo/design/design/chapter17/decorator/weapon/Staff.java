package com.moon.demo.design.design.chapter17.decorator.weapon;

/**
 * @classname: Staff
 * @description: 法杖
 * @author: wuxiaojian
 * @create: 2024-01-04 09:22
 */
public class Staff implements Weapon{

    @Override
    public int damage() {
        return 80;
    }
}

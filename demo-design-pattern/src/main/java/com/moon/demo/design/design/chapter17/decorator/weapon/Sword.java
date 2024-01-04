package com.moon.demo.design.design.chapter17.decorator.weapon;

/**
 * @classname: Sword
 * @description: 剑
 * @author: wuxiaojian
 * @create: 2024-01-04 09:23
 */
public class Sword implements Weapon{

    @Override
    public int damage() {
        return 100;
    }
}

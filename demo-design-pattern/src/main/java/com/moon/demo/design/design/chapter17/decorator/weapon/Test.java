package com.moon.demo.design.design.chapter17.decorator.weapon;

/**
 * @classname: Test
 * @description: 测试
 * @author: wuxiaojian
 * @create: 2024-01-04 09:29
 */
public class Test {

    public static void main(String[] args) {
        Weapon sword = new Sword();
        //加绿宝石
        sword = new GreenDiamond(sword);
        //加红宝石
        sword = new RedDiamond(sword);
        //攻击加成
        sword = new AttackBuff(sword);
        System.out.println(sword.damage());
    }
}

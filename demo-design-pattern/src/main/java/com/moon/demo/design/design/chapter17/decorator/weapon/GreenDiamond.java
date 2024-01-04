package com.moon.demo.design.design.chapter17.decorator.weapon;

/**
 * @classname: GreenDiamond
 * @description: 绿宝石
 * @author: wuxiaojian
 * @create: 2024-01-04 09:26
 */
public class GreenDiamond implements WeaponDecorator{

    private final Weapon weapon;

    public GreenDiamond(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public int damage() {
        return this.weapon.damage() + 10;
    }
}

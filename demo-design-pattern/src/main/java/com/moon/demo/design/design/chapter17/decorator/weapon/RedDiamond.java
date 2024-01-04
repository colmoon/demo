package com.moon.demo.design.design.chapter17.decorator.weapon;

/**
 * @classname: RedDiamond
 * @description: 红宝石
 * @author: wuxiaojian
 * @create: 2024-01-04 09:26
 */
public class RedDiamond implements WeaponDecorator{

    private final Weapon weapon;

    public RedDiamond(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public int damage() {
        return this.weapon.damage() + 20;
    }
}

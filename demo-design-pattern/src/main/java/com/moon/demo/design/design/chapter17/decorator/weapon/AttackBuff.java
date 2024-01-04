package com.moon.demo.design.design.chapter17.decorator.weapon;

/**
 * @classname: AttackBuff
 * @description: 攻击加成
 * @author: wuxiaojian
 * @create: 2024-01-04 09:26
 */
public class AttackBuff implements WeaponDecorator{

    private final Weapon weapon;

    public AttackBuff(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public int damage() {
        return this.weapon.damage() * 2;
    }
}

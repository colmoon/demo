package com.anhen.design.chapter1;

/**
 * @author wuxiaojian
 */
public class Snipper {
    public void killEnemy(Aug aug) {
        //首先看看敌人的情况， 别杀死敌人， 自己也被人干掉
        aug.zoomOut();
        //开始射击
        aug.shoot();
    }
}
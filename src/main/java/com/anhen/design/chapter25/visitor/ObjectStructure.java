package com.anhen.design.chapter25.visitor;

import java.util.Random;

/**
 * @classname: ObjectStructure
 * @description: TODO
 * @author: wuxiaojian
 * @create: 2021-11-11 19:09
 */
public class ObjectStructure {
    //对象生成器， 这里通过一个工厂方法模式模拟
    public static Element createElement(){
        Random random = new Random();
        if (random.nextInt(100) > 50){
            return new ConcreteElement1();
        } else {
            return new ConcreteElement2();
        }
    }
}

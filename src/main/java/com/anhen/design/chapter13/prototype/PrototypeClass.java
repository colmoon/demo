package com.anhen.design.chapter13.prototype;


/**
 * 为浅拷贝，构造函数不会执行
 * @author wuxiaojian
 */
public class PrototypeClass implements Cloneable {
    //覆写父类Object方法
    @Override
    public PrototypeClass clone() {
        PrototypeClass prototypeClass = null;
        try {
            prototypeClass = (PrototypeClass) super.clone();
        } catch (CloneNotSupportedException e) {
            //异常处理
        }
        return prototypeClass;
    }
}
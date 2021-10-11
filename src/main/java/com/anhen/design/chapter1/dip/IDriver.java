package com.anhen.design.chapter1.dip;

public interface IDriver {
    //是司机就应该会驾驶汽车
    void drive(ICar car);
}
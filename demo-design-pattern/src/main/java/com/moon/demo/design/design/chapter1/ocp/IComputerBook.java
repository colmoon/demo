package com.moon.demo.design.design.chapter1.ocp;

public interface IComputerBook extends IBook{
    //计算机书籍是有一个范围
    String getScope();
}
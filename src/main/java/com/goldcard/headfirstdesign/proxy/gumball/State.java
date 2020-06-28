package com.goldcard.headfirstdesign.proxy.gumball;

import java.io.Serializable;

/**
 * @MethodName
 * @Author wu.xiao.jian
 * @Description
 * @Param
 * @Return
 * @Date 2018/11/17 10:23
 */

public interface State extends Serializable {
    public void insertQuarter();
    public void ejectQuarter();
    public void turnCrank();
    public void dispense();
}

package com.goldcard.headfirstdesign.chain;

/**
 * @ClassName CopyrightProcess
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/12/3 19:46
 */
public class CopyrightProcess implements Process {
    @Override
    public void doProcess(String msg) {
        System.out.println(msg + "版权处理");
    }
}

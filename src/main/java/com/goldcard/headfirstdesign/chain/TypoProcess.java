package com.goldcard.headfirstdesign.chain;

/**
 * @ClassName TypoProcess
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/12/3 19:47
 */
public class TypoProcess implements Process {
    @Override
    public void doProcess(String msg) {
        System.out.println(msg + "错误处理");
    }
}

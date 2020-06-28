package com.goldcard.headfirstdesign.chain;

/**
 * @ClassName SensitiveWordProcess
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/12/3 19:45
 */
public class SensitiveWordProcess implements Process {
    @Override
    public void doProcess(String msg) {
        System.out.println(msg + "敏感词处理");
    }
}

package com.moon.demo.design.headfirst.chain;

import java.util.ArrayList;

/**
 * @ClassName MsgProcessChain
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/12/3 19:48
 */
public class MsgProcessChain {
    private ArrayList<Process> chains = new ArrayList<>();

    public MsgProcessChain addChain(Process process){
        chains.add(process);
        return this;
    }

    public void process(String msg){
        for (Process process : chains){
            process.doProcess(msg);
        }
    }
}

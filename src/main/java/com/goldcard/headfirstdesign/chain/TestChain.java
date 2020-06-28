package com.goldcard.headfirstdesign.chain;

/**
 * @ClassName TestChain
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/12/3 19:48
 */
public class TestChain {
    public static void main(String[] args) {
        MsgProcessChain msgProcessChain = new MsgProcessChain();

        msgProcessChain.addChain(new CopyrightProcess())
                .addChain(new SensitiveWordProcess())
                .addChain(new TypoProcess());

        msgProcessChain.process("test");
    }
}

package com.goldcard.headfirstdesign.command;

/**
 * @ClassName SimpleRemoteControl
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/10 11:20
 */
public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl(){ };

    public void setCommand(Command command){
        slot = command;
    }

    public void buttonWasPressed(){
        slot.execute();
    }
}

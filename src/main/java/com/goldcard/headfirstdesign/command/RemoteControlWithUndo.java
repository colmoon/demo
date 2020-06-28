package com.goldcard.headfirstdesign.command;

/**
 * @ClassName RemoteControlWithUndo
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/11 10:22
 */
public class RemoteControlWithUndo extends RemoteControl{
    private Command undoCommand;

    public RemoteControlWithUndo() {
        super();
        undoCommand = new NoCommand();
    }

    public void undoButtonWasPushed(){
        undoCommand.undo();
    }

}

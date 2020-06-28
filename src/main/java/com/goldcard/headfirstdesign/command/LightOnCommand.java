package com.goldcard.headfirstdesign.command;

import com.goldcard.headfirstdesign.command.Light;

/**
 * @ClassName LightOnCommand
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/10 11:15
 */
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}


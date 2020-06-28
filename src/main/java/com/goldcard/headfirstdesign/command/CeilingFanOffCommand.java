package com.goldcard.headfirstdesign.command;

/**
 * @ClassName CeliingFanOffCommand
 * @Description
 * @Author wu.xiao.jian
 * @Version V1.0.0
 * @Date 2018/11/11 10:44
 */
public class CeilingFanOffCommand extends CeilingFanCommand {

    public CeilingFanOffCommand(CeilingFan ceilingFan){
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.setOff();
    }

}

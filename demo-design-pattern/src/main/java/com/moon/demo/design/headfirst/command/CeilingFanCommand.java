package com.moon.demo.design.headfirst.command;

/**
 * @ClassName CeilingFanCommand
 * @Description
 * @Author wuxiaojian
 * @Date 2019/7/22 10:13
 * @Version 1.0
 **/

public abstract class CeilingFanCommand implements Command{
    protected CeilingFan ceilingFan;
    protected int prevSpeed;

    @Override
    public void execute() {

    }

    @Override
    public void undo() {
        switch (prevSpeed) {
            case CeilingFan.HIGH:
                ceilingFan.setHigh();
                break;
            case CeilingFan.MEDIUM:
                ceilingFan.setMedium();
                break;
            case CeilingFan.LOW:
                ceilingFan.setLow();
                break;
            case CeilingFan.OFF:
                ceilingFan.setOff();
        }
    }
}

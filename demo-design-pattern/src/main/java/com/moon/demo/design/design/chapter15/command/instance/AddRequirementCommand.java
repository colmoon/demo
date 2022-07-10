package com.moon.demo.design.design.chapter15.command.instance;

public class AddRequirementCommand extends Command {
    //执行增加一项需求的命令
    @Override
    public void execute() {
        //找到需求组
        super.rg.find();
        //增加一份需求super.rg.add();
        //给出计划
        super.rg.plan();
    }
}
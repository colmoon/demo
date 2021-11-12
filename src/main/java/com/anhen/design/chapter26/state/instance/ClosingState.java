package com.anhen.design.chapter26.state.instance;

/**
 * @author wuxiaojian
 */
public class ClosingState extends LiftState {
    //电梯门关闭， 这是关闭状态要实现的动作
    @Override
    public void close() {
        System.out.println("电梯门关闭...");
    }

    //电梯门关了再打开
    @Override
    public void open() {
        //置为敞门状态
        super.context.setLiftState(Context.openningState);
        super.context.getLiftState().open();
    }

    //电梯门关了就运行， 这是再正常不过了
    @Override
    public void run() {
        //设置为运行状态
        super.context.setLiftState(Context.runningState);
        super.context.getLiftState().run();
    }

    //电梯门关着， 我就不按楼层
    @Override
    public void stop() {
        //设置为停止状态
        super.context.setLiftState(Context.stoppingState);
        super.context.getLiftState().stop();
    }
}
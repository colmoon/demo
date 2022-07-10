package com.moon.demo.service.designPattern.status.demo2;

/**
 * @ClassName Callback
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/7/19 10:38
 * @Version 1.0
 **/

public class Callback {
    //before modify
    public void callback1(ApprovalState state) throws Exception{
        if (ApprovalState.YES.equals(state)){
            //do something
        }
        if (ApprovalState.NO.equals(state)){
            //do something
        }
        if (ApprovalState.CANCEL.equals(state)){
            //do something
        }
        throw new CallException("unsupported state");
    }

    //after modify
    public void callback(ApprovalState approvalState) throws Exception{
        State state = StateFactory.get(approvalState);
        if (state == null){
            throw  new CallException("unsupported state");
        }
        state.action();
    }

    //before modify
    public void forYes1(String param){
        if (null != param){
            //some code
            boolean isExist = exist();
            if (isExist){
                //some code
            } else {
                //some code
            }
        } else {
            //some code
        }
    }

    //after modify
    //在if else的优化中，一个核心的思路就是：更少的缩进、更少的else
    public void forYes(String param){
        if (null == param){
            return;
        }

        boolean isExist = exist();
        if (!isExist){
            //some code
            return;
        }

        //some code
        System.out.println();
    }


    private boolean exist(){
        return true;
    }

    public static void main(String[] args) {

    }
}

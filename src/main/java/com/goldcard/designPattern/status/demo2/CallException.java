package com.goldcard.designPattern.status.demo2;

import com.goldcard.callback.demo2.Calculation;

/**
 * @ClassName CallException
 * @Description 自定义异常
 * @Author wuxiaojian
 * @Date 2019/7/19 10:52
 * @Version 1.0
 **/

public class CallException extends Exception {
    public CallException(String msg){
        super(msg);
    }
}

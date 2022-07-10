package com.moon.demo.service.callback.demo2;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName Calculation
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/7/9 15:03
 * @Version 1.0
 **/

public class Calculation {
    public void executeMessage(Callback callback, String question){
        System.out.println(callback.getClass().getName() + "'s question : " + question);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException exception){
            System.out.println(exception.getMessage());
        }
        String result = "2";
        callback.solve(result);
    }
}

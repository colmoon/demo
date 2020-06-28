package com.goldcard.timer;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

public class HashedWheelTimerTest {


    public static void main(String[] argv) {

        final Timer timer = new HashedWheelTimer(Executors.defaultThreadFactory(), 100, TimeUnit.MILLISECONDS, 512);

        TimerTask task1 = (Timeout timeout) -> {
                System.out.println("task 1 will run per 5 seconds ");
                System.out.println(System.currentTimeMillis());
//                timer.newTimeout(this, 5, TimeUnit.SECONDS);//结束时候再次注册
            };
        Timeout timeout = timer.newTimeout(task1, 0, TimeUnit.SECONDS);
//        timeout.cancel();
        System.out.println(System.currentTimeMillis());

        TimerTask task2 = new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("task 2 will run per 10 seconds");
                System.out.println(System.currentTimeMillis());
//                timer.newTimeout(this, 10, TimeUnit.SECONDS);//结束时候再注册
            }
        };
        timer.newTimeout(task2, 10, TimeUnit.SECONDS);


       //该任务仅仅运行一次
        timer.newTimeout(new TimerTask() {
            @Override
            public void run(Timeout timeout) throws Exception {
                System.out.println("task 3 run only once ! ");
                System.out.println(System.currentTimeMillis());
            }
        }, 15, TimeUnit.SECONDS);

    }


}
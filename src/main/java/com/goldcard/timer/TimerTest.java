package com.goldcard.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName TimerTest
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2020/2/17 9:56
 * @Version 1.0
 **/

public class TimerTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
                           @Override
                           public void run() {
                               System.out.println("test");
                           }
                       }
        ,5000);
    }
}

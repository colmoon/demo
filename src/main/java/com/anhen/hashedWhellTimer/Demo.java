package com.anhen.hashedWhellTimer;

import io.netty.util.HashedWheelTimer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/9/4 14:48
 * @Version 1.0
 **/

public class Demo {
    public static void main(String[] args) throws Exception{
        test1();
    }

    public static void test1() throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        HashedWheelTimer hashedWheelTimer = new HashedWheelTimer(100, TimeUnit.MILLISECONDS);
        System.out.println("start:" + LocalDateTime.now().format(formatter));
        hashedWheelTimer.newTimeout(timeout -> {
            System.out.println("task :" + LocalDateTime.now().format(formatter));
        }, 3, TimeUnit.SECONDS);
        Thread.sleep(5000);
    }
}

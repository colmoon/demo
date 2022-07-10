package com.moon.demo.algorithm.chapter1;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName StopWatch
 * @Description 计时器
 * @Author wuxiaojian
 * @Date 2019/5/30 20:58
 * @Version 1.0
 **/

public class StopWatch {
    private final long start;
    public StopWatch(){
        start = System.currentTimeMillis();
    }
    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    public static void main(String[] args) throws InterruptedException {
        StopWatch watch = new StopWatch();
        TimeUnit.SECONDS.sleep(2);
        double time = watch.elapsedTime();
        System.out.println("耗时：" + time + "s");
    }
}

package com.anhen.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TestSchedulePool
 * @Description TODO
 * @Author wuxiaojian
 * @Date 2019/6/13 8:56
 * @Version 1.0
 **/
@Slf4j
//@EnableScheduling
@Component
public class TestSchedulePool {
    public static void main(String[] args) {
        ScheduledExecutorService pool = new ScheduledThreadPoolExecutor(10);
        pool.scheduleAtFixedRate(new TestSchedulePool().new work(), 0, 5, TimeUnit.SECONDS);
    }

    public class work implements Runnable {
        @Override
        public void run() {
            System.out.println("**************" + new Date());
        }
    }

    @Scheduled(fixedDelay = 5000)
    public void testTask() {
        log.info("测试定时任务");
    }
}

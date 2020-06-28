package com.anhen.demo;

import cn.hutool.core.thread.NamedThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName CheckThread
 * @Description 检查线程
 * @Author wuxiaojian
 * @Date 2019/8/19 13:23
 * @Version 1.0
 **/

public class CheckThread {
    private static final ExecutorService CHECK_TREAD = Executors.newSingleThreadExecutor(
            new NamedThreadFactory("check_service",false));
    private volatile boolean checkFlag = true;
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        System.out.println("tt");
        CHECK_TREAD.submit(()->new CheckThread().checkThings());
    }

    private void checkThings(){
        lock.lock();
        if (!checkFlag){
            return;
        }
        try {
            while (checkFlag){
                condition.await(10, TimeUnit.SECONDS);
                if (!checkFlag){
                    break;
                } else {
                    System.out.println("this thread will check every 10 seconds");
                }
            }
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        } finally {
            lock.unlock();
        }
    }
}

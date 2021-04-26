package com.goldcard.concurrency.chapter3;

import java.util.concurrent.locks.ReentrantLock;


/**
 * @author wuxiaojian
 * @description: 获取锁的线程顺序正是线程启动的顺序
 */

public class MyFairLock {
    /**
     *     true 表示 ReentrantLock 的公平锁
     */
    private  ReentrantLock lock = new ReentrantLock(true);

    public void testFair(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() +"获得了锁");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyFairLock fairLock = new MyFairLock();
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName()+"启动");
            fairLock.testFair();
        };
        Thread[] threadArray = new Thread[10];
        for (int i=0; i<10; i++) {
            threadArray[i] = new Thread(runnable);
        }
        for (int i=0; i<10; i++) {
            threadArray[i].start();
        }
    }
}
package com.anhen.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @classname: AlternatePrinting
 * @description: 交替打印
 * @author: wuxiaojian
 * @create: 2021-04-29 09:08
 */

public class AlternatePrinting {

    public static void main(String[] args) {
        Kaola kaola = new Kaola(10);
        Thread thread1 = new Thread(() -> {
            try {
                kaola.kao(() -> System.out.println("kao"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread1.start();

        Thread thread2 = new Thread(() -> {
            try {
                kaola.la(() -> System.out.println("la"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread2.start();
    }

    public static class Kaola {
        private int n;

        public Kaola(int n) {
            this.n = n;
        }

        private volatile boolean kao = true;

        private ReentrantLock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        public void kao(Runnable printKao) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                lock.lock();
                try {
                    if (kao){
                        printKao.run();
                        kao = false;
//                        condition.signal();
                    } else {
//                        condition.await();
                        i--;
                    }
                } finally {
                    lock.unlock();
                }

            }
        }

        public void la(Runnable printLa) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                lock.lock();
                try {
                    if (!kao){
                        printLa.run();
                        kao = true;
//                        condition.signal();
                    } else{
//                        condition.await();
                        i--;
                    }
                } finally {
                    lock.unlock();
                }

            }
        }
    }

}

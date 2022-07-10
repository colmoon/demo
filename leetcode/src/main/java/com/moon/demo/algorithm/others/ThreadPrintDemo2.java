package com.moon.demo.algorithm.others;

import java.util.concurrent.TimeUnit;

class ThreadPrintDemo2 {
  public static void main(String[] args) {
    final ThreadPrintDemo2 demo2 = new ThreadPrintDemo2();
    Thread t1 = new Thread(demo2::print1);
    Thread t2 = new Thread(demo2::print2);

    t1.start();
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (Exception e){
      e.printStackTrace();
    }
    t2.start();
  }

  public synchronized void print2() {
    for (int i = 1; i <= 100; i += 2) {
      System.out.println(i);
      this.notify();
      try {
        this.wait();
//        Thread.sleep(100);// 防止打印速度过快导致混乱
      } catch (InterruptedException e) {
        // NO
      }
    }
  }

  public synchronized void print1() {
    for (int i = 0; i <= 100; i += 2) {
      System.out.println(i);
      this.notify();
      try {
        this.wait();
//        Thread.sleep(100);// 防止打印速度过快导致混乱
      } catch (InterruptedException e) {
        // NO
      }
    }
  }
}
package com.moon.demo.algorithm.others;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadPrintDemo {

  static AtomicInteger cxsNum = new AtomicInteger(0);
  static volatile boolean flag = false;

  public static void main(String[] args) {

    Thread t1 = new Thread(() -> {
      for (; 100 > cxsNum.get(); ) {
        if (!flag && (cxsNum.get() == 0 || cxsNum.incrementAndGet() % 2 == 0)) {
          try {
            Thread.sleep(100);// 防止打印速度过快导致混乱
          } catch (InterruptedException e) {
            //NO
          }

          System.out.println(cxsNum.get());
          flag = true;
        }
      }
    }
    );

    Thread t2 = new Thread(() -> {
      for (; 100 > cxsNum.get(); ) {
        if (flag && (cxsNum.incrementAndGet() % 2 != 0)) {
          try {
            Thread.sleep(100);// 防止打印速度过快导致混乱
          } catch (InterruptedException e) {
            //NO
          }

          System.out.println(cxsNum.get());
          flag = false;
        }
      }
    }
    );

    t1.start();
    t2.start();
  }
}
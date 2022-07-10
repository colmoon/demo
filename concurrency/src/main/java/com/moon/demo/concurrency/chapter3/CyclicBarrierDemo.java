/**  

* <p>Title: CyclicBarrierDemo.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月27日  

* @version 1.0  

*/  
package com.moon.demo.concurrency.chapter3;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**  

* <p>Title: CyclicBarrierDemo</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月27日  

*/
public class CyclicBarrierDemo {
	public static class Solider implements Runnable{
		private String solider;
		private CyclicBarrier cyclicBarrier;
		public Solider(CyclicBarrier cyclicBarrier, String soliderName) {
			this.cyclicBarrier = cyclicBarrier;
			this.solider = soliderName;
		}
		@Override
        public void run() {
			try {
				//等待所有士兵到齐
				cyclicBarrier.await();
				doWork();
				//等待所有士兵完成工作
				cyclicBarrier.await();
//				doWork();
//				//等待所有士兵完成工作
//				cyclicBarrier.await();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
			
		}
		
		public void doWork() {
			try {
				Thread.sleep(Math.abs(new Random().nextInt()%10000));			
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			System.out.println(solider + " :任务完成");
		}
	}
	
	public static class BarrierRun implements Runnable{
		boolean flag;
		int num;
		
		public BarrierRun(boolean flag, int num) {
			this.flag = flag;
			this.num = num;
		}
		
		@Override
        public void run() {
			if(flag) {
				System.out.println("司令：[士兵" + num + "个，任务完成]");
			}else {
				System.out.println("司令：[士兵" + num + "个，集合完毕]");
				flag = true;
			}
		}
	}
	
	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		final int num = 10;
		Thread[] allSolider = new Thread[num];
		boolean flag = false;
		CyclicBarrier cyclicBarrier = new CyclicBarrier(num, new BarrierRun(flag, num));
		//设置屏障点，主要是为了执行这个方法
		System.out.println("集合队伍！");
		for (int i = 0; i < num; i++) {
			System.out.println("士兵" + i + " 报道！");
			allSolider[i] = new Thread(new Solider(cyclicBarrier, "士兵" + i));
			allSolider[i].start();
//			if(i == 5) {
//				allSolider[0].interrupt();
//			}
		}
	}

}

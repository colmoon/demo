/**  

* <p>Title: AtomicIntegerFieldUpdaterDemo.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月29日  

* @version 1.0  

*/  
package com.moon.demo.concurrency.chapter4;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**  

* <p>Title: AtomicIntegerFieldUpdaterDemo</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月29日  

*/
public class AtomicIntegerFieldUpdaterDemo {
	public static class Candidate{
		int id;
		volatile int score;
	}
	public final static AtomicIntegerFieldUpdater<Candidate> scoreUpdater = AtomicIntegerFieldUpdater.newUpdater(Candidate.class,"score");
	//检查Updater是否工作正确
	public static AtomicInteger allScore = new AtomicInteger(0);
	
	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		final Candidate stu = new Candidate();
		Thread[] threads = new Thread[10000];
		for (int i = 0; i < 10000; i++) {
			threads[i] = new Thread() {
				@Override
                public void run() {
					if(Math.random() > 0.4) {
						scoreUpdater.incrementAndGet(stu);
						allScore.incrementAndGet();
					}
				}
			};
			threads[i].start();
		}
		for (int i = 0; i < 10000; i++) {
			threads[i].join();
		}
		System.out.println("score = "+stu.score);
		System.out.println("allscore = " + allScore);
	}

}

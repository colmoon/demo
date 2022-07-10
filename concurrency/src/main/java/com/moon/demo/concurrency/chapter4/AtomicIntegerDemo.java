/**  

* <p>Title: AtomicIntegerDemo.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月29日  

* @version 1.0  

*/  
package com.moon.demo.concurrency.chapter4;

import java.util.concurrent.atomic.AtomicInteger;


/**  

* <p>Title: AtomicIntegerDemo</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月29日  

*/
public class AtomicIntegerDemo {
	static AtomicInteger aInteger = new AtomicInteger(0);
	static int a = 0;
	final static Object obj = new Object();
	
	public static class AddThread implements Runnable{
		private int mode;
		public AddThread(int mode) {
			this.mode = mode;
		}
		@Override
        public void run() {
			if (0 == mode) {
				for (int i = 0; i < 10000; i++) {
					aInteger.incrementAndGet();
				}
			} else if (1 == mode) {
				synchronized (this) {
					for (int i = 0; i < 10000; i++) {
						a++;
					}
				}
			}
			
		}
	}
	
	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) throws InterruptedException{
		Thread[] threads = new Thread[10];
		long b = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new AddThread(0)); 
			threads[i].start();
		}
		for (int i = 0; i < 10; i++) {
			threads[i].join();
		}
		long e = System.currentTimeMillis();
		System.out.println(aInteger);
		System.out.println("CAS spend " + (e-b)+"ms");
		
		b = System.currentTimeMillis();
		Runnable runnable = new AddThread(1);
		for (int i = 0; i < 10; i++) {
//			threads[i] = new Thread(new AddThread(1)); 
			threads[i] = new Thread(runnable); 
			threads[i].start();
		}
		for (int i = 0; i < 10; i++) {
			threads[i].join();
		}
		e = System.currentTimeMillis();
		System.out.println(a);
		System.out.println("synchronized spend " + (e-b)+"ms");
		
	}

}

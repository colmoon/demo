/**  

* <p>Title: AtomicIntegerArrayDemo.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月29日  

* @version 1.0  

*/  
package com.goldcard.concurrency.chapter4;

import java.util.concurrent.atomic.AtomicIntegerArray;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**  

* <p>Title: AtomicIntegerArrayDemo</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月29日  

*/
public class AtomicIntegerArrayDemo {
	static AtomicIntegerArray array = new AtomicIntegerArray(10);
	public static class AddThread implements Runnable{
		@Override
        public void run() {
			for (int i = 0; i < 10000; i++) {
				array.getAndIncrement(i % array.length());
			}
		}
	}
	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new AddThread());
			threads[i].start();
		}
		for (int i = 0; i < 10; i++) {
			threads[i].join();
		}
		System.out.println(array);
	}
}

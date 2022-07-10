/**  

* <p>Title: CountDownLatchDemo.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月27日  

* @version 1.0  

*/  
package com.moon.demo.concurrency.chapter3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**  

* <p>Title: CountDownLatchDemo</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月27日  

*/
public class CountDownLatchDemo implements Runnable {
	static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(10);
	static final CountDownLatchDemo demo = new CountDownLatchDemo();
	/* (non-Javadoc)  
	
	 * <p>Title: run</p>  
	
	 * <p>Description: </p>  
	  
	
	 * @see java.lang.Runnable#run()  
	
	 */
	@Override
    public void run() {
		// TODO Auto-generated method stub
		try {
			//模拟检查任务
			Thread.sleep(new Random().nextInt(10)*1000);
			System.out.println(Thread.currentThread().getId() + " check complete");
			COUNT_DOWN_LATCH.countDown();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			executorService.submit(demo);
		}
		//等待检查
		try {
			COUNT_DOWN_LATCH.await();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("All task ends, Fire!");
		executorService.shutdown();
	}

}

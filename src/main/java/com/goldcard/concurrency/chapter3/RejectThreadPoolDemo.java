/**  

* <p>Title: RejectThreadPoolDemo.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月27日  

* @version 1.0  

*/  
package com.goldcard.concurrency.chapter3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**  

* <p>Title: RejectThreadPoolDemo</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月27日  

*/
public class RejectThreadPoolDemo {
	public static class MyTask implements Runnable{
		@Override
        public void run() {
			System.out.println(System.currentTimeMillis() +" :Thread ID:"
					+ Thread.currentThread().getId());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
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
		MyTask task = new MyTask();
		ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(10), Executors.defaultThreadFactory(),new RejectedExecutionHandler() {	
			@Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
				// TODO Auto-generated method stub
				System.out.println(r.toString() + " is discard");
			}
		});
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			executorService.submit(task);
			Thread.sleep(10);
		}
	}

}

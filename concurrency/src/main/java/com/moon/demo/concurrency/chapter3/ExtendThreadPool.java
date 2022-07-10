/**  

* <p>Title: ExtendThreadPool.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月27日  

* @version 1.0  

*/  
package com.moon.demo.concurrency.chapter3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**  

* <p>Title: ExtendThreadPool</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月27日  

*/
public class ExtendThreadPool {
	public static class MyTask implements Runnable{
		public String name;
		public MyTask(String name) {
			this.name = name;
		}
		@Override
        public void run() {
			System.out.println("正在执行" + ":Thread ID:" + Thread.currentThread().getId() + ",Task Name = " + name );
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
		ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()) {
			@Override
            protected void beforeExecute(Thread t, Runnable r){
				System.out.println("准备执行： " + ((MyTask)r).name);				
			}
			@Override
            protected void afterExecute(Runnable r, Throwable throwable){
				System.out.println("执行完成： " + ((MyTask)r).name);				
			}
			@Override
            protected void terminated(){
				System.out.println("线程池退出");				
			}
		};
		
		for (int i = 0; i < 5; i++) {
			MyTask task = new MyTask("Task-Geym" + i);
			executorService.execute(task);
//			Thread.sleep(1000);
		}
		System.out.println(Runtime.getRuntime().availableProcessors());
		executorService.shutdown();
	}

}

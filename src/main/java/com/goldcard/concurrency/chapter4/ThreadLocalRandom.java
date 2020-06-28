/**  

* <p>Title: ThreadLocalRandom.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月28日  

* @version 1.0  

*/  
package com.goldcard.concurrency.chapter4;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**  

* <p>Title: ThreadLocalRandom</p>  

* <p>Description: 多线程下产生随机数的问题</p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月28日  

*/
public class ThreadLocalRandom {
	public static final int GEN_COUNT = 10000000;
	public static final int THREAD_COUNT = 4;
	static ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
	public static Random random = new Random(123);
	public static ThreadLocal<Random> tRnd = new ThreadLocal<Random>() {
		@Override
        protected Random initialValue() {
			return new Random(123);
		}
	};
	
	public static class RndTask implements Callable<Long>{
		private int mode = 0;
		public RndTask(int mode) {
			this.mode = mode;
		}
		public Random getRandom() {
			if (mode == 0) {
				return random;
			} else if(mode == 1){
				return tRnd.get();
			} else {
				return null;
			}
		}
		@Override
        public Long call() {
			long b = System.currentTimeMillis();
			for (int i = 0; i < GEN_COUNT; i++) {
				getRandom().nextInt();
			}
			long e = System.currentTimeMillis();
			System.out.println(Thread.currentThread().getName() + " spend" + (e-b)+"ms");
			return e-b;
		}
	}
	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) throws InterruptedException,ExecutionException{
		// TODO Auto-generated method stub
		Future<Long>[] futures = new Future[THREAD_COUNT];
		for (int i = 0; i <THREAD_COUNT; i++) {
			futures[i] = executorService.submit(new RndTask(0));
		}
		long totaltime = 0;
		for (int i = 0; i < THREAD_COUNT; i++) {
			totaltime += futures[i].get();
		}
		System.out.println("多线程访问同一个Random 实例：" + totaltime +"ms");
		
		//使用 ThreadLocal 的情况
		for (int i = 0; i <THREAD_COUNT; i++) {
			futures[i] = executorService.submit(new RndTask(1));
		}
		totaltime = 0;
		for (int i = 0; i < THREAD_COUNT; i++) {
			totaltime += futures[i].get();
		}
		System.out.println("使用ThreadLocal 包装 Random 实例：" + totaltime +"ms");
		executorService.shutdown();
	}

}

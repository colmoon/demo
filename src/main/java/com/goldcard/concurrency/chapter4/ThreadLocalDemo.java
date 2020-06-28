/**  

* <p>Title: ThreadLocalDemo.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月28日  

* @version 1.0  

*/  
package com.goldcard.concurrency.chapter4;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**  

* <p>Title: ThreadLocalDemo</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月28日  

*/
public class ThreadLocalDemo {
	static volatile ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<SimpleDateFormat>() {
		@Override
        protected void finalize() throws Throwable{
			System.out.println(this.toString() + "is gc");
		}
	};
	static volatile CountDownLatch countDownLatch = new CountDownLatch(10);
	public static class ParseDate implements Runnable{
		int i = 0;
		public ParseDate(int i) {
			this.i = i;
		}
		@Override
        public void run() {
			try {
				if (t1.get() == null) {
					t1.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"){
						@Override
                        protected void finalize() throws Throwable{
							System.out.println(this.toString() + "is gc");
						}
					});
					System.out.println(Thread.currentThread().getId() + ":create SimpleDateFormat");
				}
				Date date = t1.get().parse("2015-03-29 19:29:" + i % 60);
				System.out.println(Thread.currentThread().getId() + ":" + date);
			} catch (ParseException e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				countDownLatch.countDown();
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
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			executorService.execute(new ParseDate(i));
		}
		countDownLatch.await();
		System.out.println("mission complete!");
		t1 = null;
		System.gc();
		System.out.println("first GC complete!");
		//在设置ThreadLoca 的时候，会清除ThreadLocalMap 中的无效对象
		t1 = new ThreadLocal<SimpleDateFormat>();
		countDownLatch = new CountDownLatch(10);
		for (int i = 0; i < 10; i++) {
			executorService.execute(new ParseDate(i));
		}
		countDownLatch.await();
		Thread.sleep(1000);
		System.gc();
		System.out.println("second GC complete!");
		executorService.shutdown();
	}

}

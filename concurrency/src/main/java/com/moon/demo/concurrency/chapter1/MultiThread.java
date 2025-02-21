/**  

* <p>Title: MultiThreadLong.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月20日  

* @version 1.0  

*/  
package com.moon.demo.concurrency.chapter1;

/**  

* <p>Title: MultiThreadLong</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月20日  

*/
public class MultiThread {
	public long t = 0;

	Object object = new Object();

	public class ChangeT implements Runnable{
		@Override
        public void run() {
			int i = 0;
			while (i < 100000) {
				synchronized (object) {
					t++;
					i++;
				}
			}
		}
	}

	public class ReadT implements Runnable{
		@Override
		public void run() {
			int j = 0;
			while (j < 100000) {
				synchronized (object) {
					t++;
					j++;
				}
			}
		}
	}

	private void test() throws InterruptedException {
		Thread thread = new Thread(new ChangeT());
		Thread thread1 = new Thread(new ReadT());
		thread.start();
		thread1.start();
		thread1.join();
		thread.join();
		System.out.println(t);
	}
	
	
	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) throws InterruptedException {
		new MultiThread().test();
	}

}

/**  

* <p>Title: TimeLock.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月23日  

* @version 1.0  

*/  
package com.goldcard.concurrency.chapter3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**  

* <p>Title: TimeLock</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月23日  

*/
public class TimeLock implements Runnable {
	public static ReentrantLock lock = new ReentrantLock();
	/* (non-Javadoc)  
	
	 * <p>Title: run</p>  
	
	 * <p>Description: </p>  
	  
	
	 * @see java.lang.Runnable#run()  
	
	 */
	@Override
    public void run() {
		// TODO Auto-generated method stub
		try {
			if(lock.tryLock(5, TimeUnit.SECONDS)) {
				Thread.sleep(6000);
			} else {
				System.out.println("get lock failed");
			}
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
		TimeLock timeLock = new TimeLock();
		Thread t1 = new Thread(timeLock);
		Thread t2 = new Thread(timeLock);
		t1.start();
		t2.start();
	}

}

/**  

* <p>Title: FairLock.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月27日  

* @version 1.0  

*/  
package com.moon.demo.concurrency.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**  

* <p>Title: FairLock</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月27日  

*/
public class FairLock implements Runnable {
	public static ReentrantLock fairLock = new ReentrantLock(true);

	@Override
    public void run() {
		while(true) {
			try {
				fairLock.lock();
				System.out.println(Thread.currentThread().getName() + " get the lock");
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			} finally {
				fairLock.unlock();
			}
		}
	}

	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FairLock r1 = new FairLock();
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		t1.start();
		t2.start();
	}

}

/**  

* <p>Title: ReadWriteLockDemo.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月27日  

* @version 1.0  

*/  
package com.goldcard.concurrency.chapter3;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**  

* <p>Title: ReadWriteLockDemo</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月27日  

*/
public class ReadWriteLockDemo {
	private static Lock lock = new ReentrantLock();
	private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private static Lock readLock = readWriteLock.readLock();
	private static Lock writeLock = readWriteLock.writeLock();
	private int value;
	
	public Object handleRead(Lock lock) throws InterruptedException{
		try {
			lock.lock();//模拟读操作
			Thread.sleep(1000);//模拟读操作的耗时
			return value;
		} finally {
			// TODO: handle finally clause
			lock.unlock();
		}
	}
	
	public void handleWrite(Lock lock, int index) throws InterruptedException{
		try {
			lock.lock();//模拟写操作
			Thread.sleep(1000);//模拟写操作的耗时
			value = index;
		} finally {
			// TODO: handle finally clause
			lock.unlock();
		}
	}
	
	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final ReadWriteLockDemo demo = new ReadWriteLockDemo();
		Runnable readRunnable = new Runnable() {
			
			@Override
            public void run() {
				// TODO Auto-generated method stub
				try {
					demo.handleRead(readLock);
//					demo.handleRead(lock);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		};
		Runnable writeRunnable = new Runnable() {
			
			@Override
            public void run() {
				// TODO Auto-generated method stub
				try {
					demo.handleWrite(writeLock, new Random().nextInt());
//					demo.handleWrite(Lock, new Random().nextInt());
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		};
		
		for (int i = 0; i < 18; i++) {
			new Thread(readRunnable).start();
		}
		
		for (int i = 18; i < 20; i++) {
			new Thread(writeRunnable).start();
		}
	}

}

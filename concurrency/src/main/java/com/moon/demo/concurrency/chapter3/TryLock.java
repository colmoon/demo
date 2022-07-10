/**  

* <p>Title: TryLock.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月24日  

* @version 1.0  

*/  
package com.moon.demo.concurrency.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**  

* <p>Title: TryLock</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月24日  

*/
public class TryLock implements Runnable {
	public static ReentrantLock lock1 = new ReentrantLock();
	public static ReentrantLock lock2 = new ReentrantLock();
	int lock;
	/* (non-Javadoc)  
	
	 * <p>Title: run</p>  
	
	 * <p>Description: </p>  
	  
	
	 * @see java.lang.Runnable#run()  
	
	 */
	public TryLock(int lock) {
		this.lock = lock;
	}
	@Override
    public void run() {
		// TODO Auto-generated method stub
		if(lock == 1) {
			while(true) {
				if (lock1.tryLock()) {
					try {
						try {
							Thread.sleep(500);
						} catch (Exception e) {
							// TODO: handle exception
						}
						if(lock2.tryLock()) {
							try {
								System.out.println(Thread.currentThread().getId() + ":My job done");
								return;
							} catch (Exception e) {
								// TODO: handle exception
							} finally {
								lock2.unlock();
							}
						}
					} catch (Exception e) {
						// TODO: handle exception
					} finally {
						lock1.unlock();
					}
				}
			}
		} else {
			while(true) {
				if (lock2.tryLock()) {
					try {
						try {
							Thread.sleep(500);
						} catch (Exception e) {
							// TODO: handle exception
						}
						if(lock1.tryLock()) {
							try {
								System.out.println(Thread.currentThread().getId() + ":My job done");
								return;
							} catch (Exception e) {
								// TODO: handle exception
							} finally {
								lock1.unlock();
							}
						}
					} catch (Exception e) {
						// TODO: handle exception
					} finally {
						lock2.unlock();
					}
				}
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}
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
		TryLock r1 = new TryLock(1);
		TryLock r2 = new TryLock(2);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}

}

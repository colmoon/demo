/**  

* <p>Title: DeadLock.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月30日  

* @version 1.0  

*/  
package com.goldcard.concurrency.chapter4;

import java.util.concurrent.ArrayBlockingQueue;

/**  

* <p>Title: DeadLock</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月30日  

*/
public class DeadLock implements Runnable{
	protected Object tool;
	public String name;
	static Object fork1 = new Object();
	static Object fork2 = new Object();
	public DeadLock(Object obj) {
		this.tool = obj;
		if(tool == fork1) {
			this.name = "哲学家A";
		} 
		if(tool == fork2) {
			this.name = "哲学家B";
		}
	}
	@Override
    public void run() {
		if (tool == fork1) {
			synchronized (fork1) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				synchronized (fork2) {
					System.out.println("A is eating");
				}
			}
		}
		if (tool == fork2) {
			synchronized (fork2) {
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				synchronized (fork1) {
					System.out.println("B is eating");
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
		DeadLock aPerson = new DeadLock(fork1);
		DeadLock bPerson = new DeadLock(fork2);
		new Thread(aPerson).start();
		new Thread(bPerson).start();
		ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(10);
	}

}

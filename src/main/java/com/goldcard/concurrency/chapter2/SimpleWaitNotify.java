/**  

* <p>Title: SimpleWaitNotify.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月27日  

* @version 1.0  

*/  
package com.goldcard.concurrency.chapter2;


/**  

* <p>Title: SimpleWaitNotify</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月27日  

*/
public class SimpleWaitNotify {
	final static Object OBJECT = new Object();
	public static class T1 extends Thread{
		@Override
        public void run() {
			synchronized (OBJECT) {
				try {
					System.out.println(System.currentTimeMillis() + " :T1 start! ");
					OBJECT.wait();
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				System.out.println(System.currentTimeMillis()+" :T1 end!");
			}
		}
	}
	
	public static class T2 extends Thread{
		@Override
        public void run() {
			synchronized (OBJECT) {
				System.out.println(System.currentTimeMillis() + " :T2 start! ");
				OBJECT.notify();
				System.out.println(System.currentTimeMillis()+" :T2 end!");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
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
		Thread t1 = new T1();
		Thread t2 = new T2();
		t1.start();
		t2.start();
	}

}

/**  

* <p>Title: UnsafeArrayList.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年6月5日  

* @version 1.0  

*/  
package com.moon.demo.concurrency.chapter8;

import java.util.ArrayList;


/**  

* <p>Title: UnsafeArrayList</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年6月5日  

*/
public class UnsafeArrayList {
	static ArrayList<Object> arrayList = new ArrayList<Object>();
	static class AddTask implements Runnable{
		@Override
        public void run(){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
			for (int i = 0; i < 1000000; i++) {
				arrayList.add(new Object());
			}
		}
	}
	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) {
		Thread thread1 = new Thread(new AddTask(), "thread1");
		Thread thread2 = new Thread(new AddTask(), "thread2");
		thread1.start();
		thread2.start();
		Thread thread3 = new Thread(new Runnable(){
			@Override
            public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
			}
		},"thread3");
		thread3.start();
		System.out.println("end");
	}

}

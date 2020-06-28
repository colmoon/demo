/**  

* <p>Title: ThreadGroupName.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月22日  

* @version 1.0  

*/  
package com.goldcard.concurrency.chapter2;

/**  

* <p>Title: ThreadGroupName</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月22日  

*/
public class ThreadGroupName implements Runnable{

	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadGroup threadGroup = new ThreadGroup("PrintGroup");
		Thread t1 = new Thread(threadGroup, new ThreadGroupName(), "t1");
		Thread t2 = new Thread(threadGroup, new ThreadGroupName(), "t2");
		t1.start();
		t2.start();
		System.out.println(threadGroup.activeCount());
		threadGroup.list();
		System.out.println("main ends");
	}
	
	@Override
	public void run() {
		String groupAndName = Thread.currentThread().getThreadGroup().getName() 
				+ "-" + Thread.currentThread().getName();
		while(true) {
			System.out.println("I am " + groupAndName);
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}

/**  

* <p>Title: DaemonDemo.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月22日  

* @version 1.0  

*/  
package com.moon.demo.concurrency.chapter2;

/**  

* <p>Title: DaemonDemo</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月22日  

*/
public class DaemonDemo {
	public static class DaemonT extends Thread{
		@Override
        public void run() {
			while(true) {
				System.out.println("I am alive");
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
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
		Thread thread = new DaemonT();
		thread.setDaemon(true);
		thread.start();
		System.out.println("main thread ends");
	}

}

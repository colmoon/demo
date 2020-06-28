/**  

* <p>Title: ThreadInterrupt.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月27日  

* @version 1.0  

*/  
package com.goldcard.concurrency.chapter2;

/**  

* <p>Title: ThreadInterrupt</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月27日  

*/
public class ThreadInterrupt implements Runnable {

	/* (non-Javadoc)  
	
	 * <p>Title: run</p>  
	
	 * <p>Description: </p>  
	  
	
	 * @see java.lang.Runnable#run()  
	
	 */
	@Override
    public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(Thread.currentThread().isInterrupted()) {
				System.out.println("Interrupted");
				break;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO: handle exception
				System.out.println("Interrupted when sleep");
				Thread.currentThread().interrupt();
			}
			Thread.yield();
		}
	}

	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new ThreadInterrupt());
		t1.start();
		Thread.sleep(2000);
		t1.interrupt();
	}

}

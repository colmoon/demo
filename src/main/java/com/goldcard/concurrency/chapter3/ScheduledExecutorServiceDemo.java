/**  

* <p>Title: ScheduledExecutorServiceDemo.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月27日  

* @version 1.0  

*/  
package com.goldcard.concurrency.chapter3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import io.netty.util.concurrent.ScheduledFuture;

/**  

* <p>Title: ScheduledExecutorServiceDemo</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月27日  

*/
public class ScheduledExecutorServiceDemo {

	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
		scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
			
			@Override
            public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000);
					System.out.println(System.currentTimeMillis()/1000);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}, 0, 2, TimeUnit.SECONDS);
//		scheduledExecutorService.shutdown();
	}

}

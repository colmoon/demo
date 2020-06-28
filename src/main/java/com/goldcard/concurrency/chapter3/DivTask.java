/**  

* <p>Title: DivTask.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月27日  

* @version 1.0  

*/  
package com.goldcard.concurrency.chapter3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**  

* <p>Title: DivTask</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月27日  

*/
public class DivTask implements Runnable {
	int a,b;
	public DivTask(int a, int b) {
		this.a = a;
		this.b = b;
	}
	/* (non-Javadoc)  
	
	 * <p>Title: run</p>  
	
	 * <p>Description: </p>  
	  
	
	 * @see java.lang.Runnable#run()  
	
	 */
	@Override
    public void run() {
		// TODO Auto-generated method stub
		double re = a/b;
		System.out.println(re);
	}

	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newFixedThreadPool(5);
//		ThreadPoolExecutor executor;
		for (int i = 0; i < 5; i++) {
//			executorService.submit(new DivTask(100, i));
			executorService.execute(new DivTask(100, i));
		}
	}

}

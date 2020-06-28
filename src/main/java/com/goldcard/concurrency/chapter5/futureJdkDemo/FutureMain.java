/**  

* <p>Title: FutureMain.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年6月3日  

* @version 1.0  

*/  
package com.goldcard.concurrency.chapter5.futureJdkDemo;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**  

* <p>Title: FutureMain</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年6月3日  

*/
public class FutureMain {

	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		//构造FutureTask
		FutureTask<String> futureTask = new FutureTask<>(new RealData("name"));
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		executorService.submit(futureTask);
		System.out.println("请求完毕");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("数据= " + futureTask.get());
	}

}

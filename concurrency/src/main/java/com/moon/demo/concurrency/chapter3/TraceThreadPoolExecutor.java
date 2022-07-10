/**  

* <p>Title: TraceThreadPoolExecutor.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月27日  

* @version 1.0  

*/  
package com.moon.demo.concurrency.chapter3;

import java.util.concurrent.*;

/**  

* <p>Title: TraceThreadPoolExecutor</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月27日  

*/
public class TraceThreadPoolExecutor extends ThreadPoolExecutor{
	public TraceThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}
	
	@Override
	public void execute(Runnable task) {
		super.execute(wrap(task, clientTrace(), Thread.currentThread().getName()));
	}
	
	@Override
	public Future<?> submit(Runnable task){
		return super.submit(wrap(task, clientTrace(), Thread.currentThread().getName()));
	}
	
	private Exception clientTrace() {
		return new Exception("Client stack trace");
	}
	
	private Runnable wrap(final Runnable task, final Exception clientStack, String clientThreadName){
		return  new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					task.run();
				} catch (Exception e) {
					// TODO: handle exception
					clientStack.printStackTrace();
//					throw e;
				}
			}
		};
	}
	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadPoolExecutor pools = new TraceThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>());
		for (int i = 0; i < 5; i++) {
			pools.execute(new DivTask(100, i));
			
		}
	}

}

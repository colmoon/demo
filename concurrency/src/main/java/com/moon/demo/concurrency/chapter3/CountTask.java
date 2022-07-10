/**  

* <p>Title: CountTask.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月27日  

* @version 1.0  

*/  
package com.moon.demo.concurrency.chapter3;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**  

* <p>Title: CountTask</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月27日  

*/
public class CountTask extends RecursiveTask<Long>{
	private static final long serialVersionUID = 5232453952276485270L;
	private static final int THRESHOLD = 1000;
	private long start;
	private long end;
	
	public CountTask(long start, long end) {
		this.start = start;
		this.end = end;
	}
	
	@Override
    public Long compute() {
		long sum = 0;
		boolean canCompute = (end -start) < THRESHOLD;
		if(canCompute) {
			for(long i = start; i <= end; i++) {
				sum += i;
			}
		} else {
			//分成100个小任务
			long step = (start + end)/100;
			ArrayList<CountTask> subTasks = new ArrayList<CountTask>();
			long pos = start;
			for(int i = 0; i < 100; i++) {
				long lastOne = pos + step;
				if (lastOne > end ) {
					lastOne = end;
				}
				CountTask subTask = new CountTask(pos, lastOne);
				pos += step + 1;
				subTasks.add(subTask);
				subTask.fork();
			}
			for (CountTask countTask : subTasks) {
				sum += countTask.join();
			}
		}
		return sum;
	}
	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		CountTask task = new CountTask(0, 20000L);
		ForkJoinTask<Long> result = forkJoinPool.submit(task);
		try {
			long res = result.get();
			System.err.println("sum = " + res);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}

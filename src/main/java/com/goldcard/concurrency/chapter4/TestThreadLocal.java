/**  

* <p>Title: TestThreadLocal.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月28日  

* @version 1.0  

*/  
package com.goldcard.concurrency.chapter4;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**  

* <p>Title: TestThreadLocal</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月28日  

*/
public class TestThreadLocal {
	static ThreadLocal<SimpleDateFormat> t1 = new ThreadLocal<SimpleDateFormat>();
	static ThreadLocal<SimpleDateFormat> t2 = new ThreadLocal<SimpleDateFormat>();
	
	public static class ParseDate implements Runnable{
		int i = 0;
		public ParseDate(int i) {
			this.i = i;
		}
		@Override
        public void run() {
			try {
				if(t1.get() == null) {
					t1.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
				}
				if(t2.get() == null) {
					t2.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
				}
				Date date = t1.get().parse("2015-03-29 19:29:" +i % 60);
				Date date2 = t2.get().parse("2018-05-13 19:29:" +i % 60);
				System.out.println(i + ":" + date);
				System.out.println(i + ":" + date2);
			} catch (ParseException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 10; i++) {
			executorService.execute(new ParseDate(i));
		}

		t1.remove();
		t2.remove();
	}

}

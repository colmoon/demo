/**  

* <p>Title: ThreadStopExample.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年8月28日  

* @version 1.0  

*/  
package com.goldcard.others;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**  

* <p>Title: ThreadStopExample</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年8月28日  

*/
public class ThreadStopExample {
	private static boolean stop = false;
	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Thread thread = new Thread(new Runnable() {
			
			@Override
            public void run() {
				int i = 0;
				// TODO Auto-generated method stub
				while(!stop) {
					i++;
					try {
						TimeUnit.SECONDS.sleep(1);
						System.out.println("i = " + i);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		});
		thread.start();
		TimeUnit.SECONDS.sleep(3);
		stop = true;
		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("key1", "1");
	}

}

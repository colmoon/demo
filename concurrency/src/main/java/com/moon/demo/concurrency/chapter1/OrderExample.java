/**  

* <p>Title: OrderExample.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年7月11日  

* @version 1.0  

*/  
package com.moon.demo.concurrency.chapter1;

/**

* <p>Title: OrderExample</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年7月11日  

*/
public class OrderExample {
	int a = 0;
	boolean flag = false;
	public void writer() {
		a = 1;
		flag = true;
	}
	public void reader() {
		if(flag) {
			int i = a + 1;
			System.out.println("i = " + i);
		}
	}
	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final OrderExample orderExample = new OrderExample();
		Thread threadA = new Thread() {
			
			@Override
            public void run() {
				// TODO Auto-generated method stub
				orderExample.writer();
			}
		};
		threadA.start();
		Thread threadB = new Thread(new Runnable() {
			
			@Override
            public void run() {
				// TODO Auto-generated method stub
				orderExample.reader();
			}
		});
		threadB.start();
	}

}

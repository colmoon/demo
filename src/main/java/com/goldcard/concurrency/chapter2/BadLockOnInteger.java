/**  

* <p>Title: BadLockOnInteger.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月23日  

* @version 1.0  

*/  
package com.goldcard.concurrency.chapter2;

/**  

* <p>Title: BadLockOnInteger</p>  

* <p>Description: Integer i; i++;每次i在没完成复制就会返回一个新的对象，这样锁就无效了 </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月23日  

*/
public class BadLockOnInteger implements Runnable{
	public static Integer i = 0;
	static BadLockOnInteger instance = new BadLockOnInteger();
	@Override
    public void run() {
		for (int j = 0; j < 10000000; j++) {
//			synchronized (instance ) {
			synchronized ( i ) {
				i++;
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
		Thread t1 = new Thread(instance);
		Thread t2 = new Thread(instance);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(i);
		
	}

}

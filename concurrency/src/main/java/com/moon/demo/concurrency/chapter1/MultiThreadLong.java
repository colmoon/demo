/**  

* <p>Title: MultiThreadLong.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月20日  

* @version 1.0  

*/  
package com.moon.demo.concurrency.chapter1;

/**  

* <p>Title: MultiThreadLong</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月20日  

*/
public class MultiThreadLong {
	public static long t = 0;
	public static class ChangeT implements Runnable{
		private long to;
		private ChangeT(long to){
			this.to = to;
		}
		@Override
        public void run() {
			while(true) {
				MultiThreadLong.t = to;
				Thread.yield();
			}
		}
	}
	public static class ReadT implements Runnable{
		@Override
        public void run() {
			while(true) {
				long tmp = MultiThreadLong.t;
				if(tmp != 111L && tmp != -999L && tmp != 333L && tmp != -444L ) {
					System.out.println(tmp);
				}
				Thread.yield();
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
		new Thread(new ChangeT(111L)).start();
		new Thread(new ChangeT(-999L)).start();
		new Thread(new ChangeT(333L)).start();
		new Thread(new ChangeT(-444L)).start();
		new Thread(new ReadT()).start();
	}

}

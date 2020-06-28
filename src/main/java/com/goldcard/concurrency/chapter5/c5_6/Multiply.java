/**  

* <p>Title: Multiply.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年6月3日  

* @version 1.0  

*/  
package com.goldcard.concurrency.chapter5.c5_6;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**  

* <p>Title: Multiply</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年6月3日  

*/
public class Multiply implements Runnable {
	public static BlockingQueue<Msg> bMsgs = new LinkedBlockingQueue<Msg>();
	/* (non-Javadoc)  
	
	 * <p>Title: run</p>  
	
	 * <p>Description: </p>  
	  
	
	 * @see java.lang.Runnable#run()  
	
	 */
	@Override
    public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Msg msg = bMsgs.take();
				msg.i = msg.i * msg.j;
				Div.bMsgs.add(msg);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}

}

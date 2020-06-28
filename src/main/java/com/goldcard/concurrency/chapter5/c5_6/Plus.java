/**  

* <p>Title: Plus.java</p>  

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

* <p>Title: Plus</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年6月3日  

*/
public class Plus implements Runnable{
	public static BlockingQueue<Msg> bMsgs = new LinkedBlockingQueue<Msg>();
	@Override
    public void run() {
		while(true) {
			try {
				Msg msg = bMsgs.take();
				msg.j = msg.i + msg.i;
				Multiply.bMsgs.add(msg);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}

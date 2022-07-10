/**  

* <p>Title: PStreamMain.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年6月3日  

* @version 1.0  

*/  
package com.moon.demo.concurrency.chapter5.c5_6;

/**  

* <p>Title: PStreamMain</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年6月3日  

*/
public class PStreamMain {

	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread plusThread = new Thread(new Plus());
		plusThread.start();
		Thread multiplyThread = new Thread(new Multiply());
		multiplyThread.start();
		Thread divThread = new Thread(new Div());
		divThread.start();
		for (int i = 1; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Msg msg = new Msg();
				msg.i = i;
				msg.j = j;
				msg.orgStr = "((" + i + "+" +j +")*" + i + ")/2";
				Plus.bMsgs.add(msg);
			}
		}
	}

}

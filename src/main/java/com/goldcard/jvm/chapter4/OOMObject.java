/**  

* <p>Title: OOMObject.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年8月11日  

* @version 1.0  

*/  
package com.goldcard.jvm.chapter4;

import java.util.ArrayList;
import java.util.List;


/**  

* <p>Title: OOMObject</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年8月11日  

*/
public class OOMObject {
	
	static class TestObject {
		public byte[] placeholder = new byte[64 * 1024];
	}
	
	public static void fillheap(int num) throws InterruptedException{
		List<TestObject> list = new ArrayList<TestObject>();
		for (int i = 0; i < num; i++) {
			Thread.sleep(500);
			list.add(new TestObject());
		}
	}
	
	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		fillheap(1000);
		System.gc();
	}

}

/**  

* <p>Title: TestInteger.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年7月29日  

* @version 1.0  

*/  
package com.goldcard.others;

import java.util.concurrent.atomic.AtomicInteger;

/**  

* <p>Title: TestInteger</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年7月29日  

*/
public class TestInteger {

	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer integer = new Integer(10);
		AtomicInteger atomicInteger = new AtomicInteger(10);
		System.out.println(integer + " " + atomicInteger);

	}

}

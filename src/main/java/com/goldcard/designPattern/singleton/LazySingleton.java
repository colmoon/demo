/**  

* <p>Title: LazySingleton.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年7月4日  

* @version 1.0  

*/  
package com.goldcard.designPattern.singleton;

/**  

* <p>Title: LazySingleton</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年7月4日  

*/
public class LazySingleton {
	private LazySingleton() {
		
	}
	private static LazySingleton instance = null;
	public static synchronized LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
	

}

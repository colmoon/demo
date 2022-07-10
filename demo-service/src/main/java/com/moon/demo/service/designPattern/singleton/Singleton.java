/**  

* <p>Title: Singleton.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年7月4日  

* @version 1.0  

*/  
package com.moon.demo.service.designPattern.singleton;

/**  

* <p>Title: Singleton</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年7月4日  

*/
public class Singleton {
	private Singleton() {
		
	}
	private static Singleton instance = new Singleton();
	public static Singleton getInstance() {
		return instance;
	}
}

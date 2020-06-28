/**  

* <p>Title: Projector.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年7月9日  

* @version 1.0  

*/  
package com.goldcard.designPattern.facade;

/**  

* <p>Title: Projector</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年7月9日  

*/
public class Projector {
	public void on() {
		System.out.println("打开投影仪");
	}
	public void off() {
		System.out.println("关闭投影仪");
	}
	public void open() {
		System.out.println("放下投影仪投影区");
	}
	public void close() {
		System.out.println("收起投影仪投影区");
	}
}

/**  

* <p>Title: PopcornPopper.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年7月9日  

* @version 1.0  

*/  
package com.moon.demo.service.designPattern.facade;

/**  

* <p>Title: PopcornPopper</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年7月9日  

*/
public class PopcornPopper {
	public void on() {
		System.out.println("打开爆米花机");
	}
	public void makePopcorn() {
		System.out.println("制作爆米花");
	}
	public void stopMakePopcorn() {
		System.out.println("停止制作爆米花");
	}
	public void off() {
		System.out.println("关闭爆米花机");
	}
}

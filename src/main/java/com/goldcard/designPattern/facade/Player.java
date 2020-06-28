/**  

* <p>Title: Player.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年7月9日  

* @version 1.0  

*/  
package com.goldcard.designPattern.facade;

/**  

* <p>Title: Player</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年7月9日  

*/
public class Player {
	public void on() {
		System.out.println("打开播放器");
	}
	public void off() {
		System.out.println("关闭播放器");
	}
	public void make3DListener() {
		System.out.println("将播放器音调设为环绕立体声");
	}
}

/**  

* <p>Title: DarkRoast.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月5日  

* @version 1.0  

*/  
package com.goldcard.headfirstdesign.decorate;

/**  

* <p>Title: DarkRoast</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月5日  

*/
public class DarkRoast extends Beverage{
	public DarkRoast() {
		description = "DarkRoast(深焙)";
	}
	
	@Override
    public double cost() {
		return .99;
	}
}

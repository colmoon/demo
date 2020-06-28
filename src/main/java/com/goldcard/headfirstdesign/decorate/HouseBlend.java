/**  

* <p>Title: HouseBlend.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月5日  

* @version 1.0  

*/  
package com.goldcard.headfirstdesign.decorate;

/**  

* <p>Title: HouseBlend</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月5日  

*/
public class HouseBlend extends Beverage {
	public HouseBlend() {
		description = "House Blend Coffee";
	}
	
	@Override
    public double cost() {
		return .89;
	}
}

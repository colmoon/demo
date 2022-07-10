/**  

* <p>Title: Espresso.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月5日  

* @version 1.0  

*/  
package com.moon.demo.design.headfirst.decorate;

/**  

* <p>Title: Espresso</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月5日  

*/
public class Espresso extends Beverage{
	public Espresso() {
		description = "Espresso(浓缩咖啡)";
	}
	
	@Override
    public double cost() {
		return 1.99;
	}
}

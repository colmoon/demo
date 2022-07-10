/**  

* <p>Title: Whip.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月5日  

* @version 1.0  

*/  
package com.moon.demo.design.headfirst.decorate;

/**  

* <p>Title: Whip</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月5日  

*/
public class Whip extends CondimentDecorator{
	private Beverage beverage;
	
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
    public String getDescription() {
		return beverage.getDescription() + ", Whip(奶泡)";
	}
	
	@Override
    public double cost() {
		return beverage.cost() + .10;
	}
}

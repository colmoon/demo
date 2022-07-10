/**  

* <p>Title: Soy.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月5日  

* @version 1.0  

*/  
package com.moon.demo.design.headfirst.decorate;

/**  

* <p>Title: Soy</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月5日  

*/
public class Soy extends CondimentDecorator{
	private Beverage beverage;
	
	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
    public String getDescription() {
		return beverage.getDescription() + ", Soy(豆浆)";
	}
	
	@Override
    public double cost() {
		return beverage.cost() + .15;
	}

}

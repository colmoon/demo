/**  

* <p>Title: PizzaStore.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月10日  

* @version 1.0  

*/  
package com.goldcard.headfirstdesign.factory.example1;

/**  

* <p>Title: PizzaStore</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月10日  

*/
public abstract class PizzaStore {
	public Pizza orderPizza(String type) {
		Pizza pizza;
		pizza = createPizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}
	protected abstract Pizza createPizza(String type);
}

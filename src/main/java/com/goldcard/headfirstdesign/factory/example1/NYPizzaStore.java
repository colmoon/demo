/**  

* <p>Title: NYPizzaStore.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月10日  

* @version 1.0  

*/  
package com.goldcard.headfirstdesign.factory.example1;

/**  

* <p>Title: NYPizzaStore</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月10日  

*/
public class NYPizzaStore extends PizzaStore{
	@Override
    protected Pizza createPizza(String type) {
		if (type.equals("cheese")) {
			return new NYStyleCheesePizza();
		} else {
			return null;
		}
	}
}

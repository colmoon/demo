/**  

* <p>Title: ChicagoStylePizzaStore.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月10日  

* @version 1.0  

*/  
package com.moon.demo.design.headfirst.factory.example1;

/**  

* <p>Title: ChicagoStylePizzaStore</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月10日  

*/
public class ChicagoStylePizzaStore extends PizzaStore{
	@Override
    protected Pizza createPizza(String type) {
		if (type.equals("cheese")) {
			return new ChicagoStyleCheesePizza();
		} else {
			return null;
		}
	}
}

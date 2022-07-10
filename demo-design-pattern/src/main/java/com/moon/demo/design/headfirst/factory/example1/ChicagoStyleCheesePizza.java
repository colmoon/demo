/**  

* <p>Title: ChicagoStyleCheesePizza.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月10日  

* @version 1.0  

*/  
package com.moon.demo.design.headfirst.factory.example1;

/**  

* <p>Title: ChicagoStyleCheesePizza</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月10日  

*/
public class ChicagoStyleCheesePizza extends Pizza{
	public ChicagoStyleCheesePizza() {
		name = "Chicago style deep dish cheese pizza";
		dough = "extra thick crust dough";
		sauce = "plum tomato sauce";
		
		toppings.add("grated regggiano cheese");
	}
}

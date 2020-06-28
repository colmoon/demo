/**  

* <p>Title: NYStyleCheesePizza.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月10日  

* @version 1.0  

*/  
package com.goldcard.headfirstdesign.factory.example1;

/**  

* <p>Title: NYStyleCheesePizza</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月10日  

*/
public class NYStyleCheesePizza extends Pizza{
	public NYStyleCheesePizza() {
		name = "NY style sauce and cheese Pizza";
		dough = "Thin crust dough";
		sauce = "Marinara Sauce";
		
		toppings.add("grated reggiano cheese");
	}
}

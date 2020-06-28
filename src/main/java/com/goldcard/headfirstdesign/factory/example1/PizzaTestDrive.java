/**  

* <p>Title: PizzaTestDrive.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月10日  

* @version 1.0  

*/  
package com.goldcard.headfirstdesign.factory.example1;

/**  

* <p>Title: PizzaTestDrive</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月10日  

*/
public class PizzaTestDrive {

	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PizzaStore nyStore = new NYPizzaStore();
		PizzaStore chicagoStore = new ChicagoStylePizzaStore();
		
		Pizza pizza = nyStore.orderPizza("cheese");
		System.out.println("Ethan ordered a " + pizza.getName() + "\n");
		
		pizza = chicagoStore.orderPizza("cheese");
		System.out.println("Joel ordered a " + pizza.getName());
	}

}

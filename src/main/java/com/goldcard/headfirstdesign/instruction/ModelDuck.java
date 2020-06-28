/**  

* <p>Title: ModelDuck.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月2日  

* @version 1.0  

*/  
package com.goldcard.headfirstdesign.instruction;

/**  

* <p>Title: ModelDuck</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月2日  

*/
public class ModelDuck extends Duck{
	public ModelDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyNoWay();
	}
	
	@Override
    public void display() {
		System.out.println("I'm a model duck");
	}
}
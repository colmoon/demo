/**  

* <p>Title: FlyRocketPowered.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月2日  

* @version 1.0  

*/  
package com.goldcard.headfirstdesign.instruction;

/**  

* <p>Title: FlyRocketPowered</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月2日  

*/
public class FlyRocketPowered implements FlyBehavior {

	@Override
    public void fly() {
		System.out.println("I'm flying with a rocket!");
	}

}

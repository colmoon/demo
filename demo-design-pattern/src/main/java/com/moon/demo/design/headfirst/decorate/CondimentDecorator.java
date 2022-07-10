/**  

* <p>Title: CondimentDecorator.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月5日  

* @version 1.0  

*/  
package com.moon.demo.design.headfirst.decorate;

/**  

* <p>Title: CondimentDecorator</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月5日  

*/
public abstract class CondimentDecorator extends Beverage{
	@Override
    public abstract String getDescription();
}

/**  

* <p>Title: Observer.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月3日  

* @version 1.0  

*/  
package com.moon.demo.design.headfirst.observer.example1;

/**  

* <p>Title: Observer</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月3日  

*/
public interface Observer {
	public void update(WeatherParameter weatherParameter);
}

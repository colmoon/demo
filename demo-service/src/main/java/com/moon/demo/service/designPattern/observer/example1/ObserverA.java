/**  

* <p>Title: ObserverA.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年7月2日  

* @version 1.0  

*/  
package com.moon.demo.service.designPattern.observer.example1;

/**  

* <p>Title: ObserverA</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年7月2日  

*/
public class ObserverA implements Observer {

	public ObserverA(Subject subject) {
		subject.registerObserver(this);
	}

	@Override
    public void update(String msg) {
		System.out.println("observerA receive msg " + msg);
	}

}

/**  

* <p>Title: ObjectFor3D.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年7月2日  

* @version 1.0  

*/  
package com.moon.demo.service.designPattern.observer.example1;

import java.util.LinkedList;
import java.util.List;

/**  

* <p>Title: ObjectFor3D</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年7月2日  

*/
public class ObjectFor3D implements Subject {
	private List<Observer> observers = new LinkedList<Observer>();
	
	private String msg;

	@Override
    public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
    public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
    public void notifyObserver() {
		for (Observer observer : observers) {
			observer.update(msg);
		}
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
		notifyObserver();
	}

}

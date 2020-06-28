/**  

* <p>Title: SubjectForSSQ.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年7月2日  

* @version 1.0  

*/  
package com.goldcard.designPattern.observer.example2;

import java.util.Observable;

/**  

* <p>Title: SubjectForSSQ</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年7月2日  

*/
public class SubjectForSSQ extends Observable{
	private String msg;
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
		setChanged();
		notifyObservers();
	}
}

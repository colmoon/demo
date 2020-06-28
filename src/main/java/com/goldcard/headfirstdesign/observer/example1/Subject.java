/**  

* <p>Title: Subject.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月3日  

* @version 1.0  

*/  
package com.goldcard.headfirstdesign.observer.example1;

/**  

* <p>Title: Subject</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月3日  

*/
public interface Subject {
	public void registerObserver(Observer observer);
	public void removeObserver(Observer observer);
	public void notifyObservers();
}

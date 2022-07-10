/**  

* <p>Title: WeatherData.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月3日  

* @version 1.0  

*/  
package com.moon.demo.design.headfirst.observer.example1;

import java.util.ArrayList;


/**  

* <p>Title: WeatherData</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月3日  

*/
public class WeatherData implements Subject {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private WeatherParameter weatherParameter;
	/* (non-Javadoc)  
	
	 * <p>Title: registerObserver</p>  
	
	 * <p>Description: </p>  
	
	 * @param observer  
	
	 * @see com.goldcard.designPattern.observer.example1.Subject#registerObserver(com.goldcard.designPattern.observer.example1.Observer)  
	
	 */
	@Override
    public void registerObserver(Observer observer) {
		// TODO Auto-generated method stub
		observers.add(observer);
	}

	/* (non-Javadoc)  
	
	 * <p>Title: removeObserver</p>  
	
	 * <p>Description: </p>  
	
	 * @param observer  
	
	 * @see com.goldcard.designPattern.observer.example1.Subject#removeObserver(com.goldcard.designPattern.observer.example1.Observer)  
	
	 */
	@Override
    public void removeObserver(Observer observer) {
		// TODO Auto-generated method stub
		int index = observers.indexOf(observer);
		if (index > 0) {
			observers.remove(index);
		}
	}

	/* (non-Javadoc)  
	
	 * <p>Title: notifyObserver</p>  
	
	 * <p>Description: </p>  
	  
	
	 * @see com.goldcard.designPattern.observer.example1.Subject#notifyObserver()  
	
	 */
	@Override
    public void notifyObservers() {
		// TODO Auto-generated method stub
		for (Observer observer : observers) {
			observer.update(weatherParameter);
		}
	}
	
	public void measurementsChanged() {
		notifyObservers();
	}
	
	public void setMeasurements(WeatherParameter weatherParameter) {
		this.weatherParameter = weatherParameter;
		measurementsChanged();
	}

}

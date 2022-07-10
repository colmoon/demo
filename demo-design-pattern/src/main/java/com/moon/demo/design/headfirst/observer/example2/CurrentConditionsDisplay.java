/**  

* <p>Title: CurrentConditionsDisplay.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月3日  

* @version 1.0  

*/  
package com.moon.demo.design.headfirst.observer.example2;

import com.moon.demo.design.headfirst.observer.example1.DisplayElement;
import com.moon.demo.design.headfirst.observer.example1.WeatherParameter;

import java.util.Observable;
import java.util.Observer;

/**  

* <p>Title: CurrentConditionsDisplay</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月3日  

*/
public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private Observable observable;
	private WeatherParameter weatherParameter;
	public CurrentConditionsDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}
	@Override
    public void display() {
		System.out.println("Current condition: " + weatherParameter.getTemperature() + "F degree and " + weatherParameter.getHumidity() + 
				"% humidity");
	}
	@Override
    public void update(Observable observable, Object object) {
		if (observable instanceof WeatherData) {
			WeatherData weatherData = (WeatherData)observable;
			this.weatherParameter = weatherData.getWeatherParameter();
			display();
		}
	}
}

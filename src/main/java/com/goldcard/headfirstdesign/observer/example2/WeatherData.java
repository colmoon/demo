/**  

* <p>Title: WeatherData.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月3日  

* @version 1.0  

*/
package com.goldcard.headfirstdesign.observer.example2;

import java.util.Observable;

import com.goldcard.headfirstdesign.observer.example1.WeatherParameter;
import com.sun.org.apache.regexp.internal.recompile;

/**
 * 
 * <p>
 * Title: WeatherData
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * @author wu.xiao.jian 2119
 * 
 * @date 2018年9月3日
 * 
 */
public class WeatherData extends Observable {
	private WeatherParameter weatherParameter;

	public void measurementsChanged() {
		setChanged();
		notifyObservers();
//		notifyObservers(weatherParameter);
	}

	public void setMeasurements(WeatherParameter weatherParameter) {
		this.weatherParameter = weatherParameter;
		measurementsChanged();
	}

	public float getTemperature() {
		return weatherParameter.getTemperature();
	}

	public float getHumidity() {
		return weatherParameter.getHumidity();
	}

	public float getPressure() {
		return weatherParameter.getPressure();
	}
	
	public WeatherParameter getWeatherParameter() {
		return weatherParameter;
	}
}

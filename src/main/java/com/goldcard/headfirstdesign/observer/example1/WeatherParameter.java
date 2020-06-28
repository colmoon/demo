/**  

* <p>Title: WeatherParameter.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月3日  

* @version 1.0  

*/  
package com.goldcard.headfirstdesign.observer.example1;

/**  

* <p>Title: WeatherParameter</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月3日  

*/
public class WeatherParameter {
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherParameter(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
	}
	/**
	 * @return the temperature
	 */
	public float getTemperature() {
		return temperature;
	}
	/**
	 * @param temperature the temperature to set
	 */
	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}
	/**
	 * @return the humidity
	 */
	public float getHumidity() {
		return humidity;
	}
	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}
	/**
	 * @return the pressure
	 */
	public float getPressure() {
		return pressure;
	}
	/**
	 * @param pressure the pressure to set
	 */
	public void setPressure(float pressure) {
		this.pressure = pressure;
	}
	
}

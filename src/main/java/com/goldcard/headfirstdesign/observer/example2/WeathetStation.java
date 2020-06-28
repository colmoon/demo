/**  

* <p>Title: WeathetStation.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月3日  

* @version 1.0  

*/  
package com.goldcard.headfirstdesign.observer.example2;

import com.goldcard.headfirstdesign.observer.example1.WeatherParameter;

/**  

* <p>Title: WeathetStation</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月3日  

*/
public class WeathetStation {

	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WeatherData weatherData = new WeatherData();
		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
		WeatherParameter weatherParameter = new WeatherParameter(80, 65, 30.4f);
		weatherData.setMeasurements(weatherParameter);
	}

}

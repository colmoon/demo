/**  

* <p>Title: CurrentConditionDisplay.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月3日  

* @version 1.0  

*/  
package com.moon.demo.design.headfirst.observer.example1;

/**  

* <p>Title: CurrentConditionDisplay</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月3日  

*/
public class CurrentConditionDisplay implements Observer, DisplayElement {
	private WeatherParameter weatherParameter;

	private Subject weatherData;
	
	public CurrentConditionDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	/* (non-Javadoc)  
	
	 * <p>Title: display</p>  
	
	 * <p>Description: </p>  
	  
	
	 * @see com.goldcard.headfirstdesign.observer.example1.DisplayElement#display()  
	
	 */
	@Override
    public void display() {
		// TODO Auto-generated method stub
		System.out.println("Current condition: " + weatherParameter.getTemperature() + "F degree and " + weatherParameter.getHumidity() + 
				"% humidity");
	}

	/* (non-Javadoc)  
	
	 * <p>Title: update</p>  
	
	 * <p>Description: </p>  
	
	 * @param weatherParameter  
	
	 * @see com.goldcard.headfirstdesign.observer.example1.Observer#update(com.goldcard.headfirstdesign.observer.example1.WeatherParameter)  
	
	 */
	@Override
    public void update(WeatherParameter weatherParameter) {
		// TODO Auto-generated method stub
		this.weatherParameter = weatherParameter;
		display();
	}

}

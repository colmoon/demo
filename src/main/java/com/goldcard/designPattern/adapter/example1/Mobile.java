/**  

* <p>Title: Mobile.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年6月12日  

* @version 1.0  

*/  
package com.goldcard.designPattern.adapter.example1;

/**  

* <p>Title: Mobile</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年6月12日  

*/
public class Mobile {
	/**  
	
	 * <p>Title: inputPower</p>  
	
	 * <p>Description: </p>  
	
	 * @param power  
	
	 */  
	private void inputPower(V5Power power) {
		int provideV5Power = power.provideV5Power();
		System.out.println("手机（客户端）：我需要5V电压充电，现在是-->" + provideV5Power + "V");
	}
	
	public static void main(String[] args) {
		Mobile mobile = new Mobile();
		V5Power v5Power = new V5PowerAdapter(new V220Power());
		mobile.inputPower(v5Power);
	}
}

/**  

* <p>Title: Test.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年7月2日  

* @version 1.0  

*/  
package com.moon.demo.service.designPattern.observer.example1;

/**  

* <p>Title: Test</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年7月2日  

*/
public class Test {

	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) {
		 ObjectFor3D objectFor3D = new ObjectFor3D();
		 ObserverA observerA = new ObserverA(objectFor3D);
		 ObserverB observerB = new ObserverB(objectFor3D);
		 
		 objectFor3D.setMsg("test1");
		 objectFor3D.setMsg("test2");
		 
	}

}

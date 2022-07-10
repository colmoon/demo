/**  

* <p>Title: ConcurrentSkipListMapDemo.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月30日  

* @version 1.0  

*/  
package com.moon.demo.concurrency.chapter3;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;
/**  

* <p>Title: ConcurrentSkipListMapDemo</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月30日  

*/
public class ConcurrentSkipListMapDemo {

	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,Integer> map = new ConcurrentSkipListMap<Integer,Integer>();
		for (int i = 0; i < 30; i++) {
			map.put(i, i);
		}
		for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}

}

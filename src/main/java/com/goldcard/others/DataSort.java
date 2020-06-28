/**  

* <p>Title: DataSort.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年6月28日  

* @version 1.0  

*/  
package com.goldcard.others;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**  

* <p>Title: DataSort</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年6月28日  

*/
public class DataSort {

	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String frozenTime = new String("20180629000000,20180627000000,20180628000000");
		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
		String[] frozens = frozenTime.split(",");
		List<Date> listDate = new ArrayList<Date>();
		try {
			for (String frozen : frozens) {
				Date date = sdf.parse(frozen);
				System.out.println(date);
				listDate.add(date);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Collections.sort(listDate);
		System.out.println(listDate);
		
		String frozenTime1 = new String("0000000000");
		SimpleDateFormat sdf1 =new SimpleDateFormat("yyMMddHHmm");
		try {
			Date date1 = sdf1.parse(frozenTime1);
			System.out.println(date1);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

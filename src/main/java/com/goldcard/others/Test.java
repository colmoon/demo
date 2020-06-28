/**  

* <p>Title: Test.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年8月8日  

* @version 1.0  

*/  
package com.goldcard.others;

import java.math.BigDecimal;

/**  

* <p>Title: Test</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年8月8日  

*/
public class Test {

	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		String s1 = "Hollis";
		String s2 = new String("Hollis");
		String s3 = new String("Hollis").intern();

		System.out.println(s1 == s2);
		System.out.println(s1 == s3);

		String s4 = new String("Hollis");
		String s5 = new String("Hollis");
		System.out.println(s4 == s5);
		    
		System.out.println(System.getProperty("java.library.path")); 
		String metersign = new String(new byte[16]);
		String meterno = new String(new byte[16]);
		byte[] number = new byte[] {100,100};
		System.out.println(metersign);
		System.out.println(new String(number));
		System.out.println(meterno == metersign);
		Outer.Builder builder = new Outer.Builder(12);
		Outer.Builder builder2 = new Outer.Builder(13);
		System.out.println(builder.getAge());
		System.out.println(builder2.getAge());
		short number1 = 10;
		System.out.println(Integer.toString(number1));
		String price = "2";
		int price2 = new BigDecimal(price).multiply(new BigDecimal(1000)).intValue();
		System.out.println(String.valueOf(price2));
		System.out.println(new BigDecimal(price).toString());
	}

}

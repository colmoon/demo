/**  

* <p>Title: RuntimeConstantPoolOOM.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年8月7日  

* @version 1.0  

*/  
package com.moon.demo.service.jvm.chapter2;

/**  

* <p>Title: RuntimeConstantPoolOOM</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年8月7日  

*/
public class RuntimeConstantPoolOOM {
	public static void main(String[] args) {
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);
		
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
	}
}

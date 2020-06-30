/**  

* <p>Title: InputTest.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月5日  

* @version 1.0  

*/  
package com.goldcard.headfirstdesign.decorate.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


/**  

* <p>Title: InputTest</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月5日  

*/
public class InputTest {

	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		int c;
		try {
			InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
			while((c = in.read()) >= 0) {
				System.out.print((char)c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

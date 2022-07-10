/**  

* <p>Title: LowerCaseInputStream.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月5日  

* @version 1.0  

*/  
package com.moon.demo.design.headfirst.decorate.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**  

* <p>Title: LowerCaseInputStream</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月5日  

*/
public class LowerCaseInputStream extends FilterInputStream{
	public LowerCaseInputStream(InputStream in) {
		super(in);
	}
	
	@Override
    public int read() throws IOException{
		int c = super.read();
		return (c == -1 ? c : Character.toLowerCase((char)c));
	}
	
	@Override
    public int read(byte[] b, int offset, int len) throws IOException{
		int result = super.read(b, offset, len);
		for (int i = offset; i < offset + result; i++) {
			b[i] = (byte)Character.toLowerCase((char)b[i]);
		}
		return result;
	}
}

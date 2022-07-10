/**  

* <p>Title: RealData.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年6月3日  

* @version 1.0  

*/  
package com.moon.demo.concurrency.chapter5.futureJdkDemo;

import java.util.concurrent.Callable;

/**  

* <p>Title: RealData</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年6月3日  

*/
public class RealData implements Callable<String> {
	private String para;
	public RealData(String para) {
		this.para = para;
	}
	@Override
    public String call() throws Exception{
		StringBuffer stringBuffer = new StringBuffer();
		for(int i = 0; i < 10; i++) {
			stringBuffer.append(para);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		return stringBuffer.toString();
	}
}

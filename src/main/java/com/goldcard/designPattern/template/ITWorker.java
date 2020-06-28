/**  

* <p>Title: ITWorker.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年7月4日  

* @version 1.0  

*/  
package com.goldcard.designPattern.template;

/**  

* <p>Title: ITWorker</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年7月4日  

*/
public class ITWorker extends Worker{
	public ITWorker(String name) {
		super(name);
	}
	
	@Override
    public void work() {
		System.out.println(name + "写程序-测bug-fix bug");
	}
	
	@Override
    public boolean isNeedPrintDate()
	{
		return true;
	}

}

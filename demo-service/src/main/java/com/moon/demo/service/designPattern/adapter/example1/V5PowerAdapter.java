/**  

* <p>Title: V5PowerAdapter.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年6月12日  

* @version 1.0  

*/  
package com.moon.demo.service.designPattern.adapter.example1;

/**  

* <p>Title: V5PowerAdapter</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年6月12日  

*/
public class V5PowerAdapter implements V5Power {
	private V220Power v220Power;
	
	public V5PowerAdapter(V220Power v220Power) {
		this.v220Power = v220Power;
	}
	/* (non-Javadoc)  
	
	 * <p>Title: provideV5Power</p>  
	
	 * <p>Description: </p>  
	
	 * @return  
	
	 * @see com.goldcard.designPattern.adapter.example1.V5Power#provideV5Power()  
	
	 */
	@Override
    public int provideV5Power() {
		int power = v220Power.provideV220Power();
		System.out.println("经过处理" + power + "v转换成了 5v");
		return 5;
	}

}

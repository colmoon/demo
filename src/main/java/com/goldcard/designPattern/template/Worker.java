/**  

* <p>Title: Worker.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年7月4日  

* @version 1.0  

*/
package com.goldcard.designPattern.template;

import java.util.Date;

/**
 * 
 * <p>
 * Title: Worker
 * </p>
 * 
 * <p>
 * Description:
 * </p>
 * 
 * @author wu.xiao.jian 2119
 * 
 * @date 2018年7月4日
 * 
 */
public abstract class Worker {
	protected String name;

	public Worker(String name) {
		this.name = name;
	}

	/**
	 * 记录一天的工作
	 */
	public final void workOneDay() {

		System.out.println("-----------------work start ---------------");
		enterCompany();
		computerOn();
		work();
		computerOff();
		exitCompany();
		System.out.println("-----------------work end ---------------");

	}

	/**
	 * 工作
	 */
	public abstract void work();

	/**
	 * 关闭电脑
	 */
	private void computerOff() {
		System.out.println(name + "关闭电脑");
	}

	/**
	 * 打开电脑
	 */
	private void computerOn() {
		System.out.println(name + "打开电脑");
	}

	/**
	 * 进入公司
	 */
	public void enterCompany() {
		System.out.println(name + "进入公司");
	}

	
	public boolean isNeedPrintDate()
	{
		return false;
	}

	/**
	 * 离开公司
	 */
	public void exitCompany()
	{
		if (isNeedPrintDate())
		{
			System.out.print(new Date().toString() + "-->");
		}
		System.out.println(name + "离开公司");
	}


}

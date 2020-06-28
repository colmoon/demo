/**  

* <p>Title: BeverageEnum.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月5日  

* @version 1.0  

*/  
package com.goldcard.headfirstdesign.decorate;

import lombok.Data;

/**

* <p>Title: BeverageEnum</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月5日  

*/

public enum BeverageEnum {
	TAIL("1","小杯"),
	GRANDE("2","中杯"),
	VENTI("3","大杯");
	
	private String id;
	private String size;
	
	BeverageEnum(String id, String size) {
		this.id = id;
		this.size = size;
	}
	
	public static BeverageEnum getBeverageEnum(String id){
		for(BeverageEnum beverageEnum : BeverageEnum.values()){
			if(beverageEnum.getId().equals(id)){
				return beverageEnum;
			}
		}
		return null;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}


}

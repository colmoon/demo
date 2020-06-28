/**  

* <p>Title: UserManager.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年6月20日  

* @version 1.0  

*/  
package com.goldcard.designPattern.proxy;

/**  

* <p>Title: UserManager</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年6月20日  

*/
public interface UserManager {

	/**
	 * @param userId id
	 * @param userName name
	 * @return void
	 **/
	void addUser(String userId, String userName);

	/**
	 * @param userId id
	 * @return void
	 **/
	void delUser(String userId);

	/**
	 * @param userId id
	 * @return java.lang.String
	 **/
	String findUser(String userId);

	/**
	 * @param userId   id
	 * @param userName 用户名
	 * @return void
	 **/
	void modifyUser(String userId, String userName);
}

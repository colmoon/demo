package com.moon.demo.service.designPattern.proxy;

public class Client {

	public static void main(String[] args) {
		LogHandler logHandler = new LogHandler();
		UserManager userManager = (UserManager) logHandler.newProxyInstance(new UserManagerImpl());
		// UserManager userManager=new UserManagerImpl();
		userManager.addUser("1111", "张三");
	}
}
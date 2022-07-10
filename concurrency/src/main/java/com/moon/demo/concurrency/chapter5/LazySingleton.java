package com.moon.demo.concurrency.chapter5;

public class LazySingleton {
	private LazySingleton() {
		
	}
	private static LazySingleton instance = null;
	public static synchronized LazySingleton getInstance() {
		if(instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

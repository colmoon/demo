package com.moon.demo.concurrency.chapter5;

public class StaticSingleton {
	private StaticSingleton() {
		
	}
	private static class SingletonHolder{
		private static StaticSingleton instance = new StaticSingleton();
	}
	public StaticSingleton getInstance() {
		return SingletonHolder.instance;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

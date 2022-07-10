package com.moon.demo.concurrency.chapter5;

public class Singleton {
	public static int State = 1;
	private Singleton() {
		System.out.println("instance is create!");
	}
	private static Singleton instance = new Singleton();
	public static Singleton getInstance() {
		return instance;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Singleton singleton = Singleton.getInstance();
		System.out.println(Singleton.State);
	}

}

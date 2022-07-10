package com.moon.demo.service.jdk8.function;

import java.util.function.Function;
 
public class TestFunction {
	public static void main(String[] args) {

		//https://www.cnblogs.com/rever/p/9725173.html
		// 定义字符串
		String str = "helloWorld";
		
		// 调用方法
		// 在调用的时候写方法体，方法比较灵活
		int length = testFun(str, String::length);
		Function<String, Integer> function = String::length;
		
		System.out.println(length);

		// 调用
		long l1 = testAbs(-10L, Math::abs);

		// 改进
		long l2 = testAbs(-10, Math::abs);

		System.out.println(l1);
		System.out.println(l2);


		Function<Integer, Integer> name = e -> e * 2;
		Function<Integer, Integer> square = e -> e * e;
		//先执行name的apply方法，e=3*2=6，再执行square的addThen方法，e=6*6=36；
		int value = name.andThen(square).apply(3);
		System.out.println("andThen value=" + value);
		int value2 = name.compose(square).apply(3);
		System.out.println("compose value2=" + value2);
		//返回一个执行了apply()方法之后只会返回输入参数的函数对象
		Object identity = Function.identity().apply("huohuo");
		System.out.println(identity);
	}
	
	// 方法
	/**
	 * 
	 * @param str 输入参数
	 * @param fun 表达式 String 为输入类型，Integer为输出类型
	 * @return 返回字符串长度
	 */
	public static int testFun(String str, Function<String, Integer> fun) {
		// 执行
		Integer length = fun.apply(str);
		
		return length;
	}

	public static long testAbs(long s, Function<Long, Long> fun) {
		Long l = fun.apply(s);
		return l;
	}

}
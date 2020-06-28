/**  

* <p>Title: MinStack.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月4日  

* @version 1.0  

*/  
package com.goldcard.algorithm;

import java.util.ArrayList;


/**  

* <p>Title: MinStack</p>  

* <p>Description: 题目：我现在需要实现一个栈，这个栈除了可以进行普通的push、pop操作以外，还可以进行getMin的操作，getMin方法被调用后，
* 					会返回当前栈的最小值，你会怎么做呢？你可以假设栈里面存的都是int整数。</p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月4日  

*/
public class MinStack {
	//保存最小值的索引栈
	private ArrayList<Integer> minStack = new ArrayList<Integer>();
	//数据栈
	private ArrayList<Integer> dataStack = new ArrayList<Integer>();
	
	public void push(Integer number) throws Exception{
		dataStack.add(number);
		if (minStack.size() == 0) {
			minStack.add(0);
		} else {
			if (number < getMin()) {
				minStack.add(dataStack.size() - 1);
			}
		}
	}
	
	public Integer pop() throws Exception{
		//栈空，抛出异常
		if (dataStack.size() == 0) {
			throw new Exception();
		}
		//pop时先获取索引
		int popIndex = dataStack.size() - 1;
		//获取minStack栈顶元素，它是最小值索引
		int minIndex = minStack.get(minStack.size() - 1);
		// 如果pop出去的索引就是最小值索引，minStack才出栈
		if (minIndex == popIndex) {
			minStack.remove(minStack.size() - 1);
		}
		return dataStack.remove(dataStack.size() - 1);
	}
	
	public Integer getMin() throws Exception{
		// 栈空，抛出异常
		if (dataStack.size() == 0) {
			throw new Exception();
		} else {
			// 获取minStack栈顶元素，它是最小值索引
			int index = minStack.get(minStack.size() - 1);
			return dataStack.get(index);
		}
	}
	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) throws Exception{
		MinStack minStack = new MinStack();
		minStack.push(2);
		System.out.println(minStack.getMin());
		minStack.push(1);
		System.out.println(minStack.getMin());
		minStack.push(3);
		System.out.println(minStack.getMin());
		minStack.pop();
		minStack.pop();
		System.out.println(minStack.getMin());
	}

}

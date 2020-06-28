/**  

* <p>Title: Evaluate.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年9月18日  

* @version 1.0  

*/  
package com.goldcard.algorithm.chapter1;

import java.util.Stack;

import com.goldcard.algorithm.util.StdIn;
import com.goldcard.algorithm.util.StdOut;

/**  

* <p>Title: Evaluate</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年9月18日  

*/
public class Evaluate {

	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> opStack = new Stack<>();
		Stack<Double> valStack = new Stack<>();
		while(!StdIn.isEmpty()) {
			String string = StdIn.readString();
			if (string.equals("("))  {
				
			} else if (string.equals("+")) {
				opStack.push(string);
			} else if (string.equals("-")) {
				opStack.push(string);
			} else if (string.equals("*")) {
				opStack.push(string);
			} else if (string.equals("/")) {
				opStack.push(string);
			} else if (string.equals("sqrt")) {
				opStack.push(string);
			} else if (string.equals(")")) {
				String op = opStack.pop();
				double value = valStack.pop();
				if (op.equals("+")) {
					value = valStack.pop() + value;
				} else if (op.equals("-")) {
					value = valStack.pop() - value;
				} else if (op.equals("*")) {
					value = valStack.pop() * value;
				} else if (op.equals("/")) {
					value = valStack.pop() / value;
				} else if (op.equals("sqrt")) {
					value = Math.sqrt(value);
				}
				valStack.push(value);
			} else {
				valStack.push(Double.parseDouble(string));
			}
		}
		StdOut.println(valStack.pop());
	}

}

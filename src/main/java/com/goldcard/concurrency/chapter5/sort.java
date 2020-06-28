/**  

* <p>Title: sort.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年6月5日  

* @version 1.0  

*/  
package com.goldcard.concurrency.chapter5;

/**  

* <p>Title: sort</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年6月5日  

*/
public class sort {
	public void insertSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int key = array[i];
			int j = i - 1;
			while(j >= 0 && key < array[j]) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}
	}
	
	public void bubbleSort(int[] array) {
		
	}
	
	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

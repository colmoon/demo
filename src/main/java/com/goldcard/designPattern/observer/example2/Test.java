/**  

* <p>Title: Test.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年7月2日  

* @version 1.0  

*/  
package com.goldcard.designPattern.observer.example2;

/**  

* <p>Title: Test</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年7月2日  

*/
public class Test {

	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) {
		SubjectFor3d subjectFor3d = new SubjectFor3d();
		SubjectForSSQ subjectForSSQ = new SubjectForSSQ();
		
		ObserverA observerA = new ObserverA();
		observerA.registerSubject(subjectFor3d);
		observerA.registerSubject(subjectForSSQ);
		
		subjectFor3d.setMsg("test1");
		subjectForSSQ.setMsg("test2");
	}

}

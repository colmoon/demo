/**  

* <p>Title: ObserverA.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年7月2日  

* @version 1.0  

*/  
package com.moon.demo.service.designPattern.observer.example2;

import java.util.Observable;
import java.util.Observer;

/**  

* <p>Title: ObserverA</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年7月2日  

*/
public class ObserverA implements Observer {

	public void registerSubject(Observable observable) {
		observable.addObserver(this);
	}

	@Override
    public void update(Observable o, Object arg) {
		if (o instanceof SubjectFor3d) {
			SubjectFor3d subjectFor3d = (SubjectFor3d) o;
			System.out.println("subjectFor3D's msg --> " +subjectFor3d.getMsg());
		}
		
		if (o instanceof SubjectForSSQ) {
			SubjectForSSQ subjectForSSQ = (SubjectForSSQ) o;
			System.out.println("subjectFor3D's msg --> " +subjectForSSQ.getMsg());
		}
	}

}

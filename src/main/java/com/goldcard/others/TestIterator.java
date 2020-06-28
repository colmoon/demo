/**  

* <p>Title: TestIterator.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年7月4日  

* @version 1.0  

*/  
package com.goldcard.others;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**  

* <p>Title: TestIterator</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年7月4日  

*/
public class TestIterator {
	public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> list=new ArrayList<String>(); 
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a22");
        Iterator<String> it=list.iterator();
        //去除数组中"a"的元素
        while(it.hasNext()){
            String st=it.next();
            if(st.equals("a")){
                it.remove();
            }

        }
        for(String str:list){
            System.out.println(str);
        }
        
        String classPath = new TestIterator().getClass().getClassLoader().getResource("").getPath();
        System.out.println(classPath);
    }
}

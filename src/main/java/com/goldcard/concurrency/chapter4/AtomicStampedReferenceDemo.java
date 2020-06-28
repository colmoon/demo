/**  

* <p>Title: AtomicStampedReferenceDemo.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2017</p>  

* <p>Company: GoldCard</p>  

* @author wu.xiao.jian 2119

* @date 2018年5月29日  

* @version 1.0  

*/  
package com.goldcard.concurrency.chapter4;

import java.util.concurrent.atomic.AtomicStampedReference;

/**  

* <p>Title: AtomicStampedReferenceDemo</p>  

* <p>Description: </p>  

* @author wu.xiao.jian 2119  

* @date 2018年5月29日  

*/
public class AtomicStampedReferenceDemo {
	static AtomicStampedReference<Integer> money = new AtomicStampedReference<Integer>(19, 0);
	/**  
	
	 * <p>Title: main</p>  
	
	 * <p>Description: </p>  
	
	 * @param args  
	
	 */
	public static void main(String[] args) {

		//模拟多个线程同时更新后台数据库，为用户充值
		final int timeStamp = money.getStamp();
		for(int i = 0; i < 3; i++) {
			new Thread() {
				@Override
                public void run() {
					while (true) {
						while(true) {
							Integer m = money.getReference();
							if(m < 20) {
								if(money.compareAndSet(m, m +20, timeStamp, timeStamp + 1)) {
									System.out.println("余额小于20元，充值成功，余额：" + money.getReference() + "元");
									break;
								}
							} else {
//								System.out.println("余额大于20元，无须充值");
								break;
							}
						}
					}
				}
			}.start();
		}
		
		//用户消费线程，模拟消费行为
		new Thread() {
			@Override
            public void run() {
				for (int i = 0; i < 100; i++) {
					while (true) {
						int timeStamp = money.getStamp();
						Integer m = money.getReference();
						if(m > 10) {
							System.out.println("大于10元");
							if(money.compareAndSet(m, m-10, timeStamp, timeStamp + 1)) {
								System.out.println("成功消费10元，余额：" + money.getReference() + "元");
								break;
							}
						} else {
//							System.out.println("没有足够的金额");
							break;
						}
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO: handle exception
					}
				}
			}
		}.start();
		
		
		
	}
	

}

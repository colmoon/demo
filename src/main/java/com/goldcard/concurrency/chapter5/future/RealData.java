package com.goldcard.concurrency.chapter5.future;

public class RealData implements Data{
	protected final String result;
	public RealData(String para) {
		//RealData 的构造可能很慢，需要用户等待很久，这里使用sleep模拟
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < 10; i++) {
			stringBuffer.append(para);
			try {
				//这里使用sleep，代替一个很慢的操作过程
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		result = stringBuffer.toString();
	}
	
	@Override
    public String getResult() {
		return result;
	}
	
}

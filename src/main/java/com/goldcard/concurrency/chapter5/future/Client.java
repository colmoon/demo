package com.goldcard.concurrency.chapter5.future;

public class Client {
	public Data request(final String queryStr) {
		final FutureData futureData = new FutureData();
		new Thread(() -> {
			RealData realData = new RealData(queryStr);
			futureData.setRealData(realData);
		}).start();
		return futureData;
	}
	public static void main(String[] args) {
		Client client = new Client();
		//这里会立即返回，因为得到的是FutureData 而不是 RealData
		Data data = client.request("name");
		System.out.println("请求完毕");
		try {
			//这里用一个sleep 代替了对其他业务逻辑的处理
			//在处理这些业务逻辑的过程中，realdata 被创建，从而充分利用了等待时间
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//使用真实的数据
		System.out.println("数据 = " + data.getResult());
	}
}

package com.moon.demo.service.delayedQueue;
import java.util.concurrent.DelayQueue;
 
public class DelayQueueTest {
 
	public static void main(String[] args) {
		// 创建延时队列
		DelayQueue<Message> queue = new DelayQueue<Message>();
		// 添加延时消息,m1 延时3s
		Message m1 = new Message(1, "world", 3000);
		// 添加延时消息,m2 延时1s
		Message m2 = new Message(2, "hello", 1000);
		queue.offer(m2);
		queue.offer(m1);
		// 启动消费线程
		new Thread(new Consumer(queue)).start();
	}
 
}
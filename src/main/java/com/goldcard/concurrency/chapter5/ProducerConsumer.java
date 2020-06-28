package com.goldcard.concurrency.chapter5;

import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class ProducerConsumer {
	public static class Producer implements Runnable{
		private volatile boolean isRunning = true;
		private BlockingQueue<PCData> queue;
		private static AtomicInteger count = new AtomicInteger(0);
		private static final int SLEEPTIME = 1000;
		public Producer(BlockingQueue<PCData> queue) {
			this.queue = queue;
		}
		
		@Override
        public void run() {
			PCData data = null;
			Random random = new Random();
			System.out.println("start producer id="+Thread.currentThread().getId());
			try {
				while(isRunning) {
					Thread.sleep(random.nextInt(SLEEPTIME));
					data = new PCData(count.incrementAndGet());
					System.out.println(data + " is put into queue");
					if(!queue.offer(data,2,TimeUnit.SECONDS)) {
						System.err.println("failed to put data: " + data);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
		public void stop() {
			isRunning = false;
		}
	}
	
	public static class Consumer implements Runnable{
		private volatile boolean isRunning = true;
		private BlockingQueue<PCData> queue;
		private static final int SLEEPTIME = 1000;
		public Consumer(BlockingQueue<PCData> queue) {
			this.queue = queue;
		}
		
		@Override
        public void run() {
			Random random = new Random();
			System.out.println("start consumer id="+Thread.currentThread().getId());
			try {
				while(isRunning) {
					PCData data = queue.take();
					if(null != data) {
						int re = data.getData() * data.getData();
						System.out.println(MessageFormat.format("{0}*{1}={2}", data.getData(),data.getData(),re));
						Thread.sleep(random.nextInt(SLEEPTIME));
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
		public void stop() {
			isRunning = false;
		}
	}
	
	public static final class PCData{
		private final int intData;
		public PCData(int d) {
			intData = d;
		}
		public PCData(String dString) {
			intData = Integer.valueOf(dString);
		}
		public int getData() {
			return intData;
		}
		@Override
        public String toString() {
			return "data:"+intData;
		}
	}
	public static void main(String[] args) throws InterruptedException{
		BlockingQueue<PCData> queue = new LinkedBlockingDeque<PCData>(10);
		Producer producer1 = new Producer(queue);
		Producer producer2 = new Producer(queue);
		Producer producer3 = new Producer(queue);
		Consumer consumer1 = new Consumer(queue);
		Consumer consumer2 = new Consumer(queue);
		ExecutorService service = Executors.newCachedThreadPool();
		service.execute(producer1);
		service.execute(producer2);
		service.execute(producer3);
		service.execute(consumer1);
		service.execute(consumer2);
		Thread.sleep(10 * 1000);
		producer1.stop();
		producer2.stop();
		producer3.stop();
		Thread.sleep(3000);
		consumer1.stop();
		consumer2.stop();
		Thread.sleep(3000);
		service.shutdown();
	}

}

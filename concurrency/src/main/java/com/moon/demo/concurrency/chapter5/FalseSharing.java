package com.moon.demo.concurrency.chapter5;

public class FalseSharing implements Runnable{
	public final static int NUM_TREADS = 4;
	public final static long ITERAYIONS = 500L * 1000L *1000L;
	private final int arrayIndex;
	private static VolatileLong[] longs = new VolatileLong[NUM_TREADS];
	
	static {
		for (int i = 0; i < longs.length; i++) {
			longs[i] = new VolatileLong();
		}
	}
	
	public FalseSharing(final int arrayIndex) {
		this.arrayIndex = arrayIndex;
	}
	
	@Override
    public void run() {
		long i = ITERAYIONS + 1;
		while(0 != --i) {
			longs[arrayIndex].value = i;
		}
	}
	
	public final static class VolatileLong{
		public volatile long value = 0L;
		public long p1,p2,p3,p4,p5,p6,p7;
	}
	
	private static void runTest() throws InterruptedException{
		Thread[] threads = new Thread[NUM_TREADS];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new FalseSharing(i));
		}
		for (Thread thread : threads) {
			thread.start();
		}
		for (Thread thread : threads) {
			thread.join();
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		final long start = System.currentTimeMillis();
		runTest();
		System.out.println("duration = " + (System.currentTimeMillis() - start));
	}

}

package com.dark;

/**
 * volatile 不能代替锁 一般认为volatile 比锁性能好（不绝对）
 * 
 * 选择使用volatile的条件是： 语义是否满足应用
 */
public class VolatileStopThread extends Thread {
	private volatile boolean stop = false;

	public void stopMe() {
		stop = true;
	}

	public void run() {
		int i = 0;
		while (!stop) {
			i++;
		}
		System.out.println("Stop thread");
	}

	public static void main(String args[]) throws InterruptedException {
		VolatileStopThread t = new VolatileStopThread();
		t.start();
		Thread.sleep(1000);
		t.stopMe();
		Thread.sleep(1000);
	}
}

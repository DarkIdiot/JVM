package com.dark;

import java.util.HashMap;

public class FullGCDemo {

	public static void main(String[] args) {
		new AllocateThread().start();
		new PrintThread().start();
	}
	
	static class AllocateThread extends Thread {
		HashMap<Long, byte[]> map = new HashMap<Long, byte[]>();

		@Override
		public void run() {
			try {
				while (true) {
					if (map.size() >>11 >= 450) {
						System.out.println("=====准备清理=====:" + map.size());
						map.clear();
					}

					for (int i = 0; i < 1024; i++) {
						map.put(System.nanoTime(), new byte[512]);
					}
					Thread.sleep(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	static class PrintThread extends Thread {
		public static final long starttime = System.currentTimeMillis();

		@Override
		public void run() {
			try {
				while (true) {
					long t = System.currentTimeMillis() - starttime;
					System.out.println("time:" + t);
					Thread.sleep(100);
				}
			} catch (Exception e) {

			}
		}
	}
}
package com.dark.oome;

/** 
 *
 * @author DarkIdiot-PC
 * @date 2016年3月17日 下午3:50:00
 */
public class OOME4Stack {
	/**
	 *	JVM arguments:-Xmx1g -Xss1m
	 */
	public static void main(String args[]){
	    for(int i=0;i<1000000;i++){
	        new Thread(new SleepThread(),"Thread"+i).start();
	        System.out.println("Thread"+i+" created");
	    }
	}
}
class SleepThread implements Runnable{
    public void run(){
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



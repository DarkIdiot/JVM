package com.dark.oome;

import java.nio.ByteBuffer;

/** 
 *
 * @author DarkIdiot-PC
 * @date 2016年3月17日 下午4:00:37
 */
public class OOME4Direct {
	public static void main(String[] args) {
		for(int i=0;i<1024;i++){
		    ByteBuffer.allocateDirect(1024*1024*1024);
		    System.out.println(i);
		      System.gc();
		}

	}
}

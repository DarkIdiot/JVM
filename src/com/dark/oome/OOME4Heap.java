package com.dark.oome;

import java.util.ArrayList;

public class OOME4Heap {
	public static void main(String args[]){
	    ArrayList<byte[]> list=new ArrayList<byte[]>();
	    for(int i=0;i<1024;i++){
	        list.add(new byte[1024*1024]);
	    }
	}

}

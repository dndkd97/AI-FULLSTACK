package com.the703.basic008_ex;

public class Arr1Ex009 {

	public static void main(String[] args) {
		//모든값을 더하는 프로그램
		int [] arr = {10,20,30,40,50};
		int box=0;
		
		for(int i=0; i<arr.length; i++) {
			box+=arr[i];
		}System.out.println("sum="+box);

	}

}

package com.the703.basic008_ex;

public class Arr1Ex005 {

	public static void main(String[] args) {
		
		//음수의 갯수 출력
		int [] su = {-3,5,-1,9,-7};
		int total=0;
		for(int i=0; i<su.length; i++) {
			if(su[i]<0) {total++;}}
		System.out.print("음수의 갯수:"+total);
		
		

	}

}

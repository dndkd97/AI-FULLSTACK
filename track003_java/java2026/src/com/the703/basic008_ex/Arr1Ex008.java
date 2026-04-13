package com.the703.basic008_ex;

public class Arr1Ex008 {

	public static void main(String[] args) {
		//최대값,최소값 구하기
		int [] su = {-3,-5,-1,-9,-7};
		int max=-99999,min=99999;
		for(int i=0; i<su.length; i++) {
		if(su[i]>max) {max = su[i];}
		if(su[i]<min) {min = su[i];}
		
		}System.out.println("최댓값:"+max);	
		 System.out.println("최솟값:"+min);

	}

}

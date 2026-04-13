package com.the703.basic008_ex;

public class Arr1Ex006 {

	public static void main(String[] args) {
		//홀수의 합
		int [] su = {-3,5,-1,9,-7,2,-11};
		int total=0;
		for(int i=0; i<su.length; i++) {
			if((su[i]%2)!=0 && su[i]>0) {total+=su[i];}
		   }System.out.print(total);
	}

}

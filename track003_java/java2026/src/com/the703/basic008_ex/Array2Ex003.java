package com.the703.basic008_ex;

public class Array2Ex003 {

	public static void main(String[] args) {
		int [] [] arr = {
				   { 1, 1, 1,},
				   { 2, 2, 2,},
				   { 3, 3, 3,},
				   { 4, 4, 4,},
				 };
		int total=0;  double avg=0.0;
		
		
		for(int i=0; i<arr.length; i++) {
			for(int a=0; a<arr[i].length; a++) {
				total+=arr[i][a];
			}}
		System.out.println("총점:"+total);
		avg=(double)total/(arr.length * arr[0].length);
		System.out.printf("평균:%.1f",avg);	
		
	}
}

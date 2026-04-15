package com.the703.days;

public class Day015 {

	public static void main(String[] args) {
		
		for(int i=3; i>=1; i--) {System.out.print(i);}System.out.println();
		
		int i=3;
		while(i>=1) {System.out.print(i);i--;}System.out.println();
		
		int i2=3;
		do {System.out.print(i2); i2--;}while(i2>=1);System.out.println();
		
		for(int a=3; a>=1; a--) {
			for(int a1=a; a1>=1; a1--) {
				System.out.print("★");
			}System.out.println();
		}
	
		
	/*	char [] arr1 = {'A','B','C'};
		for(int b=0; b<arr.length; b++) {
			
			arr[b]=arr1[b];
			
			System.out.print(arr[b]);} */
		
		char [] arr = new char [3];
			char ch='A';
			for(int b=0; b<arr.length; b++) {
				arr[b]=ch++;
				
				System.out.print(arr[b]);
			}
		

	}

}

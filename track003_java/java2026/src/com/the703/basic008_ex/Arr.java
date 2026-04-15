package com.the703.basic008_ex;

public class Arr {

	public static void main(String[] args) {
		/*for(int i=3; i>=1; i--) {
			for(int a=i; a>=1; a--) {
				System.out.print("#");
			}System.out.println();
		}*/
		
		char [] arr = new char [3];
		char ch='A';
		for(int i=0; i<arr.length; i++) {
			arr[i]=ch++;
		}
     for(int i=0; i<arr.length; i++) {
    	 System.out.print(arr[i]);
     }
	}

}

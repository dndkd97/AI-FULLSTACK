package com.the703.basic008_ex;

public class Array2Ex002 {

	public static void main(String[] args) {
		int [] [] arr = new int [2][3];
		
		int num=101;
		for(int ch=0; ch<arr.length; ch++) {
			for(int kan=0; kan<arr[ch].length; kan++) {
				arr[ch][kan]=num; num+=1;
				System.out.print(arr[ch][kan]+"\t");
			}System.out.println();
		}
	}

}

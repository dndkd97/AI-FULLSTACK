package com.the703.basic008;

import java.util.Arrays;

public class Arr2001 {

	public static void main(String[] args) {
		
		int [] [] arr2 = {
				{1,2,3},//00 01 02
				{4,5,6},//10 11 12
		};
		
		System.out.println(arr2);
		System.out.println(Arrays.toString(arr2));
		
		//ver-1 눈에 보이는 대로
		System.out.print(arr2[0][0]+"\t");
		System.out.print(arr2[0][1]+"\t");
		System.out.print(arr2[0][2]+"\t"); System.out.println();
		
		System.out.print(arr2[1][0]+"\t");
		System.out.print(arr2[1][1]+"\t");
		System.out.print(arr2[1][2]+"\t"); System.out.println();
		System.out.println();
		
		//ver-2 칸정리
		for(int i=0; i<=2; i++) {
		System.out.print(arr2[0][i]+"\t");
	   }System.out.println();
		for(int i=0; i<=2; i++) {
		System.out.print(arr2[1][i]+"\t");
	   }System.out.println();
		System.out.println();
		
		//ver-3 층정리
		for(int i=0; i<=1; i++) {
		for(int i1=0; i1<=2; i1++) {
		System.out.print(arr2[i][i1]+"\t");
	   }System.out.println();}
		System.out.println();
		
		//ver-4 length 이용
		for(int ch=0; ch<arr2.length; ch++) {
		for(int kan=0; kan<arr2[ch].length; kan++) {
		System.out.print(arr2[ch][kan]+"\t");
	   }System.out.println();}
		

}

}

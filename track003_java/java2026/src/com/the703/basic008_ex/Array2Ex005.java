package com.the703.basic008_ex;

public class Array2Ex005 {

	public static void main(String[] args) {
		 int [] [] arr = new int [5] [5];
	      int result1 [] [] = new int [5] [5];
	      int result2 [] [] = new int [5] [5];
	      int result3 [] [] = new int [5] [5];
	      int num=1;
	      
	      for(int i=0; i<arr.length; i++) {
	      for( int a=0; a<arr[i].length; a++) {
	            arr[i][a]=num++;   }}//arr배열에 1~25넣기
	      
	   
	      
	      for(int i=0; i<5; i++) {
	      for(int j=0; j<5; j++) {
	            result1[j][4-i]=arr[i][j];//90도 회전
	            result2[4-j][i]=arr[i][j];//-90도 회전
	            result3[4-i][4-j]=arr[i][j];} }//180도 회전
	      
	      for(int i=0; i<5; i++) {
	         for(int j=0; j<5; j++) {
	         System.out.print(result1[i][j]+"\t");//90도 회전 출력
	          }System.out.println();} System.out.println();
	      
	      for(int i=0; i<5; i++) {
	         for(int j=0; j<5; j++) {
	         System.out.print(result2[i][j]+"\t");//-90도 출력
	          }System.out.println();} System.out.println();
	      
	      for(int i=0; i<5; i++) {
	         for(int j=0; j<5; j++) {
	          System.out.print(result3[i][j]+"\t");//180도 회전 출력
	           }System.out.println();} System.out.println();
	      
	   }
	}
	/*    for(int i=0; i<5; i++) {
	      for(int j=0; j<5; j++) {
	            result1[j][4-i]=arr[i][j];} } //배열 90도 회전 
	         
	      for(int i=0; i<5; i++) {
	      for(int j=0; j<5; j++) {
	            System.out.print(result1[i][j]+"\t");//-90도 배열 출력
	   }System.out.println();}System.out.println();
	      
	      for(int i=0; i<5; i++) {
	      for(int j=0; j<5; j++) {
	            result2[4-j][i]=arr[i][j];} }
	      
	      for(int i=0; i<5; i++) {
	      for(int j=0; j<5; j++) {
	            System.out.print(result2[i][j]+"\t");//-90도 배열 출력
	     }System.out.println();}
	      System.out.println();
	      for(int i=0; i<5; i++) {
	      for(int j=0; j<5; j++) {
	            result3[4-i][4-j]=arr[i][j];} }//180도 회전
	      
	      System.out.println();
	      for(int i=0; i<5; i++) {
	      for(int j=0; j<5; j++) {
	            System.out.print(result3[i][j]+"\t");//180도 배열 출력
	           }System.out.println();} 
	 * 
	 * 
	 * 
	1   2   3   4   5 j행 00 01 02 03 04 00=i열0에 j행0
	6   7   8   9  10    10 11 12 13 14 10=i열0에 j행1
	11  12  13  14  15   20 21 22 23 24 
	16  17  18  19  20   30 31 32 33 34 30=i열3에 j행0
	21  22  23  24  25   40 41 42 43 44 40=i열4에 j행0
	i열

	21 16 11  6  1     40 30 20 10 00     21=40→00 , i열4에 j행0→i열0에 j행0
	22 17 12  7  2     41 31 22 11 01
	23 18 13  8  3     42 32 22 12 02
	24 19 14  9  4     43 33 23 13 03
	25 20 15 10  5     44 34 24 14 04

	 5 10 15 20 25  5=04→00 i열0에 j행4→ i열0에 j행4
	 4  9 14 19 24
	 3  8 13 18 23
	 2  7 12 17 22
	 1  6 11 16 21
	 
	25 24 23 22 21  25=44>00 i열4에 j행4→i열0에 j행0
	20 19 18 17 16
	15 14 13 12 11
	10  9  8  7  6
	 5  4  3  2  1
	 * 
	 * 
	 * 
	 * 
	 * */
	 


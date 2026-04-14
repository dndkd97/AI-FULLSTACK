package com.the703.days;

import java.util.Scanner;

public class Day014 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.println("정수 하나 입력받아 다음 조건에 따라 요일을 출력하는 프로그램을 작성하시오."); num = sc.nextInt();
		System.out.println("if 버전");
		     if(num==1) {System.out.println("1이다");}
		else if(num==2) {System.out.println("2이다");}
		else if(num==3) {System.out.println("3이다");}
		else            {System.out.println("1,2,3이 아니다");}
		     
		switch(num) {
		case 1:{System.out.println("1이다");}break;
		case 2:{System.out.println("2이다");}break;
		case 3:{System.out.println("3이다");}break;
		default :{System.out.println("1,2,3이 아니다");}break;
		}
		
		System.out.println("for,while,do while 버전");
				
				for(int i=1; i<=4; i++) {System.out.print(i);}System.out.println();
				
				int i1=1;
				while(i1<=4) {System.out.print(i1); i1++;} System.out.println();
				
				int i2=1;
				do {System.out.print(i2); i2++;}while(i2<=4); System.out.println();
				
				System.out.println("이중 for 버전");
				
				for(int i=1; i<=3; i++) {
					for(int a=1; a<=i; a++) {System.out.print("★");}System.out.println();}
				
				
				System.out.println("1차원 배열 다음에 해당하는 값에서 index를 이용하여 3을 출력");
				int [] arr2 = {1,2,3};
				System.out.print(arr2[2]);
				System.out.println();
				
				System.out.println("1차원 배열 new 연산자 이용");
				
				double [] arr = new double[5];
				double total=1.1;
				
				for(int i=0; i<arr.length; i++) {arr[i]=total; total+=0.1;}
					for(int i=0; i<arr.length; i++) {System.out.printf("%.1f ",arr[i]);}
				}
			
				

	}



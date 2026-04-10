package com.the703.days;

import java.util.Scanner;

public class Day012 {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 int num;
		 
		 System.out.println("if버전에 해당하는 다음에 연결해서 문제를 작성하시오");
		 System.out.println("정수를 하나 입력하시오"); num = sc.nextInt();
		       if(num>=90) {System.out.println("A학점");}
		 else if(num>=80) {System.out.println("B학점");}
		 else if(num>=70) {System.out.println("C학점");}
		 else             {System.out.println("F학점");}
		       
		 System.out.println("switch버전에 해당하는 다음에 연결해서 문제를 작성하시오.");
		 switch(num/10) {
		 case 10: case 9:System.out.println("A학점");break;
		 case 8:System.out.println("B학점");break;
		 case 7:System.out.println("C학점");break;
		 default:System.out.println("F학점");break;}
		 
		 System.out.println("for,while,do while 버전으로 문제를 풀으시오");
		 
		 for(int i=1; i<=3; i++) {System.out.print(i);}System.out.println();
		 
		 int i=1;
		 while(i<=3) {System.out.print(i); i++;}System.out.println();
		 
		 int i1=1;
		 do {System.out.print(i1); i1++;}while(i1<=3);System.out.println();
		 
		 for(int i2=1; i2<=4; i2++) {for(int a=1; a<=4; a++) {System.out.print("★");}System.out.println();}
		 
		 
		 }

	}



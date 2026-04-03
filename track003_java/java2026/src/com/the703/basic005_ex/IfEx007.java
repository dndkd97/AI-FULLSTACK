package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx007 {

	public static void main(String[] args) {
		/* 1. 정수를 하나 입력해주세요 > 10
		2. 정수를 하나 입력해주세요 > 3
		3. 연산자를 입력해주세요(+,-,*,/) > +
		10+3=13 */
		
		Scanner sc = new Scanner(System.in);
		
		int num1,num2;
		double answer = 0;
		char op='\u0000';
	
		System.out.println("1.정수를 하나 입력해주세요"); num1 = sc.nextInt();
		System.out.println("2.정수를 하나 입력해주세요"); num2 = sc.nextInt();
		System.out.println("3.연산자를 입력해주세요"); op = sc.next().charAt(0);
		
		
		if     (op == '+') {answer=answer =num1+num2;}
		else if(op == '-') {answer =(num1-num2);}
		else if(op == '*') {answer =num1*num2;}
        else if(op == '/') {answer =(double)num1/num2;}
		
		
			System.out.printf(answer == (int)answer? "%d%c%d=%.0f": "%d%c%d=%.2f"
			  ,num1,op,num2, (answer == (int)answer? answer : answer));
		
	
	}

}



package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx001 {

	public static void main(String[] args) {

	//	출력내용 : 평균을 입력받아 60점이상이면 합격,  불합격여부를 출력하는 프로그램을 IF로 작성하시오.
		
		Scanner sc = new Scanner(System.in);
		int a;
		String result = "불합격";
		
		System.out.println("평균점수 입력>"); a = sc.nextInt();
	
		
		if(a>=60) {System.out.println("합격입니다");}
		else      {System.out.println("불합격입니다");}
		
		if(a>=60) {result="합격";}
	
		String answer = a>=60? "합격입니다": "불합격입니다";
		System.out.println(answer);
		
		
		

	}

}

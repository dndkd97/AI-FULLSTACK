package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx004 {

	public static void main(String[] args) {
		/*
		문자한개를 입력받아 
		   대문자인지,  소문자인지 판별하는 프로그램을 작성하시오.
		   ※  대문자  ch>='A' && ch<='Z' / 소문자  ch>='a'  &&  ch<='z'  */
		
		Scanner sc = new Scanner(System.in);
		char ch;
		
		System.out.println("문자 한개를 입력하시오"); ch = sc.next().charAt(0);
		
		if     (ch>='A' && ch<='Z') {System.out.println("대문자입니다");}
		else if(ch>='a' && ch<='z') {System.out.println("소문자입니다");}
		
		
		String answer = (ch>='A' && ch<='Z')? "대문자입니다": 
			            (ch>='a' &&  ch<='z')? "소문자입니다": "오류";
		System.out.println(answer);
		
				
		
		//처리
		//처리
		

	}

}

package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx002 {

	public static void main(String[] args) {
		// 숫자 한개를 입력받아 
		// 양수라면 양수  , 음수라면 음수  ,0이라면 zero를 출력하는 프로그램을 작성하시오.
		
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.println("숫자를 입력하시오"); num = sc.nextInt();
		
		if(num>0) {System.out.println("양수입니다");}
		else if(num == 0) {System.out.println("zero");}
		else  {System.out.println("음수입니다");}
		
		String answer = (num>0)? "양수입니다": 
			            (num==0)? "zero": "음수입니다";
		System.out.println(answer);

	}

}

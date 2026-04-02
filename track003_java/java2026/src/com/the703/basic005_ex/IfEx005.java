package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx005 {

	public static void main(String[] args) {
		/*  문자한개를 입력받아 
		   대문자인지 이면 소문자로,  소문자이면 대문자로 변경하는 프로그램을 작성하시오.
		   ※  a = 'A' + 32  */
		
		Scanner sc = new Scanner(System.in);
		char ch,a,b;
		System.out.println("문자 한개를 입력하시오"); ch = sc.next().charAt(0);
		
		
		if(ch>='A' && ch<='Z') {System.out.println((char)(ch + 32));}
		if(ch>='a' && ch<='z') { System.out.println((char)(ch - 32));}
		
		
		
		

	}

}

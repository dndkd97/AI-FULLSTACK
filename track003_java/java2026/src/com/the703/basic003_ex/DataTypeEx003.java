package com.the703.basic003_ex;
import java.util.Scanner;
public class DataTypeEx003 {

	public static void main(String[] args) {
		
		int age;
	    int year= -1;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("태어난 년도를 입력하세요"); year = sc.nextInt();
		
		age = 2026-year;
		System.out.println("당신의 나이는"+age+ "입니다");
		System.out.print("당신의 나이는"+age+"입니다\n");
		System.out.printf("%s%d%s","당신의 나이는",age,"입니다");
		
		
		/*
		int year= -1;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("태어난 연도를 입력하시오"); year = sc.nextInt();
		
		year = 2026 - year;
		
		System.out.println("당신의 나이는"+year+"입니다");
		*/
		

	}

}

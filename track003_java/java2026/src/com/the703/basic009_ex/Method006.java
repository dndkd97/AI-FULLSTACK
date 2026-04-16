package com.the703.basic009_ex;

import java.util.Scanner;

public class Method006 {
	
	public static int abs(int resl) {return Math.abs(resl);}

	public static void main(String[] args) {
		int resl=0; 
		Scanner sc = new Scanner(System.in);
		System.out.println("절대값을 구하는 프로그램입니다. \n 숫자를 입력하세요");
		resl=abs(sc.nextInt());
		System.out.println(resl);

	}

}

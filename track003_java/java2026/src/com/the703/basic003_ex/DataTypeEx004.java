package com.the703.basic003_ex;
import java.util.Scanner;
public class DataTypeEx004 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		float p1;
		
		System.out.println("파이값을 입력하시오"); p1 = sc.nextFloat();
		System.out.println("파이값은"+p1+"입니다");
		
		System.out.printf("파이값은 %.0f입니다.\n",p1); //3
		System.out.printf("파이값은 %.1f입니다.\n",p1); // 3.1
		System.out.printf("파이값은 %.2f입니다.\n",p1); // 3.12
		System.out.printf("파이값은 %.3f입니다.\n",p1); // 3.123
		
		System.out.println(10/3);  // 정수/정수
		System.out.println(10/3f); // 정수/실수
		System.out.println(10f/3); // 실수/정수
		
		
		// TODO Auto-generated method stub

	}

}

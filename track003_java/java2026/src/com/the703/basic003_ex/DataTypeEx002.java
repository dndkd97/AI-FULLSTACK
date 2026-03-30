package com.the703.basic003_ex;
import java.util.Scanner;
public class DataTypeEx002 {

	public static void main(String[] args) {
		int age;
		Scanner sc = new Scanner(System.in);
		System.out.println("좋아하는 수(정수) 입력하시오"); age = sc.nextInt();
		
		System.out.println("좋아하는 숫자는"+ age + "입니다");
		System.out.print("좋아하는 숫자는"+age+"입니다\n");
		System.out.printf("%s%d%s","좋아하는 숫자는",age,"입니다");
		
		// TODO Auto-generated method stub

	}

}

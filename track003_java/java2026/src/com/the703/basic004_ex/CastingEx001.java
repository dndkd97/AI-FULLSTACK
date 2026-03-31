package com.the703.basic004_ex;
import java.util.Scanner;
public class CastingEx001 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1,num2;
		double result;
		
		System.out.println("숫자입력1"); num1 = sc.nextInt();
		System.out.println("숫자입력2"); num2 = sc.nextInt();
		
		result = (double)num1/(double)num2;
		
		System.out.printf(num1+"/"+num2+"="+"%.2f",result);
		
		
		
		// TODO Auto-generated method stub

	}

}

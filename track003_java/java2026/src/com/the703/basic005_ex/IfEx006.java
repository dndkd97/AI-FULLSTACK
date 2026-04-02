package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx006 {

	public static void main(String[] args) {
		
		
		/*숫자를입력을받아
		   홀수면 남자, 짝수면 여자를 출력하는 프로그램을 작성하시오.
		   ※  num%2==0  짝수 */
		
		Scanner sc = new Scanner(System.in);
		int num;
		
		System.out.println("숫자를 입력하시오 "); num = sc.nextInt();
		if(num%2==0) {System.out.println("짝수입니다");}
		else         {System.out.println("홀수입니다");}

	}

}

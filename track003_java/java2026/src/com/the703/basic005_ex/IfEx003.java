package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx003 {

	public static void main(String[] args) {
		/*숫자한개를 입력받아 
		   만약 1을 입력했다면   one ,   
		   만약 2을 입력했다면   two ,
		   만약 3을 입력했다면   three ,
		   1,2,3이 아니라면  1,2,3이 아니다를 출력하는 프로그램을 작성하시오.*/
		 
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.println("숫자 1개를 입력하시오"); num = sc.nextInt();
		
		if(num==1) {System.out.println("one");}
		else if (num == 2){System.out.println("two");}
		else if(num==3) {System.out.println("three");}
		else {System.out.println("1,2,3이 아니다");}
		
		String answer = (num ==1)? "1이다": 
			            (num ==2)? "2이다":
			            (num ==3)? "3이다": "1,2,3이 아니다";
		System.out.println(answer);
		
	}

}

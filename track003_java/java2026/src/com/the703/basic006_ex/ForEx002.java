package com.the703.basic006_ex;
import java.util.Scanner;
public class ForEx002 {

	public static void main(String[] args) {
		//  사용자에게 단을 입력받아 해당하는 
		//  단을 출력해주는 프로그램을 작성하시오. FOR문을 이용하시오. 
		Scanner scanner = new Scanner(System.in);
		
		int num;
		System.out.println("숫자입력>"); num= scanner.nextInt();
		
		for(int i=1; i<=10; i++) {System.out.println(num+"*"+i+"="+num*i);}
	}
}
	


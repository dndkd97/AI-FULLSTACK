package com.the703.basic005_ex;
import java.util.Scanner;
public class SwitchEx001 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.println("숫자 한개를 입력하시오"); num = sc.nextInt();
		switch(num){ //1.대상
		case 3:System.out.println("봄");break;
		case 6:System.out.println("여름");break;
		case 9:System.out.println("가을");break;
		case 12:System.out.println("겨울");break;
		default: System.out.println("3,6,9,12가 아니다");
		}
		switch(num){
		
		}
		
		// TODO Auto-generated method stub

	}

}

package com.the703.basic005_ex;
import java.util.Scanner;
public class SwitchEx002 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.println("숫자 한개를 입력 받으시오"); num = sc.nextInt();
		
		switch(num) {
		case 3 :  case 4 :case 5:System.out.println("봄");break;
		case 6 :  case 7 :case 8:System.out.println("여름");break;
		case 9 :  case 10 :case 11:System.out.println("가을");break;
		case 12 :  case 1 :case 2:System.out.println("겨울");break;
		default:System.out.println("봄,여름,가을,겨울이 아니다");
		}
		
		switch(num/3){
		case 1:System.out.println("봄");break; // 3/3=1 4/3=1 5/3=1
		case 2:System.out.println("여름");break; // 6/3=2 7/3=2 8/3=2
		case 3:System.out.println("가을");break;
		case 4:System.out.println("겨울");break;
		}
				
		// TODO Auto-generated method stub

	}

}

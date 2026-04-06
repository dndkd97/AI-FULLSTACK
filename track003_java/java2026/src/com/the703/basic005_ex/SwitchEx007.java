package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx007 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double num;
		System.out.println("평균 입력>"); num = sc.nextDouble();
		
		switch((int)num/10) {
		case 9: case 10: System.out.println("수");break;
		case 8: System.out.println("우");break;
		case 7: System.out.println("수");break;
		case 6: System.out.println("양");break;
		default :System.out.println("가");break;
		}

	}

}

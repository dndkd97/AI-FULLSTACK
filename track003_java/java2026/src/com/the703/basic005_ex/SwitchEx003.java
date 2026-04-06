package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx003 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ch;
		
		System.out.println("문자 하나 입력"); ch = sc.next().charAt(0);
		
		switch(ch) {
		case 'a':System.out.println("apple");break;
		case 'b':System.out.println("BANANA");break;
		case 'c':System.out.println("COCONUT");break;
		}

	}

}

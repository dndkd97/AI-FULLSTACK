package com.the703.basic005_ex;

import java.util.Scanner;

public class SwitchEx004 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ch;
		System.out.println(); ch = sc.next().charAt(0);
		switch(ch){
		case 'a': case 'A':System.out.println("APPLE");break;
		case 'b': case 'B':System.out.println("BANANA");break;
		case 'c': case 'C':System.out.println("COCONUT");break;
		}

	}

}

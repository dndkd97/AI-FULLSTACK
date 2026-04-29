package com.the703.basic014_ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListEx002 {

	public static void main(String[] args) {
		List numbers = new ArrayList();
		numbers.add("one");
		numbers.add("two");
		numbers.add("three");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1,2,3 입력> ");int num = sc.nextInt();
		
		//ver-1
//		     if (num ==1){System.out.println(numbers.get(0));}
//		else if (num ==2){System.out.println(numbers.get(1));}
//		else if (num ==3){System.out.println(numbers.get(2));}
//		     
//		//ver-2
//		switch(num) {
//		case 1:System.out.println(numbers.get(0)); break;
//		case 2:System.out.println(numbers.get(1)); break;
//		case 3:System.out.println(numbers.get(2)); break;
//		}
		
		//ver-3
		if(num>=1 && num<=3) { System.out.println(numbers.get(num-1));}
		else                 { System.out.println("1,2,3 입력> ");}
		

	}

}

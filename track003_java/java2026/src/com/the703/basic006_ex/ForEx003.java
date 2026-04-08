package com.the703.basic006_ex;

public class ForEx003 {

	public static void main(String[] args) {
	/*	1~10까지의 합을 구하시오.
		upgrade)  시간나면 도전!
		1+2+3+4+5+6+7+8+9+10=55 */
		int total=0;
		for(int i=1; i<=10; i++) 
		{ total += i; // total = total+i;
		 System.out.print(i+"+");
		 System.out.print("=");  }
		
		 System.out.print(total);
	
	}

}

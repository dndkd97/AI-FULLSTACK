package com.the703.basic006_ex;

public class ForEx004 {

	public static void main(String[] args) {
		/*
		 * 1~10까지 3의 배수 갯수를 출력   
           upgrade)  시간나면 도전!
           3의배수 : 3,6,9    
           갯수 : 3개
		 */
		int total=0;
		System.out.print("3의배수:");
		for(int i=3; i<=10; i=i+3) { System.out.print(i + ((i==9)?" ":","));
		total++; 
		}
		System.out.println("\n갯수:"+total+"개");
		
	}

}

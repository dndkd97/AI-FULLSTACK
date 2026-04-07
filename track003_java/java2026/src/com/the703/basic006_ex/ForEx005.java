package com.the703.basic006_ex;

public class ForEx005 {

	public static void main(String[] args) {
		// 소문자 a~z까지 모음의 갯수를 출력하시오. 
		
	 int total=0;
	 
	 for(char ch='a'; ch<='z'; ch++) { 
		 if ( ch == 'a' || ch== 'e' || ch=='i' || ch=='o' || ch=='u' ) total++;}
	 System.out.println("소문자 a~z까지 모음의 갯수: "+total);

	}

}

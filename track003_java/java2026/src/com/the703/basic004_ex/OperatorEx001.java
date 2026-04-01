package com.the703.basic004_ex;

public class OperatorEx001 {

	public static void main(String[] args) {
		
		// () 값 (+ - * / %) 비교( > < ) 조건 (&& || ?;) 대입(=) 
	    int a=3, b=10;
		System.out.println(  b+=10 - a-- );     
		//1) a-- (;끝나고 계산 > 맨 마지막에 상태)a=3 b=10
		//2) 10 - a = 10 - 3 = 7
		//3) b+=7 b=b+7   출력   b=10+17 (17)
		//4) ; 후 a=2 b=17
	    System.out.println(  a+=5 );         
	    //a = a+5 a=2+5 a=7
	    System.out.println(  a>=10 || a<0 && a>3); 
	    //1) a>= 10 → 7 >= 10 → false
	    //2) a<0 && a>3 → 7<0 → false
	    //3) false || false = false 
		

	}

}

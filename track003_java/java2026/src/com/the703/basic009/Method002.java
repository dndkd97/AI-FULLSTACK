package com.the703.basic009;

public class Method002 {
	//1.      리턴값 메서드명(파라미터:재료 ★)
	//                 hello("cat");
	public static void hello(String name) { //String name = "cat"
		System.out.println("Hello~"+name);
	}
	//                 icecream(      1)
	public static void icecream(int num) {
		System.out.println("아이스크림"+num+"개");
	}
	
	public static void info(String str, int score) {
		System.out.println(str+" 최종 "+score+"점");
		                 //%s    최종       %d 점 , str,score
		
	}
    ///////////////////////////////////////////////
	public static void main(String[] args) {
		hello("cat");
		hello("dog");
		
		icecream(1);
		icecream(2);
		
		info("cat", 10); // cat 최종 10점
		info("dog" , 9); // dog 최종 9점  
	}
    ///////////////////////////////////////////////

}

package com.the703.basic009_ex;

public class MethodEx001 {
	//1. 리턴값 메서드명(파라미터)

	public static void dog() {
		System.out.println("멍멍");
	}
	
	public static void cat() {
		System.out.println("냐옹");
	}
	
	public static void line() {
		System.out.println("========");
	}

	public static void main(String[] args) {
		//2.호출:메서드(파라미터)
		dog();
		line();
		cat();
		line();

	}

}

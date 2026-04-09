package com.the703.days;
import java.util.Scanner;
public class Day011 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char ch='\u0000';
		
		
		System.out.println("문자를 한개 입력하시오"); ch = sc.next().charAt(0);	
		
		System.out.println("1.if버전에 해당하는 다음에 연결해서 문제를 작성하시오.");
		if(ch=='a') {System.out.println("apple");}
		else if(ch=='b') {System.out.println("banana");}
		else if(ch=='c') {System.out.println("coconut");} 
		
		System.out.println("2.switch버전에 해당하는 다음에 연결해서 문제를 작성하시오.");
		switch(ch){
			case 'a':System.out.println("apple");break;
			case 'b':System.out.println("banana");break;
			case 'c':System.out.println("coconut");break;
			default: System.out.println("a,b,c가 아니다");break;}
			
			System.out.println("3.for,while,dowhile 버전으로 문제를 풀으시오");
			
			for(int i=1; i<=5; i++) {System.out.print(i);}
			int i=1;
			while(i<=5){System.out.print(i); i++;}
			
			int i1=1;
			do{System.out.print(i1); i1++;}while(i1<=5);
			
		}

	}



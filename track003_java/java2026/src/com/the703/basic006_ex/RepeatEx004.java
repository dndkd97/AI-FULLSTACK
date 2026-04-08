package com.the703.basic006_ex;

public class RepeatEx004 {

	public static void main(String[] args) {
		// A~Z까지 출력/5번째마다 줄바꿈
		char ch='\u0000', ch1='\u0000',ch2='\u0000';
		
		   System.out.println("1.for)");
		   for( ch='A'; ch<='Z'; ch++) 
		   {System.out.print(ch); 
		   if((ch%5)==0 +4) {System.out.print("\n");}}
		   
	       System.out.println("\n2.while)");
		   ch1='A'-1;
		   while(ch1<='Z'-1) {ch1++; System.out.print(ch1);
		   if((ch1)%5==0+4) {System.out.print("\n");}} 
			
		   System.out.println("\n3.dowhile");
		   ch2='A'-1;
		   do {    ch2++; System.out.print(ch2);
		   if((ch2)%5==0+4) {System.out.print("\n");}} while(ch2<='Z'-1);
			          
			                                
		}           
	}



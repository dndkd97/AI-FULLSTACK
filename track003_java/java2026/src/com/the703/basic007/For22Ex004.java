package com.the703.basic007;

public class For22Ex004 {

	public static void main(String[] args) {
		
		
		
	/*	int total=0;
		for(int a=1; a<=100; a+=10)
		    { for(int i=a; i<=a+9; i++) 
			{ total+=i; System.out.print(i+ ((i%10)==0?"=":"+"));}    
			            System.out.print(total+"\n");    total=0;} */
		
		
	/*	int a=1;
		while(a<=100) { int i=a; int total=0;
	    while(i<=(a+9)){  total+=i; 
			   System.out.print(i+ ((i%10)==0?"=":"+")); i++; }System.out.println(total);a+=10;
			   total=0;} */
		
		int a1=1;
		    do {int i1=a1; int total=0;
			do {System.out.print(i1+ ((i1%10)==0?"=":"+"));total+=i1;i1++; }
			while(i1<=(a1+9)); System.out.println(total); a1+=10; total=0;}while(a1<=100);
			               
			              
			  
		
			
			                                     
			
		}
	}
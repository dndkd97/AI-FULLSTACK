package com.the703.basic007;

public class For22Ex001 {

	public static void main(String[] args) {
/*1+5=6
2+4=6
3+3=6
4+2=6
5+1=6*/
		System.out.println("ver-1:for");
		for(int i=1; i<=1; i++) {
			for(int a=5; a>=1; a--) {
				  System.out.println(i+"+"+a+"="+(a+i));i++;
				}System.out.println();
		}
		
		System.out.println("ver-2:while");
		int i=1; 
		while(i<=1){
		         int a=5;
		       while(a>=1) {System.out.println(i+"+"+a+"="+(i+a)); a--;  i++;}System.out.println();}
		
		System.out.println("ver-3:dowhile");
		
		int i1=1;
		do {    
		int a1=5;	  do {System.out.println(i1+"+"+a1+"="+(i1+a1)); a1--; i1++;}while(a1>=1);
		      }while(i1<=1);
		        
	}

}

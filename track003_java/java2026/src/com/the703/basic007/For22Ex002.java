package com.the703.basic007;

public class For22Ex002 {

	public static void main(String[] args) {
		
		for(char ch='A'; ch<='Z'; ch++) {
			for(int i=1; i<=(ch-'A'+1); i++) {System.out.print(ch);}System.out.println();}
		
		    char ch1='A';
		    while(ch1<='Z'){ int i1=1;
			while(i1<=(ch1-'A'+1)){System.out.print(ch1); i1++; }System.out.println(); ch1++;} 
		
		
		char ch2='A';
		do { int i2=1;
			 do{System.out.print(ch2); i2++;}while(i2<=(ch2-'A'+1));ch2++;
			 System.out.println();}while(ch2<='Z');
	
		}}

	


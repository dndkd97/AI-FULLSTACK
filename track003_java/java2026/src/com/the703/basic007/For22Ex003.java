package com.the703.basic007;

public class For22Ex003 {

	public static void main(String[] args) {
		
		
		
		   for(char ch='Z'; ch>='A'; ch--) {
			for(int i='A'; i<=ch; i++) {System.out.print(ch);}System.out.println(); 
				
			    char ch1='Z';
			    while(ch1>='A') { int i1='A';
				while(i1<=ch1) {System.out.print(ch1); i1++;}System.out.println();ch1--;} 

		       char ch2='Z';
			    do {int i2='A'; do {System.out.print(ch2);i2++;}
				while(i2<=ch2); System.out.println(); ch2--;}while(ch2>='A');
		
			    
		}

	}}


// (ch-'A'+1)
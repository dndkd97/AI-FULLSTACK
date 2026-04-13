package com.the703.basic007;

public class For22Ex003 {

	public static void main(String[] args) {

		
		
		     char ch='\u0000';
	         for( ch='Z'; ch>='A'; ch--) {
	         for(char ch1='A'; ch1<=ch; ch1++) {
	          System.out.print(ch1);
	          }System.out.println();} 
	      
	         char ch2='Z';
	         while(ch2>='A') {
	         char ch3='A';
	         while(ch3<=ch2) {
	            System.out.print(ch3); ch3++;}System.out.println();  ch2--;} 
	      
	         char ch3='Z';
	         do {  char ch4='A';
	         do {
	            System.out.print(ch4); ch4++;
	         }while(ch4<=ch3); System.out.println(); ch3--;
	         }while(ch3>='A');
	         
			    
		

	}}

/*ABCDEFGHIJKLMNOPQRSTUVWXYZ
ABCDEFGHIJKLMNOPQRSTUVWXY
ABCDEFGHIJKLMNOPQRSTUVWX
ABCDEFGHIJKLMNOPQRSTUVW
ABCDEFGHIJKLMNOPQRSTUV
ABCDEFGHIJKLMNOPQRSTU
ABCDEFGHIJKLMNOPQRST
ABCDEFGHIJKLMNOPQRS
ABCDEFGHIJKLMNOPQR
ABCDEFGHIJKLMNOPQ
ABCDEFGHIJKLMNOP
ABCDEFGHIJKLMNO
ABCDEFGHIJKLMN
ABCDEFGHIJKLM
ABCDEFGHIJKL
ABCDEFGHIJK
ABCDEFGHIJ
ABCDEFGHI
ABCDEFGH
ABCDEFG
ABCDEF
ABCDE
ABCD
ABC
AB
A*/
		
		
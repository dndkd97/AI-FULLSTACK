package com.the703.basic007;

public class For22Ex002 {

	public static void main(String[] args) {
		
	

		      char ch='\u0000';
	          for( ch='A'; ch<='Z'; ch++) {
	          for(char ch1='A'; ch1<=ch; ch1++) {
	          System.out.print(ch1);
	          }System.out.println();} 
	   
	          char ch2='A';
	          while(ch2<='Z') {
	          char  ch3='A';
	          while(ch3<=ch2) { 
	             System.out.print(ch3);  ch3++;
	          }System.out.println();    ch2++;   }
	          
	         char ch4='A';
	         do {char ch5='A';
	         do {  System.out.print(ch5); ch5++;
	            }while(ch5<=ch4);      ch4++;
	           System.out.println();   }while(ch4<='Z');
		}}

/*A
AB
ABC
ABCD
ABCDE
ABCDEF
ABCDEFG
ABCDEFGH
ABCDEFGHI
ABCDEFGHIJ
ABCDEFGHIJK
ABCDEFGHIJKL
ABCDEFGHIJKLM
ABCDEFGHIJKLMN
ABCDEFGHIJKLMNO
ABCDEFGHIJKLMNOP
ABCDEFGHIJKLMNOPQ
ABCDEFGHIJKLMNOPQR
ABCDEFGHIJKLMNOPQRS
ABCDEFGHIJKLMNOPQRST
ABCDEFGHIJKLMNOPQRSTU
ABCDEFGHIJKLMNOPQRSTUV
ABCDEFGHIJKLMNOPQRSTUVW
ABCDEFGHIJKLMNOPQRSTUVWX
ABCDEFGHIJKLMNOPQRSTUVWXY
ABCDEFGHIJKLMNOPQRSTUVWXYZ
	 * */


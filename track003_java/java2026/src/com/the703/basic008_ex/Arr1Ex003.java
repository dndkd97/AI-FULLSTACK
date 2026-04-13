package com.the703.basic008_ex;

public class Arr1Ex003 {

	public static void main(String[] args) {
		  //모음의 갯수
		char [] ch = new char[52];
		int cnt=0;
		
		
	           char ch1='a',ch2='A';
//	        for(int i=0; i<ch.length; i++) {
//		       if( ch1<='z') {ch[i]=ch1++;}
//          else if( ch2<='Z') {ch[i]=ch2++;} }
	          for(int i=0; i<ch.length/2; i++) { ch[i]=ch2++; ch[i+26]=ch1++;} 
	                                           
		        for(int i:ch) {
			    if( i=='a' || i=='e' || i=='i' || i=='o' || i=='u'||
			        i=='A' || i=='E' || i=='I' || i=='O' || i=='U') {cnt++;}}
		System.out.println("모음의 갯수:"+cnt); 
		
	}

}

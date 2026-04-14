package com.the703.basic008_ex;

public class ArrayNewEx002 {

	public static void main(String[] args) {
		char [] ch = new char[5];
		
		char ch1='A';
		for(int i=0; i<ch.length; i++) {ch[i]=ch1; ch1++;}
		for(int i=0; i<ch.length; i++) {System.out.print(ch[i]+" ");}

	}

}


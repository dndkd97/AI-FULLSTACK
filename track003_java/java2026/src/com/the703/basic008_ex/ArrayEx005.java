package com.the703.basic008_ex;

public class ArrayEx005 {

	public static void main(String[] args) {
		char [] ch = {'B','a','n','a','n','a'};
		
		int cnt=0, cnt1=0;
		for(int i:ch) {
			if (i<='Z' && i>='A') {cnt++;}
			else if(i<='z' && i>='a'){cnt1++;}}
		
		System.out.println("대문자의 갯수:"+cnt);
		System.out.println("소문자의 갯수:"+cnt1);

	}

}

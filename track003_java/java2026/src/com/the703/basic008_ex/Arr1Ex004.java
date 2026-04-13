package com.the703.basic008_ex;

public class Arr1Ex004 {

	public static void main(String[] args) {
		//대소문자 서로 바꿔서 출력
		char [] ch = {'B','a','n','a','n','a'};
		
		for(int i=0; i<ch.length; i++) {
			     if(ch[i]>='a' && ch[i]<='z') {ch[i]=(char)(ch[i]-32);}
			else if(ch[i]>='A' && ch[i]<='Z') {ch[i]=(char)(ch[i]+32);}
		   
			System.out.print((i==0?"[":"")+ ch[i]+ (i==5?"]":","));	}

	 
		
		
	}
}


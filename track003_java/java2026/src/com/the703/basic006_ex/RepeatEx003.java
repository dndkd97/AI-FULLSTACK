package com.the703.basic006_ex;

public class RepeatEx003 {

	public static void main(String[] args) {
		
		
		int total=0,total1=0,total2=0;
		int cnt=0, cnt1=0, cnt2=0;
		 System.out.println("1.for");
		for(int i=1; i<=30; i++){ if (i%2==0 && i%3==0)
	     {{System.out.println(++cnt+".3의 배수이면서 2의 배수인 숫자:"+i); total ++;}} }
	       System.out.println("갯수:"+total);
	     
	//////////////////  
		  System.out.println("2.while");
	     int i1=1;
	     while(i1<=30) { i1++;
	       if (i1%2==0 && i1%3==0) {System.out.println(++cnt1+".3의 배수이면서 2의 배수인 숫자:"+i1); total1++;}}
	      System.out.println("갯수:"+total1);
	     
	///////////////
	      System.out.println("3.dowhile");
	     int i2=1;
	     do {i2++; 
	     if (i2%2==0 && i2%3==0) {System.out.println(++cnt2+".3의 배수이면서 2의 배수인 숫자:"+i2); total2++;}}while(i2<=30);
	      System.out.println("갯수:"+total2);
	
	
	}
		  
		  
		  



	}



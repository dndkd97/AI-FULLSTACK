package com.the703.basic002_ex;

public class VarEx002 {

	public static void main(String[] args) {
		
		int a=10;
		
		int b=3;
		
		System.out.println(a+"+"+b+"="+(a+b));
		System.out.println(a+"-"+b+"="+(a-b));
		System.out.println(a+"*"+b+"="+(a*b));
		System.out.println(a+"/"+b+"="+(a/b));
		
		System.out.printf(a+"%s"+b+"%s"+(a+b)+"\n","+","=");
		System.out.printf(a+"%s"+b+"%s"+(a-b)+"\n","+","=");
		System.out.printf(a+"%s"+b+"%s"+(a*b)+"\n","+","=");
		System.out.printf(a+"%s"+b+"%s"+(a/b)+"\n","+","=");
		
		System.out.printf("%d+%d=%d\n",a,b,(a+b));
		System.out.printf("%d-%d=%d\n",a,b,(a-b));
		System.out.printf("%d*%d=%d\n",a,b,(a*b));
		System.out.printf("%d/%d=%d\n",a,b,(a/b));
		
	
				/* 10 + 3 = 13
			       10  - 3 = 7
			       10  * 3 = 30
			       10  / 3 = 3  */
		


	}

}

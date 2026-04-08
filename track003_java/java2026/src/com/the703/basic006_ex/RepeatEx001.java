package com.the703.basic006_ex;

public class RepeatEx001 {

	public static void main(String[] args) {
  	/*  1.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  1 2 3 4 5
		2.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  5 4 3 2 1
		3.  for , while , do while문을 이용해서 다음과 같이 출력하시오 :  JAVA1   JAVA2  JAVA3 */
		System.out.println("Q1-1. for");
		for(int i=1; i<=5; i++) {System.out.print(i);}
		
		System.out.println("\nQ1-2. while");
		int i=1;
		while(i<=5){System.out.print(i); i++;}
		
		System.out.println("\nQ1-3. do while");
		int i1=1;
		do {System.out.print(i1); i1++;}while(i1<=5);
	    ////////
		System.out.println("\nQ2-1. for");
		for(int i2=5; i2>=1; i2--) {System.out.print(i2);}

		System.out.println("\nQ2-2. while");
		int i2=5;
		while(i2>=1){System.out.print(i2); i2--;}
		
		System.out.println("\nQ2-3. do while");
		int i3=5;
		do {System.out.print(i3); i3--;}while(i3>=1);
		////////
		System.out.println("\nQ3-1. for");
		for(int i4=1; i4<=3; i4++) {System.out.print("JAVA"+i4+" ");}
		
		System.out.println("\nQ3-2. while");
		int i5=1;
		while(i5<=3){System.out.print("JAVA"+i5+" "); i5++;}
		
		System.out.println("\nQ3-3. do while");
		int i9=1;
		do {System.out.print("JAVA"+i9+" "); i9++;}while(i9<=3); 

	}

}

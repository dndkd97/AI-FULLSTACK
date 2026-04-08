package com.the703.basic006_ex;

public class RepeatEx002 {

	public static void main(String[] args) {
		/* for , while , do while 3가지 버젼으로 
		1~10까지 3의 배수의 합 : 18
		힌트)
		ver-1)
		1이  3의 배수라면  합을더해주변수에누적
		2가  3의 배수라면  합을더해주변수에누적
		3이  3의 배수라면  합을더해주변수에누적
		ver-2)
		if( 1이  3의 배수라면 ){ 합을더해주변수에누적 }
		if( 2가  3의 배수라면 ){ 합을더해주변수에누적 }
		if( 3이  3의 배수라면 ){ 합을더해주변수에누적 } */
		int total=0,total1=0,total2=0;
		
		System.out.print("Q1. for) 1~10까지 3의 배수의 합:");
		for(int i=3; i<=10; i=i+3) {total +=i;} System.out.print(total);
			
		System.out.print("\nQ2. while) 1~10까지 3의 배수의 합:");
		int i1=0;
		while(i1<=10) { i1++; if( i1%3==0 ){total1 +=i1;}} System.out.print(+total1);
		
		System.out.print("\nQ2. dowhile) 1~10까지 3의 배수의 합:");
		int i2=0;
		do {i2++;if (i2%3==0) {total2 += i2;}}while(i2<=10);System.out.println(total2);

	}

}

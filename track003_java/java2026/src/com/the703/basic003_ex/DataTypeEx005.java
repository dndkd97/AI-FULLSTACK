package com.the703.basic003_ex;

import java.util.Scanner;

public class DataTypeEx005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
	int kor,eng,math,total;
	double avg=0;
	System.out.println("국어 점수를 입력하시오"); kor = sc.nextInt();
	System.out.println("영어 점수를 입력하시오"); eng = sc.nextInt();
	System.out.println("수학 점수를 입력하시오"); math = sc.nextInt();
	//avg = (double)(kor+eng+math)/3; 
	total = kor+eng+math;
	avg = total/3.0; // avg = total/3f;
	
	System.out.printf("총점:%s\n평균은:%.2f",total,avg);
	System.out.println("총점:"+total+"\n"+"평균:"+avg);
	System.out.print("총점:"+total+"\n"+"평균:"+avg);
			
		
	}

}

 /*Scanner sc = new Scanner(System.in);
double kor,eng,math;
double a;

System.out.println("국어 점수를 입력하시오"); kor = sc.nextDouble();
System.out.println("영어 점수를 입력하시오"); eng = sc.nextDouble();
System.out.println("수학 점수를 입력하시오"); math = sc.nextDouble();

a = (kor+eng+math)/3; 
System.out.printf("총점은"+(int)(kor+eng+math)+"평균은 %.2f",a);
*/
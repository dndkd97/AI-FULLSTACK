package com.the703.basic006_ex;

import java.util.Scanner;

public class ForIn001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int kor=-1,eng=-1,math=-1,total=0;
		double avg;
		String result,level,best,id;
		
		System.out.println("학번 입력"); id = sc.next();
		
		for(;;) {
			if(kor<0 || kor>100) {System.out.println("국어 점수 입력");kor = sc.nextInt();continue;}
			if(eng<0 || eng>100){System.out.println("영어 점수 입력");eng = sc.nextInt();continue;}
			if(math<0 || math>100) {System.out.println("수학 점수 입력");math = sc.nextInt();continue;}
			break;}
		
		total=kor+eng+math;
	    avg=(double)total/3;
		result = avg>=60 && kor>40 && eng>40 && math>40?"합격":"불합격";
		best = avg>=95?"장학생":"";
		level = avg>=90?"수": avg>=80?"우": avg>=70?"미": avg>=60?"양":"가";
		
		System.out.println("=====================================================================");
	    System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생");
	    System.out.println("=====================================================================");
	    System.out.printf("%s\t %d\t%d\t%d\t %d\t%.2f\t%s\t%s\t%s\t",
	    		            id,  kor,  eng, math,total, avg, result,level,best);
	}}

		

/*for(;;) {   
    {{System.out.println("국어 점수 입력");kor = sc.nextInt();}}
    {System.out.println("영어 점수 입력");eng = sc.nextInt();}
    {System.out.println("수학 점수 입력");math = sc.nextInt();}
    
if( kor>0 &&kor<=100 && eng>0 && eng<=100 && math>0 && math<=100)break;}
*/
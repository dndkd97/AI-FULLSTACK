package com.the703.basic005_ex;

import java.util.Scanner;

public class IfEx008 {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		int kor,eng,math,total;
		String  result="불합격",id,a,b="";
		double avg;
		
		System.out.print("학번입력"); id = sc.next(); 
		System.out.print("국어 점수 입력"); kor = sc.nextInt();
		System.out.print("수학 점수 입력"); math = sc.nextInt();
		System.out.print("영어 점수 입력"); eng = sc.nextInt();
		
		total = (kor+eng+math);
		avg = (double)total/3;
		// if (avg>=60 && kor>40 && eng >40 && math>40) {result="합격";} 
		
	 //	result =avg>=60 && kor>40 && eng >40 && math>40? "합격": "불합격";
		
 		result = avg<60?"불합격":(kor>=40 && eng >=40 && math>= 40)?"합격":"불합격";
		
		/* if(avg>=90 ) {a="수";}
		else if(avg>=80 && avg>90) {a="우";}
		else if(avg>=70 && avg>80) {a="미";}
		else if(avg>=60 && avg>70) {a="양";}
		else {a="가";} */
		
		a= (avg>=90)?"수": (avg>=80)?"우": (avg>=70)?"미": (avg>=60)?"양":"가"; 
		
	     //if (avg>=95) {b="장학생" ;}
		
		b= (avg>=95)? "장학생": " ";
	    
	    
		System.out.println("==================================================================== ");
		System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생");
		System.out.println("==================================================================== ");
		System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s",id,kor,eng,math,total,avg,result,a,b);
	
		
		
		
		
		
		
		

	}

}
/* 1. 총점 구하기
2. 평균 구하기
3. 평균이 60점이상이고  각과목이 40점 미만이면 아니라면 합격/ 아니면 불합격
4. 평균이 95점이상이면 장학생
5. 평균이  90점이상이면 수, 80점이상이면 우, 70점이상이면 미, 60점이상이면 양, 아니라면 가 

학번 입력 > std111
국어점수 입력 > 100
수학점수 입력 > 100
영어점수 입력 > 99
============================================= 
학번   국어   영어   수학   총점   평균   합격여부   레벨   장학생
============================================= 
std111   100   100   99   299   99.67   합격   수   장학생 */
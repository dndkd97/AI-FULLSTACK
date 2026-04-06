package com.the703.days;
import java.util.Scanner;
public class Day008 {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	int kor,eng,math,total;
	double avg;
	String result,best,level,id;
	
	System.out.println("id 입력"); id = sc.next();
	

	System.out.println("국어 점수 입력"); kor = sc.nextInt();
	System.out.println("영어 점수 입력"); eng = sc.nextInt();
	System.out.println("수학 점수 입력"); math = sc.nextInt();
	total = kor+eng+math; //1.총점구하기
	avg = (double)total/3; //2.평균 구하기
    result=	avg>=60 && kor >=40 && eng >=40 && math>=40?"합격":"불합격"; //3.평균이 60점 이상이고 각과목이 40점 미만이 아니라면 합격/아니면 불합격
    best = avg>=95? "장학생":" "; //4.평균이 95점 이상이면 장학생
    level = avg>=90?"수":avg>=80?"우":avg>=70?"미":avg>=60?"양":"가";//5.평점이 90>=수 80>=우 70>=미 60>=양 60<가
    System.out.println("=====================================================================");
    System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생");
    System.out.println("=====================================================================");
    System.out.printf("%s\t %d\t%d\t%d\t %d\t%.2f\t%s\t%s\t%s\t",
    		            id,  kor,  eng, math,total, avg, result,level,best);
	
	
	
	}}
	

    
    /* 3.필수조건
     q1-1. int형 변수 x가 60이상일때 조건식 : (x>=60)
     q1-2. char형 변수 ch가 'a' 또는 'A'일때 true인 조건식: (ch == 'a' || ch == 'A')
     q1-3. char형 변수 ch가 숫자('0'~'9')일때 조건식: (ch >= '0' && ch <= '9')
     q1-4. char형 변수 ch가 영문자(대문자)일때 조건식 : (ch >= 'A' && ch <= 'Z')  
     for(;;) {
	System.out.println("국어 점수 입력"); kor = sc.nextInt();
	System.out.println("영어 점수 입력"); eng = sc.nextInt();
	System.out.println("수학 점수 입력"); math = sc.nextInt();
	total = kor+eng+math; //1.총점구하기
	avg = (double)total/3; //2.평균 구하기
    result=	avg>=60 && kor >=40 && eng >=40 && math>=40?"합격":"불합격"; //3.평균이 60점 이상이고 각과목이 40점 미만이 아니라면 합격/아니면 불합격
    best = avg>=95? "장학생":" "; //4.평균이 95점 이상이면 장학생
    level = avg>=90?"수":avg>=80?"우":avg>=70?"미":avg>=60?"양":"가";//5.평점이 90>=수 80>=우 70>=미 60>=양 60<가
	if( (kor >0 && kor<=100) && (eng >0 && eng<=100) && (math >0 && math<=100)) {System.out.printf("%s\t %d\t%d\t%d\t %d\t%.2f\t%s\t%s\t%s\t",
            id,  kor,  eng, math,total, avg, result,level,best);}break;
    
     
    total = kor+eng+math; //1.총점구하기
	avg = (double)total/3; //2.평균 구하기
    result=	avg>=60 && kor >=40 && eng >=40 && math>=40?"합격":"불합격"; //3.평균이 60점 이상이고 각과목이 40점 미만이 아니라면 합격/아니면 불합격
    best = avg>=95? "장학생":" "; //4.평균이 95점 이상이면 장학생
    level = avg>=90?"수":avg>=80?"우":avg>=70?"미":avg>=60?"양":"가";//5.평점이 90>=수 80>=우 70>=미 60>=양 60<가
    
    System.out.println("=====================================================================");
    System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생");
    System.out.println("=====================================================================");
    System.out.printf("%s\t %d\t%d\t%d\t %d\t%.2f\t%s\t%s\t%s\t",
    		            id,  kor,  eng, math,total, avg, result,level,best);
     
     
      */



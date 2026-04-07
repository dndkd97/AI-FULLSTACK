package com.the703.basic006_ex;

import java.util.Scanner;

public class ForIn001 {

	public static void main(String[] args) {
		//변수
		//자료형:기본형/참조형(String)
		//기본형-정수 byte<short<int<long / 실수-float<double/boolean빼고 타입형변환가능
		Scanner sc = new Scanner(System.in);
		int kor=-1,eng=-1,math=-1,total=0;
		double avg;
		String result,level,best="",id;
		
		//문자열:next() / 정수형(10):nextInt() / 실수형(1.23):nextDouble() / 문자:next().charAt(0)
		System.out.println("학번 입력"); id = sc.next();
		//연산자 먼저() 값(++,--,산술) 비교 ( <,>) 조건(&& || 삼항) 대입(=)
		//제어문 (#if/#switch) 반복(#for/while/do while)
		for(;;) {
			if(kor<0 || kor>100) {System.out.println("국어 점수 입력");kor = sc.nextInt();continue;}
			if(!(eng>=0 && eng<=100)){System.out.println("영어 점수 입력");eng = sc.nextInt();continue;}
			if(math<0 || math>100) {System.out.println("수학 점수 입력");math = sc.nextInt();continue;}
			break;}
		
		total=kor+eng+math; //총점구하기
	    avg=total/3.0; //평균구하기(강제형변환) 정수/실수
		result = avg<60?"불합격":kor<40 || eng<40 || math<40?"불합격":"합격";
		if(avg>=95) {best="장학생";}
		level = avg>=90?"수": avg>=80?"우": avg>=70?"미": avg>=60?"양":"가";
		/*switch((int)avg/10){
		 * case 10: case9: lever="수";break;
		 * case 8:lever="우";break;
		 * case 7:lever="미";break;
		 * case 6:lever="양";break;
		 * default :lever= "가"break;
		 */
		
		System.out.println("=====================================================================");
	    System.out.println("학번\t국어\t영어\t수학\t총점\t평균\t합격여부\t레벨\t장학생");
	    System.out.println("=====================================================================");
	    System.out.printf("%s\t %d\t%d\t%d\t %d\t%.2f\t%s\t%s\t%s\t",
	    		            id,  kor,  eng, math,total, avg, result,level,best);
	}}

/*for(;;) {System.out.println("국어 점수 입력>")kor= sc.nextInt(); if(kor>=0 && kor<=100){break;}} */

/*for(; kor>=0 && kor<=100;) { System.out.println("국어점수입력>");}*/
/*for(;;){  if(kor<0 || kor>100) {System.out.println("국어 점수 입력");kor = sc.nextInt();}
	else if(!(eng>=0 && eng<=100)){System.out.println("영어 점수 입력");eng = sc.nextInt();}
	else if(math<0 || math>100) {System.out.println("수학 점수 입력");math = sc.nextInt();}
	else {break;}}
 * 
 *  */

/*for(;;) {   
    {{System.out.println("국어 점수 입력");kor = sc.nextInt();}}
    {System.out.println("영어 점수 입력");eng = sc.nextInt();}
    {System.out.println("수학 점수 입력");math = sc.nextInt();}
    
if( kor>0 &&kor<=100 && eng>0 && eng<=100 && math>0 && math<=100)break;}
*/
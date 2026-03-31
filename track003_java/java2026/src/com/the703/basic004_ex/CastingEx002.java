package com.the703.basic004_ex;
import java.util.Scanner;
public class CastingEx002 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		 int kor, eng, mat,total,level;
	     double avg;
	     System.out.println("국어점수 입력>"); kor = sc.nextInt();
	     System.out.println("영어점수 입력>"); eng = sc.nextInt();
	     System.out.println("수학점수 입력>"); mat = sc.nextInt();
	     
	     total=(kor+eng+mat);
	     
	     avg = (double)total/3;
	     level= (int)avg/10;

	     System.out.println("::::::::::::::::::::::::");
	     System.out.println("::GOOD IT SCORE::");
	     System.out.println("::::::::::::::::::::::::");
	     System.out.println("국어 영어 수학 총점 평균 레벨");
	     System.out.printf("%d %d %d %d %.2f %d",kor,eng,mat,total,avg,level);


	}

}

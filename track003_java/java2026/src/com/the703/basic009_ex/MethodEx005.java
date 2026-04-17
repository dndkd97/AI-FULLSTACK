package com.the703.basic009_ex;

import java.util.Scanner;

public class MethodEx005 {
	
	 public static int process_total(int kor, int eng, int math) {return kor+eng+math;}
     public static float process_avg(int num) {return (float)num/3;}
     public static String process_pass(float avg,int kor, int eng, int math) {return avg>=60?"합격":
             kor>=40 || eng>=40 || math>=40?"불합격":"재시험";}
     public static String process_scholar (float avg ) {return avg>=95?"장학생":" ";}
     public static String process_star (float avg) {String result=""; for(int i=1; i<=avg/10; i++) {result+="★";}return result;}
     public static void process_show(String name, int kor, int eng, int math,int total, float avg, String pass, String jang, String star)
                                            { System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\t%s\t%s\t%s\n",
                                                   name, kor, eng, math, total, avg, pass, jang, star); }
    public static void main(String[] args) {
        /////////////////////(1)  변수
       //변수+입력 (같은자료형을 연속된 공간 저장)
       String[] name={"아이언맨","헐크","캡틴","토르","호크아이"};
        int[] kor={100,20,90,70,35}; //kor 5:0~4   
        int[] eng={100,50,95,80,100};//공간빌려오기 동시에 초기화
        int[] math={100,30,90,60,100};
        int[] aver=new int[5];       //공간빌려오기 - 들어갈데이터를 모를경우
       
          /////////////////////(3) 처리 : 
     //     total = process_total(kor , eng, math);// 1. 총점처리
        int [] total =new int [5];

      //    avg = process_avg(total);    //2.  평균처리
        float [] avg = new float [5];
      
          ////////3.  합격  평균이60이상이고, 각각 국어, 영어, 수학40이상/불합격/재시험-각각 40미만인게 있다면  
       //   pass = process_pass(avg , kor, eng, math);  
        String [] pass = new String[5];
        
          //////// 4. 평균이 95점이상이면 장학생
       //   jang = process_scholar(  avg  ); 
        String [] jang = new String[5];
          
          //////// 5. 평균점수대로 별표 붙이기 , 예) 70점대이면 별7개, 80점대이면 별8개, 90점대이면 별9개 , 100점이면 별10개 
      //    star = process_star(avg);  
          String [] star = new String [5];
          
          /////////////////////(4) 출력
      //    process_show(name, kor, eng, math, total, avg, pass, jang, star);
          
          for(int i=0; i<kor.length; i++) {
             total[i]=process_total(kor[i],eng[i],math[i]);
             avg[i]=process_avg(total[i]);
             pass[i]=process_pass(avg[i],kor[i],eng[i],math[i]);
             jang[i]=process_scholar(avg[i]);
             star[i]=process_star(avg[i]);
          }
          
          System.out.println(" ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: ");
          System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t합격여부\t장학생\t랭킹");
          System.out.println("--------------------------------------------------------------------------------------------");
         for(int i=0; i<kor.length; i++) {
            process_show(name[i],kor[i],eng[i],math[i],total[i],avg[i],pass[i],jang[i],star[i]);}
          System.out.println("--------------------------------------------------------------------------------------------");
          
	    
	      
	   }// end main
	 
	   
	}// end class

	 
	



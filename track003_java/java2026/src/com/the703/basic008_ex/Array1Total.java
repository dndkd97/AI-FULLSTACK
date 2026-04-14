package com.the703.basic008_ex;

import java.util.Arrays;

public class Array1Total {

	public static void main(String[] args) {
		//변수+입력 (같은자료형을 연속된 공간 저장)
		String[] name={"아이언맨","헐크","캡틴","토르","호크아이"};
	    int[] kor={100,20,90,70,35}; //kor 5:0~4   
	    int[] eng={100,50,95,80,100};//공간빌려오기 동시에 초기화
	    int[] mat={100,30,90,60,100};
	    int[] aver=new int[5];       //공간빌려오기 - 들어갈데이터를 모를경우
	    
	    
	    //처리
	    /*1.평균 구하시오. 평균(국어+영어+수학)/3
	     *           아이언맨 평균 = (아이언맨의 국어 + 아이언맨의 영어 + 아이언맨의 수학)/3
	     *2.합격,불합격 - 평균이 60점 이상이면 합격, 아니면 불합격으로 처리하시오.
	     *3.장학생 - 평균 95점 이상이면 장학생으로 처리하시오.
	     * */
	    
        //1.평균 구하기
	    for(int i=0; i<aver.length; i++) {
	    	 aver[i]= (kor[i]+eng[i]+mat[i])/3; }
	    
	   System.out.println(":::::::::::::::::::::::::::::::::::::::::");
	   System.out.println("이름\t국어\t영어\t수학\t평균\t합격여부\t장학생\t");
	   System.out.println(":::::::::::::::::::::::::::::::::::::::::");
	   
	       for(int i=0; i<=4; i++) {
		   System.out.println(name[i]+"\t"+kor[i]+"\t"+eng[i]+"\t"+mat[i]+"\t"+aver[i]+"\t"+
				                (aver[i]>=60?"합격":"불합격")+"\t"+ (aver[i]>=95?"장학생":"--- "));
	   
	   }System.out.println(":::::::::::::::::::::::::::::::::::::::::");
	
	   
	   
	    
	}

}

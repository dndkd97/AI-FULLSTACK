package com.the703.basic008_ex;

import java.util.Arrays;

public class Array2Ex004 {

	public static void main(String[] args) {
		int [] [] datas = {  {  10, 10, 10 ,10},             
                             {  20, 20, 20 ,20},     
                             {  30, 30, 30 ,30},     
                                                 };  // 3층 4칸 

		        int [] [] result = new int[datas.length+1][datas[0].length+1];    
		        int num=0,num1=0,total=0;
		       
		    for(int i=0; i<datas.length; i++) {num=0; //가로열 합 초기화(첫번째 가로열 합산 후 초기화 후 다음줄 합산)
			for(int a=0; a<datas[i].length; a++) {
				result[i][a]=datas[i][a];//배열 복사
				num+=result[i][a];//가로열 합
				total+=result[i][a];//가로합 누적합산
				System.out.print(result[i][a]+"\t");//배열 출력
			   }System.out.println(num); }//가로열 합 출력
			
		    for(int i=0; i<result.length; i++) {num1=0; //세로열 합 초기화((첫번째 세로열 합산 후 초기화 후 다음줄 합산)
			for(int a=0; a<result.length; a++) {
				num1+=result[a][i];//세로열 합
			    }System.out.print(num1+"\t");}//세로열 합
		         System.out.print(total);//가로열 누적합산 출력
		     
		     
		}
	}


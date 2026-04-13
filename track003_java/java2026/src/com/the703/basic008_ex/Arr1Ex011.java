package com.the703.basic008_ex;

import java.util.Arrays;

public class Arr1Ex011 {

	public static void main(String[] args) {
		
		
		
		int [] lotto = new int[6];
		
		   for(int i=0; i<lotto.length; i++) {
			lotto[i]=(int)(Math.random()*45)+1;//1~45 출력
			for(int a=0; a<i; a++) {
				if(lotto[i]==lotto[a]) {i--; break;} //중복체크 코드
			}
		}  Arrays.sort(lotto); //오름차순으로 정렬
		   System.out.print(Arrays.toString(lotto));  
		
		/*  for (int i = 0; i < lotto.length; i++) {
	         lotto[i] = (int)(Math.random()*45)+1;
	         int j = 0;
	         while (j < lotto.length) {
	           if(i!=j && lotto[i] == lotto[j]) {
	              lotto[i] = (int)(Math.random()*45)+1;
	               j = 0; // 중복일때 j를 초기화→다시검사
	               System.out.println(j);
	            }
	            j++;
	         }
	      }
	      System.out.println(Arrays.toString(lotto));  */
	   
	

	}

}

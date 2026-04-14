package com.the703.basic008_ex;

import java.util.Arrays;

public class Array2Total {

	public static void main(String[] args) {
		String[] name={"아이언맨","헐크","캡틴","토르","호크아이"};
	    int[] kor={100,20,90,70,35};   
	    int[] eng={100,50,95,80,100};
	    int[] mat={100,30,90,60,100};
	    int[] aver=new int[5];
	    int [] rank = new int[5];
	    
	    for(int i=0; i<aver.length; i++) {aver[i]= (kor[i]+eng[i]+mat[i])/3;}
	 
	    for(int i=0; i<aver.length; i++) {
	    	rank[i]=1;
	    	for(int a=0; a<aver.length; a++) {
	    		if(aver[i]<aver[a]) {rank[i]++;}
	    	}
	    }
	    
	       System.out.println(":::::::::::::::::::::::::::::::::::::::::");
		   System.out.println("이름\t국어\t영어\t수학\t평균\t등수\t합격여부\t장학생\t랭킹\t");
		   System.out.println(":::::::::::::::::::::::::::::::::::::::::");
		   
	    for(int i=0; i<=4; i++) {
			   System.out.print(name[i]+"\t"+kor[i]+"\t"+eng[i]+"\t"+mat[i]+"\t"+aver[i]+"\t"+rank[i]+"\t"+
	    (rank[i]==3?"재시험": (aver[i]>=60?"합격":"불합격"))+"\t"+ (aver[i]>=95?"장학생":" ")+"\t");
			   for(int a=0; a<aver[i]/10; a++) {System.out.print("*");}System.out.println();
	    }
	    
	    

	}

}

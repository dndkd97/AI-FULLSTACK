package com.the703.basic008_ex;

import java.util.Arrays;

public class Arr1Ex012 {

	public static void main(String[] args) {
		//int [] birth= {1990,01,01};
		int [] total = {738462};
		int [] day = new int [30];
	   char [] week = {'일','월','화','수','목','금','토'};	
	   int day3=0;
	   
            int i1=1;
		for(int i=0; i<day.length; i++) {day[i]=i1++;}
		//	System.out.print(Arrays.toString(day));
		
			for(int i=0; i<week.length; i++) {System.out.print(week[i]+"\t");}System.out.println();
			System.out.print("\t\t");
		     for(int i=0; i<day.length; i++) {System.out.print(day[i]+"\t");}
		     
			
	}

}

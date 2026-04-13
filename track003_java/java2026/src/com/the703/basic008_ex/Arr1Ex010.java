package com.the703.basic008_ex;

import java.util.Arrays;

public class Arr1Ex010 {

	public static void main(String[] args) {
		int [] datas = {1,3,1,1,4,4,3,1,4,1,2};
		int [] stars = new int[4];
		
		
		for(int i=0; i<datas.length; i++) {stars[datas[i]-1]++;}
		System.out.println(Arrays.toString(stars));
		
		for(int i=0; i<stars.length; i++) {
			for(int a=0; a<stars[i]; a++) {
				System.out.print("*");
			   }System.out.println();
		}
		}
		}
		

/*	stars[datas[0]-1]++;
stars[datas[1]-1]++;
stars[datas[2]-1]++;
stars[datas[3]-1]++;
stars[datas[4]-1]++;
stars[datas[5]-1]++;
stars[datas[6]-1]++;
stars[datas[7]-1]++;
stars[datas[8]-1]++;
stars[datas[9]-1]++;
stars[datas[10]-1]++; */


/*	for(int i=0; i<datas.length; i++) {stars[datas[i]-1]++;}
//for(int i=0; i<stars.length; i++) {System.out.print((i==0?"[":",")+stars[i]+(i==3?"]":""));
//                                }System.out.println();
  System.out.println(Arrays.toString(stars));
for(int i=0; i<stars.length; i++) {
for(int a=0; a<stars[i]; a++) {System.out.print("*");}System.out.println();}  */

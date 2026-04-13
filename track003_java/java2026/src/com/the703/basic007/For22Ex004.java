package com.the703.basic007;

public class For22Ex004 {

	public static void main(String[] args) {
		/*1~10,11~20합*/
		
		   for(int i=1; i<=100; i+=10) {int total=0;
           for(int i1=i; i1<=i+9; i1++) {
              System.out.print(i1+((i1%10)==0?"=":"+")); total+=i1;
           }System.out.println(total);total=0; } 
 
              int i2=1;
          while(i2<=100) { int total1=0;
          int i3=i2;
          while(i3<=i2+9) {
          System.out.print(i3+((i3%10)==0?"=":"+"));total1+=i3;  i3++;
         }System.out.println(total1);    i2+=10; total1=0;   } 

         int i4=1;
         do { int i5=i4; int total2=0;
         do{System.out.print(i5+((i5%10)==0?"=":"+")); total2+=i5; i5++;
         }while(i5<=i4+9); System.out.println(total2); total2=0; i4+=10;
         }while(i4<=100);
			               
			              
			  
		
			
			                                     
			
		}
	}
package com.the703.basic007;

public class For22Ex006 {

	public static void main(String[] args) {
		
		/*2~4단*/
		
		      for(int i=2; i<=4; i++) {
              for(int i1=1; i1<=9; i1++) { System.out.println(i+"*"+i1+"="+i*i1);
              }System.out.println();  }
     
              int i2=2;
         while(i2<=4) { int i3=1;
         while(i3<=9) {
           System.out.println(i2+"*"+i3+"="+i2*i3);i3++;   
          }System.out.println();  i2++;}  
     
             int i4=2;
         do {int i5=1;
         do {System.out.println(i4+"*"+i5+"="+i4*i5);
         i5++; }while(i5<=9);
             System.out.println();   i4++;
             }while(i4<=4);
     
    

	}

}

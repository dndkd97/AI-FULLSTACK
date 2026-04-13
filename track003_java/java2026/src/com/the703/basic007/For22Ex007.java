package com.the703.basic007;

public class For22Ex007 {

	public static void main(String[] args) {
		/* 다중 for문으로 
		 * 2*1=2	3*1=3	4*1=4	
           2*2=4	3*2=6	4*2=8	
           2*3=6	3*3=9	4*3=12	

           5*1=5	6*1=6	7*1=7	
           5*2=10	6*2=12	7*2=14	
           5*3=15	6*3=18	7*3=21	

           8*1=8	9*1=9	
           8*2=16	9*2=18	
           8*3=24	9*3=27	

		 * */
		
		
		     for(int i=2; i<=9; i+=3) {
             for(int i1=1; i1<=3; i1++) {
             for(int i2=i; i2<i+3 &&i2<=9; i2++) {
                  System.out.print(i2+"*"+i1+"="+i2*i1+"\t");
                 }System.out.println();
                 }System.out.println();   }
   
                int a=2; 
             while(a<=9) {int a1=1;
             while(a1<=3) { int a2=a;
             while(a2<a+3 && a2<=9) {
                System.out.print(a2+"*"+a1+"="+a2*a1+"\t"); a2++;
               }System.out.println();a1++;
               }System.out.println();a+=3; } 
   
   
                         int b=2;
                    do { int b1=1;
                    do { int b2=b;
                    do {   System.out.print(b2+"*"+b1+"="+b1*b2+"\t"); b2++;
                   }while(b2<b+3 &&b2<=9);b1++;System.out.println();
                   }while(b1<=3); b+=3;System.out.println();
                   }while(b<=9);
                    
                    

	}

}

package com.the703.basic007;

public class For22Ex009 {

	public static void main(String[] args) {
		/*
		 * 1 2 3 4 5 
           10 9 8 7 6 
           11 12 13 14 15 
           20 19 18 17 16 
           21 22 23 24 25 
		 * */
		
		   for(int i=1; i<=25; i+=5) { int temp = i+4;
           for(int i1=i; i1<=i+4; i1++) {
                         if(i%2==1) {System.out.print(i1+" ");} 
                       else         {System.out.print(temp--+" ");}             
                                    }System.out.println();}
		   
           int a=1;
            while(a<=25) {int a1=a; int temp1 = a+4;
            while(a1<=a+4) {
               if(a%2==1) {System.out.print(a1+" ");} 
               else       {System.out.print(temp1--+" ");}  a1++;
                          }System.out.println();a+=5;  } 
    
            int b=1;
             do { int b1=b; int temp2 = b+4;
             do {
             if(b%2==1) {System.out.print(b1+" ");} 
             else         {System.out.print(temp2--+" ");}      b1++;
              }while(b1<=b+4); 
               b+=5;System.out.println();
              }while(b<=25);
          

	}

}

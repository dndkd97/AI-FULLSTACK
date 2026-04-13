package com.the703.basic007;

public class For22Ex008 {

	public static void main(String[] args) {
		
		/*
		 * #####
            ### 
             #  
            ### 
           #####
		 * */
		
            for(int i=1; i<=5; i++) {
            for(int i1=1; i1<=5; i1++) {
           if((i==2 || i==4) && (i1==1 || i1==5)) {System.out.print(" ");}
           else if(i==3 && (i1==1 || i1==2 || i1==4 || i1==5)){System.out.print(" ");}
           else {System.out.print("#");}
                 }System.out.println(); }  

           int a=1;
          while(a<=5) {int a1=1;
          while(a1<=5) { if((a==2 || a==4) && (a1==1 || a1==5)) {System.out.print(" ");}
            else if(a==3 && (a1==1 || a1==2 || a1==4 || a1==5)){System.out.print(" ");}
            else {System.out.print("#");} a1++;
                 }System.out.println(); a++;} 

           int b=1;
         do{ int b1=1;
         do{ if((b==2 || b==4) && (b1==1 || b1==5)) {System.out.print(" ");}
             else if(b==3 && (b1==1 || b1==2 || b1==4 || b1==5)){System.out.print(" ");}
             else {System.out.print("#");}
             b1++;}while(b1<=5);System.out.println();b++;
                 }while(b<=5);


	}

}

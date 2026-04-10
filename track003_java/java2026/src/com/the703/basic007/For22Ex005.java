package com.the703.basic007;

public class For22Ex005 {

	public static void main(String[] args) {
		
		         int total=0;
	          for(int i=10; i<=100; i+=10) {
	    	  for(int a=1; a<=i; a++){
	    		   System.out.print(a+ ((a%10)==0?"=":"+" )); total+=a; }
	    		   System.out.println(total); total=0; } 
		
	 /*	int i=10;
		while(i<=100) {int a=1;  int total=0;
			while(a<=i) {  
				System.out.print(a+((a%10)==0?"=":"+")); a++; 
				total+=a; i+=10;
			}System.out.println(total); total=0;}*/
			
		
		
	    	 
	}	   
	    	  
	     

}

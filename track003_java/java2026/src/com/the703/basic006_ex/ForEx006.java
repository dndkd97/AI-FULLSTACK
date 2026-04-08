package com.the703.basic006_ex;
import java.util.Scanner;
public class ForEx006 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num1,num2,xl,xs;
		int total=0;
		         System.out.println("숫자1개 입력");num1 = sc.nextInt();
		         System.out.println("숫자1개 입력");num2 = sc.nextInt();
		         
		        
		                  if(num1>num2) {xl=num1; xs=num2;}
		                  else          {xl=num2; xs=num1;}
		                  
		                  for(int i=xl; xs<=i; i--) 
		                  {total +=i;
		                  if(i==xs) { System.out.print(i);}
		                  else      { System.out.print(i+"+");}}
		                  System.out.print("="+(total)); 
          
		        	 }
	}          

/*if( num2 < num1) 
{ for(int i=num2; num1>i; i++) 
{ total += i;
  System.out.print(i+"+");}
  System.out.println(num1+"="+(total+num1));} 

if( num1 < num2 )  
{ for(int i=num1; num2>i; i++) 
{ total += i;
  System.out.print(i+"+");   }   
  System.out.println(num2+"="+(total+num2));}   */
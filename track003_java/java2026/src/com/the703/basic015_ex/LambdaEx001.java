package com.the703.basic015_ex;

interface Printer { void print(String msg); }

interface Calculator { int add(int a, int b); }

public class LambdaEx001 {
	public static void main(String[] args) {
		Printer p1 = new Printer() { @Override public void print(String msg) {System.out.println(msg); } };
	//	Printer p2 = new Printer() { @Override public void print(String msg) {System.out.println(msg); } };
		Printer p2 = msg->System.out.println(msg);
		
		Calculator c1 = new Calculator() { @Override public int add(int a, int b) {  return a+b; }};
        Calculator c2 = (a,b)->a+b;
        
		  p1.print("Hello World");
          p2.print("Lambda Rocks!");

            System.out.println("익명객체 결과: " + c1.add(3, 5)); 
            System.out.println("람다식 결과: " + c2.add(10, 20));

	}

}

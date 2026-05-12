package com.the703.basic018;

class Animal{String name;}
class Dog extends Animal implements Runnable{//1) extends Thread

	@Override
	public void run() {//2)해야할일
		for(int i=0; i<5; i++) {System.out.println("멍");
		try { Thread.sleep(1000); } catch (InterruptedException e) {  e.printStackTrace(); }
		}	
	} 	
}

public class Thread003_Runnable {
	public static void main(String[] args) {
		Thread dog = new Thread(new Dog()); dog.start();
		for(int i=0; i<5; i++) {System.out.print("◖⚆ᴥ⚆◗");
		try { Thread.sleep(1000); } catch (InterruptedException e) {  e.printStackTrace(); }
		}	
	}
}
// ◖⚆ᴥ⚆◗ 
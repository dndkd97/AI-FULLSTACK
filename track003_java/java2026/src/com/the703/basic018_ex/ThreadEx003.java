package com.the703.basic018_ex;
import javax.swing.JOptionPane;

//class Count extends Thread{
//
//	@Override public void run() { for(int i=10; i>0; i--) {
//		System.out.println(i); try {
//		Thread.sleep(1000); } catch (InterruptedException e) {  break; }
//	} }	
//}
class Count extends Thread{

	@Override public void run() { for(int i=10; i>0; i--) {
		if(Thread.currentThread().isInterrupted()) {break;}
		System.out.println(i);
		try { Thread.sleep(1000); } catch (InterruptedException e) { break; }}
	
} }	
public class ThreadEx003 {
	public static void main(String[] args) {
		 Thread count = new Count();
	        count.start();
	       
	        String answer = JOptionPane.showInputDialog("count stop? y/n");
	        if(answer.toLowerCase().equals("y")) {System.out.println("count를 멈춥니다"); count.interrupt();}
	        System.out.println("> main end....");
	}
}

package com.the703.basic018_ex;

import javax.swing.JOptionPane;

class cnt extends Thread{

	@Override
	public void run() {
//		try { Thread.sleep(10); } catch (InterruptedException e) {  e.printStackTrace(); }
		for(int i=10; i>0; i--) {System.out.println(i); try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {  System.out.println("종료"); return; }}
	}	
} 

public class ThreadEx001 {
	public static void main(String[] args) {
		Thread cntt = new cnt(); cntt.start();
		String answer = JOptionPane.showInputDialog("사과 알파벳을 입력하세요.");
		System.out.println(answer);
		if(answer.equals("apple")) {System.out.println("정답입니다"); cntt.interrupt();}
		//  System.out.println(answer.toLowerCase().equals("apple")?"정답":"오답");// -> 다 소문자로 
		else {System.out.println("정답이아니다");}

	}

}

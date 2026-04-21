package com.the703.basic010_ex;

import java.util.Scanner;


class Card{
	int cardNum; boolean  isMembership; 
	
//	public Card() { super();  }
//	public Card(int cardNum, boolean isMembership) { super(); this.cardNum = cardNum; this.isMembership = isMembership; }
	@Override public String toString() { return "Card [cardNum=" + cardNum + ", isMembership=" + isMembership + "]"; }

	void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("채널 입력>"); cardNum = sc.nextInt();
		System.out.println("볼륨 입력>"); isMembership = sc.nextBoolean();
	}
	void show() {
		System.out.println(toString());
	}
}
public class ClassEx005 {

	public static void main(String[] args) {
		 Card  c1= new Card(); 
	    System.out.println(c1);
	}
}
//-- 생성자 작성하시오.
//class Card{
//   //상태-멤버변수  : 채널/볼륨 int cardNum; boolean  isMembership;   
//   //행위-멤버함수  : 채널, 볼륨 입력: input() / 출력 : show()
//}
//public class ClassEx005{
//   public static void main(String[] args) {
//   Card  c1= new Card(); 
//   System.out.println(c1);  
//   }
//}
//
//출력내용 :
//Card[cardNum=0, isMembership=false]

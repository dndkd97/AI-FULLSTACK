package com.the703.basic010_ex;

class Coffee {
	String name;
	int num, price;

	public Coffee() { name = "아메리카노"; num = 1; price = 2000; }

	public Coffee(String name, int num, int price) { super(); this.name = name; this.num = num; this.price = price; }

	@Override public String toString() { return "Coffee [name=" + name + ", num=" + num + ", price=" + price + "]"; }

	void show() {
		if (num != 1) {
			price = (price * 2);
		}
		System.out.println("=======커피");
		System.out.println("커피명: " + name + "\n커피잔수: " + num + "\n커피가격: " + price);
	}
}

public class ClassEx003 {
	public static void main(String[] args) {
		Coffee a1 = new Coffee("까페라떼", 2, 4000);
		a1.show();
		Coffee a2 = new Coffee();
		a2.show();

	}
}
//-- 생성자 작성하시오.
//class Coffee{
//  멤버변수 : String name;  int  price, num;
//  멤버함수 : void show(){}   //커피정보출력
//}
//public class Class003 {
//   public static void main(String[] args) {
//   Coffee a1 = new Coffee("까페라떼" ,2 , 4000);  a1.show();
//   Coffee a2 = new Coffee();                     a2.show();
//  }
//}
//출력내용 :
//=====커피
//커피명 : 까페라떼
//커피잔수 : 2 
//커피가격 : 8000
//=====커피
//커피명 : 아메리카노
//커피잔수 : 1
//커피가격 : 2000

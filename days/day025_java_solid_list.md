day025

 - Todo1 : java-Solid
 - Todo2 : java-List

---

part1. 제어문 - 절차지향
part2. OOP   - 객체지향

2-1. 클래스 사용 (클래스 vs 객체)
2-2. 클래스 설정 (static, final, public ■캡슐화)
2-3. 클래스 ■상속
2-4. ■다형성 (부모타입으로 자식타입들 관리)
2-5. ■추상화 (공통적인 속성 뽑기)

par3. OOP -활용

### Solid

S - SRP (단일 책임 원칙)   클래스는 하나의 책임만 가져야 함. 즉, 변경의 이유가 하나여야 함.
O - OCP (개방-폐쇄 원칙)   확장에는 열려 있고, 변경에는 닫혀 있어야 함. 기존 코드를 수정하지 않고 기능을 추가할 수 있어야 함.
L - LSP (리스코프 치환 원칙)   하위 클래스는 상위 클래스의 기능을 대체할 수 있어야 함. 즉, 다형성을 지켜야 함.
I - ISP (인터페이스 분리 원칙)   클라이언트는 자신이 사용하지 않는 메서드에 의존하면 안 됨. 인터페이스는 작고 명확하게 분리해야 함.
D - DIP (의존 역전 원칙)   고수준 모듈은 저수준 모듈에 의존하면 안 되고, 추상화에 의존해야 함. 즉, 인터페이스에 의존하라는 뜻.

1. S : 한 클래스는 하나만(한가지 일만 / 쿠키 반죽 반죽만, 쿠키굽기는 쿠키굽기만)
2. O : (수정말고 추가만) 새로운 쿠키를 쉽게 추가
3. L : (다형성: 같은방식으로 처리) 모든 쿠키는 같은 방식으로 만들기

ex)
//1. s : 단일책임 원칙
class CookieMaker{
	public void bakeCookie(String type) {System.out.println(type+"쿠키를 구워요");}
}

//2. o : 개방폐쇄 (새로운쿠키 추가가능, 기존코드 건들지말기)
interface Cookie{void make();}
class ChocoCookie       implements Cookie{ @Override public void make() { System.out.println("초코쿠키"); } }
class DeepChocoCookie   implements Cookie{ @Override public void make() { System.out.println("딥초코쿠키"); } }
class BananaChocoCookie implements Cookie{ @Override public void make() { System.out.println("바나나초코쿠키"); } }

//3. L : 리스코프치환 (어떤 쿠키든 Cookie 인터페이스로 바꿔써도 문제없음 부모 = 자식)
class CookieFactory{ //Cookie cookie 각종 쿠키종류 
	public void makeCookie(Cookie cookie) {cookie.make();} //어떤 쿠키든 여기서 만들 수 있음
}

//4. I : interface - 너무 많은 기능을 강요하지 말것! 꼭 필요한 기능(절차)
interface SimpleCookie {void make1(); /*void make2(); void make3();*/}

//5. D : 의존역전 - 어떤쿠키든 가게에서 팔수 있음
//                CookieFactory는 구체적인 쿠키가 아니라 Cookie에 의존
class CookieShop{
	private Cookie cookie; // interface Cookie
	public CookieShop() { super();  }
	public CookieShop(Cookie cookie) { super(); this.cookie = cookie; } // 쿠키종류는 외부에서 넣어줌
	public void sell() {System.out.println("cookie 가게에서 ...."); cookie.make();}
	
}

public class SolidBasic {
	public static void main(String[] args) {
		//1. s:단일책임 원칙
		System.out.println("1. s:단일책임 원칙");
		CookieMaker maker = new CookieMaker();
		maker.bakeCookie("초코"); maker.bakeCookie("오트밀"); maker.bakeCookie("라즈베리");
		
		//2. o:개방-폐쇄의 원칙 + L :리스코프치환
		System.out.println("2. o:개방폐쇄(레시피 추가) + l : 리스코프(공장- 어떤쿠키든지 굽기 가능) 치환");
		CookieFactory factory = new CookieFactory();
		factory.makeCookie(new ChocoCookie());
		factory.makeCookie(new DeepChocoCookie());
		factory.makeCookie(new BananaChocoCookie());
		
		//4. i : 인터페이스 분리
		
		//5. d: 의존역전 - 어떤쿠키든 가게에서 팔수있음
		CookieShop shop = new CookieShop( new DeepChocoCookie());
		shop.sell();
	}
}

---

1. 콜렉션프레임워크
2. lambda + stream

### Collection Framework

1.저장단위
- 변수 < 배열 < 클래스 < 콜렉션프레임워크 < 파일 < DB

2.콜렉션프레임워크
- [배열]의 단점을 개선한 클래스, 객체(클래스)만 저장가능
- 동적배열

※배열) 같은타입만 묶어서 저장가능, 배열생성시 크기를 저장해서 사용, 추후 변경이 불가능
  String [] arr = new String[3]
  
3. 핵심 인터페이스
1) List - 기차( 순서 o, 중복허용 o )
          add , get , size , remove , contains
2) Set  - 주머니 ( 순서 x, 중복허용 x )
          add , get(x) 향상된for/Iterator , size , remove , contains
3) Map  - 사전 - key, value 쌍
          add(x) put , get(key) , size , remove , contains

ex)
package com.the703.basic014;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List; // i : interface
import java.util.Vector;

public class List001 {
	public static void main(String[] args) {
		//Step1. Array
		String [] arr = new String[3]; //갯수
		arr[0] = "헐크"; //arr[1]=1;      같은 자료형
		System.out.println(Arrays.toString(arr));
		
		//Step2. 동적배열 - List 사용법
		// 부모    = 자식
		List list = null; // ctrl+shift+o
		     list = new ArrayList(); // 자식
		     list = new LinkedList(); // 자식
		     list = new Vector(); // 자식
		     
	    //Step3. <> add , get , size , remove , contains 
		List list2 = new ArrayList();
		list2.add("one"); // Object obj = "one"
		list2.add(1);     // Object obj = 1
		list2.add(3.14);  // Object obj
		System.out.println(list2);
		
		List<String> list3 = new ArrayList<String>();
		list3.add("one"); // Object obj = "one"
		//list3.add(1);     // Object obj = 1
		//list3.add(3.14);  // Object obj
		System.out.println(list3);
		
		//Step4. add(추가) , get(가져오기) , size(갯수) , remove(삭제) , contains
		List<String> list4 = new ArrayList<>();
		list4.add("apple");
		list4.add("banana");
		list4.add("coconut");
		list4.add("mango");
		
		System.out.println(list4);
		System.out.println(list4.get(0));
		System.out.println(list4.size());
		System.out.println(list4.remove(0)); // apple
		System.out.println(list4.contains("mango"));
		System.out.println(list4);
		
	}

}
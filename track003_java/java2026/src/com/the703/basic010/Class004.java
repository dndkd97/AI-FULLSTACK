package com.the703.basic010;

//1.클래스는 부품객체
//2.클래스 상태(멤버변수)와 행위(멤버함수)
//    Object                2)Object() {                               } 3)
//      ↑
//    product{name , price} 1)product() { super(); name=null , price=0 } 4)
class product extends Object{ //상속 받음 , Object( 클래스의 기본틀 ) , Object 생략가능 
	//인스턴스 변수
	String name;
	int price;
	public product() { super();  } // super(부모) - Object()
	public product(String name, int price) { super(); this.name = name; this.price = price; }//this(각각의 내꺼)
	@Override public String toString() { return "product [name=" + name + ", price=" + price + "]"; }
}
public class Class004 {
	public static void main(String[] args) {
		product p1 = new product(); //1) new 객체생성 2) 생성자-초기화 3) p1 주소갖기
		System.out.println(p1);     //p1(1번지)   →  1번지: product [name=null, price=0]
		
		product p2 = new product("아이폰17",100); //1) new 객체생성 2) 생성자-초기화 3) p1 주소갖기 (2번지)
		System.out.println(p2);     //p2(2번지)   →  2번지: product [name=null, price=0]
	}
}
//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
----------------------------------------------------
[METHOD:정보] product.class(설계도) , Class004.class #1)
----------------------------------------------------
[HEAP:동적]                        |  [STACK:지역]

1번지:product {name=null ,price=0}  ← p1(1번지)
                                     main #2)
----------------------------------------------------
(인스턴스)
*/
//////////////////////////////////////////////////////
/*■ OOP
1.  생성자   - new 연산자에 의해 호출 [       ] 담당
:초기화
2. 기본생성자( 디폴트생성자 )
- 모든클래스에 생성자가 반드시 존재
- 생성자선언을 생략시 컴파일러가 자동으로 기본생성자를 추가
- 개발자가 선언시 컴파일러가 자동생성  (        )
:취소
3. 생성자형식
class A{
   public    A(                 ){}   //기본생성자(디폴트생성자)
   public    A(String name){}   //파라미터, 알규먼트가 있는 생성자.
}
1)  리턴값  (       )
2)  클래스명과  (      ) 
:리턴값-x 클래스명과 동일
*/
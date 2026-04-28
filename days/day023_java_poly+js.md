day023

 - Todo1 : java - opp
 - Todo2 : js006_control_etc1.html 문제풀이

---

JAVA - OPP (다형성 polymorphism)

1. 다형성
- 많은 형상을 띄는 성품
- 여러 타입의 객체를 하나의 타입으로 관리

2. 부모는 자식을 담을 수 있다. (업캐스팅)
-----------------------------------------------
<<class>> Animal  [이름 , 나이 / 먹기 , 자기 , 배변]
            ↑
<<class>>  Cat    [동물등록증 / 꾹꾹이 하기]
-----------------------------------------------

Animal ani = new Cat()

1) Animal ani {이름 , 나이 / 먹기,자기,배변}
2)         Cat() → Animal()     →Object()
{동물등록증 / 꾹꾹이 하기} + {이름 , 나이 / 먹기 , 자기 , 배변}

3. 자식은 부모를 담을 수 있다. (다운캐스팅)
-----------------------------------------------
<<class>> Animal  [이름 , 나이 / 먹기 , 자기 , 배변]
            ↓
<<class>>  Cat    [동물등록증 / 꾹꾹이 하기]
-----------------------------------------------
Cat cat = new Cat()
1) Cat cat; 
{동물등록증 / 꾹꾹이 하기} + {이름 , 나이 / 먹기 , 자기 , 배변}

2) new Animal()
{이름 , 나이 / 먹기 , 자기 , 배변}

3) 만족 못 시키는 범위가 생김
{동물등록증 / 꾹꾹이 하기}

4. 쓰는 이유는? 
- 부모 타입으로 자식 객체들을 관리가능

Animal [] anis = {new Cat() , new Cat(), new Person() , new Person()};

ex)
    //Q1. 상속도 그리기
    //Q2. 각클래스에서 사용할수있는 멤버변수/멤버메서드
/*
    Object
    ↑
    Papa(int money=10000,sing(){GOD-거짓말})
    ↑
    Son(int money=1500,@sing(){빅뱅-거짓말})
*/

class Papa extends Object{  
int money = 10000;     
public Papa() { super(); }
public void sing() {  System.out.println("GOD-거짓말");  }}// end class

class Son extends Papa{ 
int money = 1500;
public Son() { super(); }
@Override public void sing() {  System.out.println("빅뱅-거짓말"); }} // end class

public class PolyEx001 {
public static void main(String[] args) {
    //부모        = 자식(업캐스팅)
Papa mypapa = new Son();    
    // Q3. Papa mypapa 의미?   {money=10000/sing()}
    // Q4. 인스턴스화한 실제 메모리 빌려온그림 -new Son()
    //         Son()   →   Papa()   →   Object()
    // 1번지:{money = 1500 / @sing(){빅뱅-거짓말}}-{money=10000/ sing(){GOD-거짓말}}
    // mypapa= 1번지
    //--->>>>>
    // {money=10000/sing()} = 
    // 1번지:{money = 1500 / @sing(){빅뱅-거짓말}}-{money=10000/ sing(){GOD-거짓말}}
System.out.println(mypapa.money); // Q5.  출력  10000
mypapa.sing();  //Q6. 출력  빅뱅-거짓말
    //Q7. mypapa.money 를 이용해서  1500 출력되게 해주세요.
System.out.println(((Son)mypapa).money);


```
### 복습문제


class A11 {
    int a; // (1)

    A11() { }

    A11(int a) { this.a = a; } // (2)

    //(3) void show()
    void show() { 
        this.a = 11; 
        System.out.println(this.a); 
    }

    //(4) static void classMethod()
    static void classMethod() { this.a = 12; }

    //(5) int showZ()
    int showZ() { 
        int a; //지역변수
        return a; 
    }
}

public class RepeatQ123 {
    public static void main(String []args) { 
        A11 a1 = new A11(); 
        (b) 
    }
} // end class

Q1. 위의 문제에서 (1),(2),(3),(4),(5)를 [ 클래스변수, 인스턴스변수, 지역변수, 클래스메서드, 인스턴스메서드 ]에서 고르시오.
:(1)-인스턴스변수 - heap area - new -this 각각
 (2)-생성자 
 (3)-인스턴스메서드 - heap area - new -this 각각
 (4)-클래스메서드- method area - new x - 공용
 (5)-인스턴스메서드
Q2. 클래스 A11에서 오류나는 곳을 수정하고 그 이유를 적으시오.
:(4)-static은 this.a 사용 불가
 (5)- int a 지역변수는 수동으로 초기화를 시켜줘야함
Q3. (b)번 위치에서 A11 a1 = new A11();

메모리 빌려오고, 객체 생성하는 역할 : (    new      )
String은 null, int는 0으로 초기화하는 역할 : (  A11()   )
new A11()한 주소를 갖고 있는 것은 : (  참조변수 a1   )

Q4. 기본생성자를 반드시 선언해야하는 경우를 적으시오.
:오버로딩(다른 생성자를 작성),상속

Q5. 다음 중 오버로딩이 성립하기 위한 조건이 아닌 것은? (모두 고르시오) *메서드이름이 같고 파라미터 타입과 갯수로 구분
a. 메서드의 이름이 같아야 한다.                 *오버로딩 조건
b. 매개변수의 개수나 타입이 달라야 한다.          *오버로딩 조건
c. 리턴타입이 달라야 한다.                      *오버로딩 조건 X
d. 매개변수의 이름이 달라야 한다.                *오버로딩 조건 X A(int brain), A(int money)
:c,d

Q6. 다형성이란? 
:하나의 타입으로 여러형태를 사용할수 있는 성질

Q7. 다음코드에서 다음에 해당하는 부분을 작성하시오.

//7-1. 상속도
//7-2. 각 클래스에서 사용할수 있는 멤버변수, 멤버함수
:Object  #3.{                 }#4.
   ↑
 Parent7 #2.{x=100 , method() }#5.
   ↑
 Child7  #1.{x=200 , @method()}#6.

package com.the703.basic012_ex;

class Parent7  extends Object{
      int x = 100;
      public Parent7() { super(); }
      void method() { System.out.println("Parent Method"); }
} 
class Child7 extends Parent7 {
   int x = 200;
   public Child7() { super(); }
   @Override  void method() { System.out.println("Child Method"); }
}
public class PolyEx002 {
   public static void main(String[] args) {
         Parent7 p = new Child7();     //부모  = 자식 (업캐스팅)
         // 7-3.    Parent7 p   보장하는 범위  :(int x=100, method())
         // 7-4.    인스턴스화 했을때 사용가능한 범위 :{int x=100, method()}-{int x=200, @method()}  
         Child7 c = new Child7();  

         System.out.println("p.x = " + p.x);  // 7-5 출력되는 내용 :p.x=100  
         p.method();  //7-6 출력되는 내용    :Child Method
         
         System.out.println("c.x = " + c.x);   // 7-7  출력되는 내용 :c.x=200
         c.method();   //7-8. 출력되는 내용     :Child Method
   }
}


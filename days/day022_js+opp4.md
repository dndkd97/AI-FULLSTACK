day022

 - Todo1 : js
 - Todo2 : java-opp

---

### js

- typeof
ex)  1,2,3 중에 입력하세요
     1번 공부하기 , 2번 운동하기 , 3번 영화보기 알림창을 띄우시오. 
:   let switch1 = prompt("1,2,3중에 입력하세요");
    switch(switch1){ // Number(switch1) = case 1: ... case 2: ...
    case "1":alert("공부하기");break;
    case "2":alert("운동하기");break;
    case "3":alert("영화하기");break;
    default :alert("1,2,3이 아니다");}

1. 조건문

(1) if

ex) 평균을 입력하세요 __입력받기
    만약 평균이 60점 이상(60점포함)이라면 합격, 아니면 불합격 출력
:  window.addEventListener("load",function(){
   document.querySelector(".btn").onclick=function(){
   let num =prompt("평균을 입력하세요");
   if(num>=60){alert("합격");}   
   else {alert("불합격");}
 //alert(num >=60? "합격":"불합격"); -삼항연산자
   };});
    
(2) switch

ex) 4,5,6 중에 입력하세요
    4번 월드콘  ,  5번 구구콘 , 6번 설레임 알림창을 띄우시오.

:  window.addEventListener("load",function(){
    document.querySelector("#switch1").onclick=function(){
    let num1 =prompt("4,5,6중에 입력하세요"); console.log(typeof(num1));
    switch(Number(num1)) { // or case "4"
    case 4:console.log("월드콘");break;
    case 5:console.log("구구콘");break;
    case 6:console.log("설레임");break;
    default:console.log("4,5,6이 아니다");
    };};});


2. 반복문

Q1)  1	2	3	4	5

(1) for
: for(let i=1; i<=5; i++){console.log(i);}

(2) while
: let i=1; while(i<=5){console.log(i); i++;}

(3) do while
: let a=1; do{console.log(a); a++;}while(a<=5);

2-1.향상 for,forEach

Q1) const list1 = [1,2,3,4,5];
(1) 향상 for
:  for(let i5=0; i5<=list1.length; i5++){console.log(list1);}
    //     i(번호)     객체
   for(let i in list1){console.log(i+"\t"+list1[i]);}

(2) forEach
:  list1.forEach((ele, index , list1)=> {//한개씩 번호,list
   console.log(ele , "/" , index , "/" , list1);  
     

■계산기 기능 구현

ex)    다음과 같이 계산기 기능을 구현하시오.
    1. 빈칸검사를 하시오.
    2. 숫자는
      0~100 사이의 숫자를 입력받지 못하면 무한반복으로 다시 입력받게 하시오.
    3. 연산자는
      +,-,*,/를 입력받지 못하면 무한반복으로 다시 입력받게 하시오.
    4. 각 연산에 맞게 계산기를 구현하시오. (+,-,*,/)

:   window.addEventListener("load",function(){
    let num1 = document.querySelector("#num1");
    let num2 = document.querySelector("#num2");
    let abc = document.querySelector("#abc");
    let result1 = document.querySelector("#result1");
    let calc = document.querySelector("#calc");
    calc.onclick=function(){
    let num11,abc1,num21,result;
        for(;;){ 
        num11 = Number(prompt("숫자 1 입력"));
        if(num11>0 && num11<=100){break;}}
        for(;;){
        num21 = Number(prompt("숫자 2 입력"));
        if(num21>0 && num21<=100){break;}}
        for(;;){
        abc1 = prompt("연산자 입력");
        if(abc1 == "+" || abc1 == "-" || abc1 =="*" || abc1 == "/"){break;} }


    if(abc1 == "+"){result =num11+num21;}
    else if(abc1 == "-"){result =num11-num21;}
    else if(abc1 == "*"){result =num11*num21;}
    else if(abc1 == "/"){result =num11/num21;}

    num1.value=num11;
    num2.value=num21;
    abc.value=abc1;
    result1.value=result;
    alert(result);
    }
    });

---

### java opp

OOP(1)-상속

-상속은 부모클래스의 속성(멤버필드,멤버메서드,이너클래스)를 자식클래스가 상속받아 클래스 내부에 포함

1. 상속? 클래스의 재사용- 새로운 부분만 추가,수정해서 사용

2. super vs sub
    부모     자식
    상위     하위
    parent child
    super   sub

3. 모든 클래스는 Object 클래스를 상속

4. UML 부모 ← 자식 

5. 장점 - 빠른개발, 코드의 중복제거, 다형성(하나의 타입으로 여러타입을 관리)

6. 문법
  class 자식클래스 extends 부모클래스 (O)
  class 자식클래스 extends 부모클래스1, 부모클래스2 (X)

7. 상속시 부모속성을 사용할수 있는 이유는?
 - 부모생성자를 호출해서
   부모의 인스턴스변수를 초기화해 사용가능하게 만들어줌

8. 오버라이드
 - @Override
 - 상속시 부모의 메서드와 동일, 자식 클래스에 맞게 수정해서 사용

---

ex)
class A extends Object { int a = 10;  public A() { super();  }  }

class B extends A      { int b = 20;  public B() { super();  }  }

class C extends B      { int c = 30;  public C() { super();  }
	 void show() {System.out.println(a+"\t"+b+"\t"+c);}}
	
public class Extends001 {
	public static void main(String[] args) {
		C my = new C(); //1) new 객체생성 2) C()초기화 3) my 주소 
		my.show();}   }

: Object #4. {          }#5
    ↑
    A    #3. {      a=10}#6
    ↑
    B    #2. {      b=20}#7    
    ↑
    C    #1. {      c=30}#8      
    -----------------------
    C my = new C();
    -----------------------
    1) extends 상속
    2) is a : A는 Object이다. B도 Object이다 
    3) 생성자 호출순서: C() → B() → A() → Object() 1 2 3 4
    4) 객체가 생성되는 순서 : Object → A → B → C    5 6 7 8

---
### 복습문제

Q1. 클래스와 인스턴스의 관계를 설명하시오    
클래스는 객체를 만들기 위한 (①  설계도    ) 역할을 한다.
인스턴스는 클래스의 구조를 기반으로 (②  실체화    ) 되어 메모리에 생성된 실체이다.
같은 클래스라도 인스턴스는 서로 다른 (③  특징(주소)   ) 값을 가질 수 있다.

Q2. 다음 코드의 실행 결과와 메모리 구조를 설명하시오
```java
Car myCar = new Car("Hyundai", 2023);
```
new Car(...)는 객체를 생성하고 (④   heap   ) 영역에 저장된다.
myCar는 해당 객체의 (⑤   주소   ) 를 참조한다.
생성자 내부에서는 전달받은 값을 (⑥   초기화   ) 한다.

Q3. 생성자에 대한 설명으로 옳은 것을 고르시오
생성자는 클래스명과 (⑦  이름   ) 이 같아야 한다.
생성자는 객체 생성 시 자동으로 (⑧  호출   ) 된다.
생성자는 반환값이 (⑨   x   )

Q4. 기본 생성자가 자동으로 생성되지 않는 경우는?
클래스에 (⑩   오버로딩   ) 생성자가 이미 정의되어 있을 경우
상속받은 클래스에서 부모 생성자 호출이 필요한 경우

Q5. 다음 코드에서 객체가 저장되는 메모리 영역과 메서드 실행 흐름을 설명하시오
```java
Book b1 = new Book("Java", 500);
Book b2 = new Book();
b2.setTitle("Spring");
```
Book 클래스의 인스턴스는 (⑪  heap   ) 영역에 저장된다.
b1, b2는 각각 객체의 (⑫   주소   ) 를 참조한다.
setTitle() 메서드는 (⑬  stack   ) 영역에서 실행된다.

---
method(정보)
heap(동적) stack(지역)

Q6. 자바 메모리 구조에서 각 영역의 역할을 설명하시오
Method Area : 클래스 정보 및 static 변수 저장
Heap Area : (⑭  인스턴스객체    ) 저장, GC가 관리
Stack Area : (⑮  지역변수   ) 저장, 메서드 호출 시 사용됨

Q7. 변수의 종류와 메모리 위치를 연결하시오
클래스 변수 → (⑯  method  ) 영역
인스턴스 변수 → (⑰   heap   ) 영역
지역 변수 → (⑱   stack   ) 영역

Q8. 접근자를 넓은 범위에서 좁은 범위로 적으시오
(⑲public   → ⑳protected    → ㉑default(package)    → ㉒private  )

Q9. 다음을 private으로 설정했다. 외부에서 접근 가능하게 설정해야 하는 것
(㉓getter   / ㉔setter   ) 이다. 

Q10. 상속에 대한 설명으로 옳은 것을 고르시오  
상속은 기존 클래스의 (㉕속성    )와 기능을 재사용하기 위해 사용된다.
자식 클래스는 부모 클래스의 (㉖필드-멤버변수   )와 메서드를 물려받는다.
상속을 통해 코드의 (㉗유지보수    )성과 재사용성을 높일 수 있다.
자바에서 상속은 (㉘extends    ) 키워드를 사용하여 구현한다.

Q11. 오버로딩과 오버라이딩의 차이를 설명하시오  
오버로딩은 같은 클래스 내에서 (㉙메서드이름    )이 같고 (㉚파라미터    )가 다른 메서드를 정의하는 것.
오버라이딩은 부모 클래스의 메서드를 자식 클래스에서 (㉛@Override    )하여 재정의하는 것.
오버로딩은 (㉜컴파일    ) 시점에 결정되고, 오버라이딩은 (㉝실행    ) 시점에 결정된다.
오버라이딩 시 접근 제어자는 부모 메서드보다 (㉞넓은    ) 범위로만 변경 가능하다.


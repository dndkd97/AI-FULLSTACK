day021

 - Todo1 : js
 - Todo2 : java - opp

---

### js

1.마법상자 - 명시적함수
 -호이스팅 : 코드 실행전에 메모리가 올라감, 선언전 호출가능
 -fn1(); 선언전 호출가능
ex) function fn1(){
    alert("홍길동");alert("홍길동");alert("홍길동");alert("홍길동"); };

2.함수표현식 - 변수에 할당하는 방식 ( React )
ex) fn21();
    const fn21 = function(){ alert("Hello2")};
    fn21();
3.화살표함수 - React
ex) const fn22 = ()=>alert("hello22");
    fn22();
4.즉시 실행함수
ex) (function(){alert("hello3");})();

---

- e.preventDefault(); : 기본이동막기
ex) link.onclick=function(e){
    console.log(e); //이벤트와 관련된 정보
    e.preventDefault();// 기본이동막기
    };

- 회전 코드
:rotate.style.transform = `rotate(${++cnt*45}deg)`;

- 값 증가
ex) let cnt = Number(num.innerHTML); //현재값 저장
    plus.onclick=function(e){
      e.preventDefault();
      num.innerHTML = cnt++; }; //증가
    minus.onclick=function(e){
      e.preventDefault();
      num.innerHTML = cnt--; }; //감소
    });

- 좌,우 이동

ex) -좌-
let pos =0;
 box.style.transform= `translateX(${pos-=10}px)`;

ex) -우-
let pos =0;
 box.style.transform=`translateX(${pos+=10}px)`;


### java-opp

1. 초기화순서
   기본값         명시적초기화      초기화블록      생성자
   
    4-1)   [  기본값  ]   : String ,객체 - null /  int - 0 으로 초기화
    4-2)   [  명시적초기화  ]   :  int a=10;    중요콘텐츠 명시적으로 알림!    
    4-3)   [  초기화블록  ]   :  { a=10; b=20; }   여러개초기화시
    4-4)   [  생성자  ]    : 최종은 생성자에서 사용함.  인스턴스변수 초기화


2. runtime data area
 [  method  ]  : 정보저장 , static, final
 [  heap  ]  : 동적저장 - new ,  gc( garbage collecetor)가 처리소멸
 [  stack  ]  : 임시값저장

3. static
- jvm 소스로딩시 메모리 할당받음
- new연산자보다 먼저 실행되어 메모리(method 영역:runtime)에    (    1    )    회 생성
- 클래스명.변수명  / 클래스명.메서드명   - 클래스변수/클래스메서드 Calc.name
- 객체생성과 관련이 (  x  )
- 인스턴스로 접근시 권장사항이 아니므로 경고발생

---

1.fianl의 의미: 마지막의, 변경될수 없는, (상수화)를 의미

2.사용
 1) 변수에 적용시 > 변수 상수화,변수값 수정x
 2) 메서드에 적용시 > 상속관계에 따른 오버라이딩 x
 3) 클래스에 적용시 > 상속x
 - 클래스 ( 상속 x / 재사용 x /- extends 사용못함 )
 - 멤버변수 ( 상수 o / 값변경 x )
 - 멤버함수 ( 부모기능 수정 x / @Override 못함

---

1. 지정접근자
-클래스의 구성요소에 대한 접근을 제한하는 역할
              클래스내부   패키지(폴더)    하위클래스   그외
public           o         o            o       o
protected        o         o            o       x
default          o         o            x       x
private          o         x            x       x


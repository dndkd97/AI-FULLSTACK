day018

 - Todo1 : js+bootstrap
 - Todo2 : java-OOP(객체 지향 프로그래밍)

 ---

### js+bootstrap

1.출력 방법

-document.write("문자열")
ex)document.write(global);
-console.log("문자열")
ex)console.log("안녕 js");


2.변수 선언 방식

-var:재선언 및 재할당 가능
-let:재선언 불가,재할당 가능
-const:재선언 및 재할당 불가, 선언 시 초기화 필수


3.자료형과 typeof

:typeof로 변수의 타입 확인
 "10"+10 → "1010"
 Number("10")+10 → 20


4.알림창 이벤트

-prompt(): 사용자 입력 받기
-alert(): 알림창 표시
ex) let age = prompt("나이를 입력하세요");
    console.log(age);
    alert("당신의 나이는 :" + age + "살입니다.");

-confirm(): 확인/취소 선택
ex)  let answer = confirm("정말 취소하시겠습니까? ")
    .log(answer,typeof(answer));


5.이벤트 처리

-onclick:클릭 이벤트
ex)<input type="button"  value="DOG-멍멍"  title="버튼1"    class="btn btn-success" onclick="alert('멍멍')"/>
-onmouse
ex)onmouseover="this.style.backgroundColor='red'" → 마우스 올렸을때 red 색상
   onmouseout="this.style.backgroundColor='#cff4fc'" → 마우스 커서가 없을때 해당색상
-addEventListener:다양한 이벤트 처리 가능


6.DOM 선택자

-getElementById(): ID로 요소 선택
ex) document.getElementById("addEventEx")
-getElementsByTagName(): 태그명으로 선택


7.함수 선언과 호출

-function 함수명(){}: 함수 선언
함수명(): 함수 호출
이벤트 핸들러에서 함수 호출 가능

ex1)  { 0. 스크립트가 document어느위치에서든지 동작가능하게
        1. 아이디가 addEventEx인것을  getElementById 이용해 선택
        2. 클릭시 prompt이용해서 당신이 좋아하는 1~5사이의 숫자 물어보고  예) 3
        3. alert이용해서 좋아하는 숫자만큼 알림창 띄우기     예)  alert(1)  alert(2)   alert(3) }

  → window.addEventListener("load", function()  //어느 위치에서든 동작 가능
    {document.getElementById("addEventEx").onclick=function(){
    let num=prompt("1~5사이의 좋아하는 숫자?>"); 
    for(let i=0; i<num; i++){alert(i+1);} // 제어문 사용
    };  });
        
ex2)  { 0. 스크립트는 어디서든 동작 가능
        1. 아이디가 borderStyleBtn인 버튼을 선택
        2. 클릭 시 테두리 스타일 입력받음 (solid, dashed, dotted 등)
        3. 카드에 입력한 테두리 스타일 적용 }
  → window.addEventListener("load",function(){
    document.getElementById("borderStyleBtn").onclick=function(){
    let color=prompt("테두리 스타일","solid, dashed, dotted 등");
    document.getElementById("ex3").style.border="10px " + color + " red"; //색깔은 앞에 공백, px은 뒤에 공백 ★ 
                                    };   });

     
### JAVA-OOP

■ 클래스란?
 - 자바에서 데이터를 저장할 수 있는 단위
 - 부품객체
 - 상태(멤버 변수)와    행위(멤버 함수)를 갖는다
 - 설계도 → 부품객체 → 사용

1. OOP? ★
- 객체     지향       프로그래밍
- Object  Oriented  Programming
- 틀       기반       프로그램
- 부품 객체(클래스) 조립해서 완성된 프로그램을 만드는 기법

2. OOP의 특징 ★ 캡다상추
- 캡슐화 : 외부접근 제한
- 다형성 : 한가지의 타입으로 여러타입을 관리, 확장성
- 상속  : 클래스 재사용
- 추상화 : 핵심 기능 추출해서 만든 모델링

3. 클래스와 인스턴스
- 1) 클래스( 설계도 , 붕어빵틀 )
- 2)       인스턴스화를 통해 ( new 실제메모리 - heap에 객체 )
- 3)                                                객체들(Object : 붕어빵들)
                                                    인스턴스 → 팥붕,슈붕
★ 클래스는 설계도
★ 인스턴스는 실제로 만들어진 객체


-starUML다운
1.클래스 이름 입력
2.Add-Attribute(멤버변수)
3.Add-Operation(멤버함수)
→메서드명(알규먼트명 :타입):리턴값순으로 입력

---

### 복습문제

■1. 자바스크립트 빈칸채우기
1. 자바스크립트의 출력   (    ,   )
:console.log("문자열");,document.write("문자열");
2. 변수    (   ,  ,   )
:var,let,const
3. 변수차이   (    ,    ,  )
:var-재선언,재할당 가능
 let-재선언 x,재할당 가능
 const-재선언,재할당x선언 시 초기화 필수
4. 변수는 모든자료형을 담을수 있다.  자료형확인은 (      )
:typeof

5. 알림창 종류  - (   ,   ,    )
:prompt,alert,confirm
6. 이벤트  - 이벤트대상(div),    이벤트(click),  이벤트 핸들러(alert('haha'))
   다음 div 태그를 클릭했을때 알림창 haha를 출력하는 코드를 작성하시오.
    <div onclick = "">test</div>
:<div onclick="alert('haha')">
7. 다음에 해당하는하는 스크립트 코드를 작성하시오.    
    0. 스크립트가 document어느위치에서든지 동작가능하게
    1. 아이디가 test인것을  getElementById 이용해 선택
    2. 클릭시 prompt이용해서 당신이 좋아하는 1~5사이의 숫자 물어보고
    3. alert이용해서 알림창띄우기  
   <input type="button"  value="addEventListener"  title="버튼4"  id="test"    class="btn btn-outline-primary"  />  
   <script>  
   </script>  
   window.addEventListen("load",funticon(){
    document.getElementById("test").onclick=funticon(){let num =prompt("1~5사이 숫자 입력");
    alert("좋아하는 숫자는: "+ num) };
   });



■2. 자바
1.  OOP? 
: objact orients programming , 객체지향 프로그램, 부품 객체를 조립해서 완성된 프로그램으로 만드는 기법
2.  OOP특징 
:캡슐화,다형성,상속,추상화
3.  클래스는  (        )와  (       )를 갖는다 
:상태(멤버변수),행위(멤버함수)
4.  클래스와 인스턴스 구분
- 클래스는  (      )
- 인스턴스는  (          )
:  클래스:설계도
 인스턴스:실제로 만들어진 객체
day020

 - Todo1 : js+bootStrap
 - Todo2 : java -opp

---

### js

1. 선택자

- parentElement(): 속성은 지정된 요소의 부모 요소를 반환
ex) let orange = document.querySelector("#orange");
    orange.parentElement.style.border="8px solid pink";

- closest(): 제일 가까운 상위 부모 호출
ex) orange.closest("div").style.backgroundColor="black";

- 형제요소
1)- previousElementSibling : 이전 요소 노드 호출
ex) orange.previousElementSibling.style.textAlign="center";
2)- nextElementSibling : 다음 요소 노드 호출
ex) orange.nextElementSibling.style.textAlign="right";

2. value,innerHTML 
:값과 내용 접근

-value
ex) value_target
    let value = document.querySelector("#value");
    value.addEventListener("click" , function(){
    let value_target = document.querySelector("#value_target"); //대상(input)
    alert(value_target.value); // input 태그에서 대상찾을때 value : 찾기
    value_target.value = "abc"; // valuew : 셋팅

-innerHTML
ex) innerHtml - 대상
    inner 버튼 클릭시 div(입력 받는 용도가 아닌태그).inner_target 태그 안에 값
    let inner = document.querySelector("#inner");
    inner.addEventListener("click" , function(){
    let inner_target = document.querySelector(".inner_target");
    inner_target.innerHTML = "HELLO"; // 해당태그에 동적으로 값 넣기 A=B
    alert(inner_target.innerHTML);    // alert 로 해당값 출력
    });

-HTMLCollection,NodeList
-classList,createElement,appendChild
 window.addEventListener("load", function(){ 
    // HTMLCollection (실시간) id+tagname
    const fhtml = document.getElementsByClassName("fruit");
    // NodeList (정적) 
    const fnode = document.querySelectorAll(".fruit"); 

    // 버튼 이벤트
    document.getElementById("addFruit").onclick=function(){
      const newli = document.createElement("li");
      newli.textContent="Mango"; // 태그안에 콘텐츠 - test
      newli.classList.add("fruit", "added"); //#2. css추가 (css들) fruit,added
      document.getElementById("fruits").appendChild(newli); //#1. 망고 추가

     console.log(fhtml , fhtml.length);
     console.log(fnode , fnode.length);};
  });


### java - opp

1.this
-해당 객체를 지칭하는 키워드
-해당 멤버변수에 접근할 때 일반 지역변수와 구분하기 위해 사용
-특정 객체 내에서 현재 객체 자신을 의미하는 참조변수를 의미
-자신이 객체가 되어 매모리내에 존재할 자신의 위치값 기억
-메소드 내에서만 사용가능
-static 메소드에서는 사용 x 
-멤버변수와 앞에서 this를 붙여서 사용
-this()생성자는 this멤버변수보다 위에 와야함

ex)
package com.the703.basic010;

//1. 클래스는 부품객체이다
//2. 클래스는 상태(멤버변수)와 행위(멤버함수)

class Farm{
	//상태(멤버변수)
	String name; //인스턴스변수- heap area - new O - 생성자
	int age;
	
	static String FarmName="(주) 동물농장"; //클래스변수 - 클래스명.변수명
	static int FarmNum; //클래스변수 - method area - new 관련 X - 생성자 관련X
	static String FarmBoss;
	static {FarmNum=2; FarmBoss="신동엽";} //초기화블록
	//행위(멤버함수)
	static void numPlus() { FarmNum++; /*this.age++; :사용불가*/} //클래스.메서드- method area - static
	void show() {//인스턴스 메서드 - heap area - new O - 생성자
	System.out.println("\n\n:::::::::::");
	System.out.println("::이름 :"+this.name);
	System.out.println("::나이 :"+this.age);
	System.out.println("::동물농장 인원 :"+Farm.FarmNum);
	}
}

public class Class005 {
	public static void main(String[] args) {
		System.out.println("\n\n0.동물농장");
		System.out.println("::회사이름>" + Farm.FarmName);
		System.out.println("::회사사장>" + Farm.FarmBoss);
		System.out.println("::회사인원>" + Farm.FarmNum);
      
		System.out.println("\n\n1.동물식구 - this - 각각");
		Farm cat = new Farm(); // 1) new 객체만들기 2) Farm()초기화 3) cat번지
		cat.name = "kitty"; cat.age=3;  Farm.numPlus();cat.show();
		
		Farm dog = new Farm(); // 1) new 객체만들기 2) Farm()초기화 3) dog번지
		dog.name = "뽀삐"; dog.age=7;   /*dog.numPlus();*/ Farm.numPlus();
		dog.show();
	}

}
/*
초기화      기본값   명시적초기화     초기화블록   생성자
FarmName  null   (주) 동물농장  (주) 동물농장    x
FarmNum    0         0            2        x
FarmBoss  null     null         신동엽       x
---------------------
cat name=null       →             →        →
    age=0
dog name=null       →             →        →
    age=0
---
 [RUNTIME DATA AREA]
--------------------------------------------------------------
[METHOD:정보, static,final] Farm.class , Class005.class
 Farm.FarmName="(주) 동물농장"; Farm.FarmNum=2; Farm.FarmBoss="신동엽"; Farm.numPlus()
--------------------------------------------------------------
[HEAP:동적]               |  [STACK:지역]
2번지{name="뽀삐", age=0}   ← dog[2번지]
1번지{name="kitty, age=3}  ← cat[1번지]
--------------------------------------------------------------
*/


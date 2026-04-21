day019

 - Todo1 : js+bootstrap
 - Todo2 : java-opp

 ---

### js + bootstrap(2)

-getElementsByTagName(): 태그명으로 선택
ex1)  let animal = document.getElementById("animal"); console.log(animal);

ex2)  window.addEventListener("load", function(){
       //Q1) document.getElementsById 이용해서  #fruits 선택  
      let fruits = document.getElementById("fruits");
       //Q2) document.getElementsByTagName 이용해서  
      //   #fruits 안의 모든 li에 배경색 black, 글자색 white , 여백 10px주기
      let fts =fruits.getElementsByTagName("li");
      for(let i=0; i<fts.length; i++){
      fts[i].style.backgroundColor="black";
      fts[i].style.color="white";
      fts[i].style.padding="10px";}
       //Q2) document.getElementsById 이용해서 banana 선택 배경색 gold
      let banana = document.getElementById("banana")
      banana.style.backgroundColor="gold";
       //Q3) document.querySelector 이용해서 coconut 선택 
       //  coconut를 클릭하면 width:200px; 로 수정
      let coconut = document.querySelector("#coconut");
      coconut.onclick=function(){
      this.style.width="200px";};
      });


-querySelector(): CSS 선택 
ex) //Q1) querySelector 이용해서 #colors 선택
    let color = document.querySelector("#colors");

-onmouseover: 마우스 오버 시 나타나는 이벤트
ex) //Q5) #green 마우스오버 시 글자크기 25px로 변경
    document.getElementById("green").onmouseover=function(){this.style.fontSize="25px";};

-ondblclick: 더블클릭 시 이벤트
ex) //Q4) #blue 더블클릭 시 width 150px로 변경
    document.querySelector("#blue").ondblclick=function(){this.style.width="150px";};


### java-OPP

1.생성자 - new 연산자에 의해 호출 [초기화] 담당 
2.기본생성자
- 모든 클래스에 생성자가 반드시 존재
- 생성자 선언을 생략시 컴파일러가 자동으로 기본생성자를 추가
- 개발자가 선언시 컴파일러가 자동생성 취소
  alt + shift + s
3.형식
class A{
 String name;
 A(){}             //기본생성자(디폴트생성자)
 A(String name){}  //파라미터,알규먼트가 있는 생성자
}
  리턴값 메서드명(파라미터)
   X   클래스명동일

ex) public Car32() { color="white"; } // 기본생성자 - 2)생성자가 개발자 수동으로 만들때 자동생성취소
	public Car32(String color) { super(); this.color = color; } // 필드있는 생성자
    //상태확인
	@Override public String toString() { return "Car32 [color=" + color + "]"; }  

---


### 복습문제

■ Javascript
1. js 선택자 
1-1. id 선택자 사용시 : document.getElementById
1-2. 태그 선택자 사용시 : document.getElementsByTagName 
1-3. css 표현 선택자 사용시 : document.querySelector

2. 다음에 해당하는 코드를 한줄한줄  적으시오.
2-1. 스크립트가 document어느위치에서든지 동작가능하게     
2-2. 아이디가 test인것을  querySelector 이용해 선택   
2-3. 클릭시 prompt이용해서 당신의 이름묻기
2-4. alert이용해서 이름 알림창띄우기   
2-5. 아래 스크립트를 채우세요.
<input type="button"  value="addEventListener"  title="버튼4"  id="test"    class="btn btn-outline-primary"  />  
<script>   
//////////
</script>  
:window.addEventListener("load", function(){
let test = document.querySelector("#test");
test.onclick=function(){let name =prompt("당신의 이름은?"); alert("당신의 이름은:" +num);};
});


■ OOP
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
:리턴값-없음
 클래스명과 - 동일시
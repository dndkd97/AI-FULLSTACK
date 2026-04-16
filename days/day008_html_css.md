day008

- Todo1:  css(2)  내부적용  / id vs class
- Todo2:  java  제어문 - SWITCH

---

### css
1. 가상 선택자 
<선택자>
- 일반태그 선택자  : p
- 아이디 선택자    : #id
- 클래스 선택자    : .class
- 가상선택자:       :hover           마우스를 올렸을때
                  :first-child     부모안에서 첫번째 자식요소
                  :last-child      부모안에서 마지막 자식요소
        
.protfolio :first-child { text-align: center;}
.protfolio :last-child  {font-weight:bold; font-size:90%}

Q1. .protfolio ul태그의 첫번째 li를 선택해서 좋아하는 배경색으로 넣기
    .protfolio ul li:first-child {background-color: #ffffff;}

### java  CONTROL - SWITCH
 
1.switch구조
:switch(num){
  case 1:result="1이다";break;
  case 2:result="2이다";break;
  case 3:result="3이다";break;
  default :result="1,2,3이 아니다";break;
}





### 복습문제

■1. html + css

  1. css 선택자 - 태그선택자, 아이디선택자, 클래스선택자 , (         : 예  :hover, :first-child)
  :태그선택자:h1,p
  아이디선택자:#id
  클래스선택자:.class
  가상 선택자::hover,first-child
  2. 내부적용을 이용해서 다음 css를 적으시오. 
    h1 중앙정렬, 글자색상 : #34495e, 아래쪽여백 : 40px 
  :<style>
  h1{ text-align: center; color: #34495e ;    margin-bottom : 40px }
  <style>
  
  3. 여러개의 div태그에 .portfolio라는 클래스를 적용하고  
    각각의 배경을다르게 설정하려고 한다.  .p1은 배경 red,    .p2는 gold 
    html 설정에 css를 적용하는 코드를 적으시오
    ```
      <div></div>
      <div></div>
    ```
    :.portfolio{width=100px; height=100px;}
     .p1{background-color:red;}
     .p2{background-color:gold;}
     <div class="portfolio p1"></div>
     <div class="portfolio p2"></div>
  4.    .portfolio마우스를 올렸을때    확대 + 회전 + 밝기 + 그림자 강조  css를 적으시오.
    :.portfolio:hover{transform:scale(1.05) rotate(-10deg);
                      filter: brightness(1.05);
                      box-shadow: 0px 4px 12px #ee9b9b;}
  5.   가상선택자의 종류는? 
    5-1.   마우스를 올렸을때          :hover
    5-2.   부모안에서 첫번째 자식요소  :first-child
    5-3.   부모안에서 마지막 자식요소  :last-child

  6.   .portfolio ul태그의 첫번째 li를 선택해서 좋아하는 배경색으로 넣기 
  : .portfolio ul li:first-child {background-color:red;}

■2.  java

1. if 버젼
    1을 입력받으면 1이다   / 2를 입력받으면 2이다 / 3을 입력받으면 3이다.
:if(num==1){"syso("1이다");}
else if(num==2){syso("2이다");}
else if(num==3){syso("3이다");}
2. switch 버젼
    위의 내용을 switch 버젼으로 
switch(num){
    case 1:syso("1이다");break;
    case 2:syso("이다");break;
    case 3:syso("3이다");break;
}
3. 다음 무한반복을 빠져나오는 코드를 적으시오
      int a = -1;
      for(;;){ 
         System.out.println("빠져나오실래요?  0이면 종료");
         a = scanner.nextInt();
         if(a==0) {        }
              }
              :break;


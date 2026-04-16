day010

 - Todo1: css-layout
 - Todo2: java - while,do while

---

### css-layout2

1. line-height:중앙정렬

2. 배치-position - relative(누구안에) + absolute(어디) 좌표
2-(1).position 종류
    -static(기본값),
    -relative(박스 위치o) 
    -absolute(박스 위치x)
    -fixed(브라우저 고정)
    -sticky(스크롤할때 특정 지점에 붙기)

부모: relative(공간확보) / 자식:(원하는 위치 배치)-좌표


### java-while, do while

1.while
:초기값;
 while(조건문){
 처리내용
 증감문
 }
 →반복횟수가 정해지지 않았을때 사용
 ex), 게시판처럼 실시간으로 글의 갯수가 변동되는 게시판에서 사용

 2.do while
:초기값;
 do{
 처리내용
 }while(조건문);
 →무조건 1번은 처리내용을 실행하고 나중에 조건을 비교


### ■4.  복습문제

■ 1. html + css
```
    1. 레이아웃잡는방법은? (   float  ,  position     ,  display    )
    2. box를 왼쪽, 오른쪽에 붙이는 방법은?
    box{float:left;} box{float:right;}
    3. 다음박스를 왼쪽 오른쪽에 배치하려고 한다. 들어가야하는 코드는?
    <style>
      .left{}     .right{}    .clear{}
    </style>
    <div class="box">
      <div class="left">LEFT</div>
      <div class="right">RIGHT</div>
      <div class="clear">안따라갈려고</div>
    </div>

    .left{float:left;}
    .right{float:right;}
    .clear{clear:both;}

    4. 다음li를 왼쪽으로 붙이려고한다. 코드는?
    <style>
      ul{}    li{}
    </style>
    <ul>
      <li>ONE </li><li>TWO</li><li>THREE</li>
    </ul>
    :ul{overflow:hidden;}
     li{float:left;}

    5. 내가 원하는 위치에 top, right, bottom, left 속성을 줘서 원하는 위치에 배치하는 방법은?
     - 부모박스에  (    )코드를 사용해   기준점을 잡고
     - 자식콘텐츠로  (     )를 사용해 배치한다.
    :position:relative , position:absolute
    6.  스크롤할 때 상단에 계속 붙어 있도록 만드는 방법은?  
``` :{position:sticky;}

■ 2. java

```
 1. if버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
    문자를 한개 입력받아 a이면 apple , b이면 banana, c이면 coconut

    :if(ch=='a'){System.out.println("apple");}
    else if(ch=='b'){System.out.println("banana");}
    else if(ch=='c'){System.out.println("coconut");}
 2. switch버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
    문자를 한개 입력받아 a이면 apple , b이면 banana, c이면 coconut

    char ch='\u0000';
    Scanner scanner =new Scanner(System.in);

    System.out.println("a,b,c 중에 입력 > ");  
    ch = scanner.next().charAt(0);

    :swtich(ch){
    case 'a':System.out.println("apple");break;
    case 'b':System.out.println("banana");break;
    case 'c':System.out.println("coconut");}break;
    defalut: System.out.println("a,b,c가 아니다")break;
   
 3. for, while, do while 버젼으로  문제를 풀으시오!  
     1  2  3  4  5


 :	for(int i=1; i<=5; i++) {System.out.print(i);}
		
		int i=1;
		while(i<=5){System.out.print(i); i++;}
	
		int i1=1;
		do {System.out.print(i1); i1++;}while(i1<=5); 
```
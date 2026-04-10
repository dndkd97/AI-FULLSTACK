### layout
1.배치-display

 -속성바꾸기 : display:block, inilne,inline-block,none
 -배치 - 박스들이 어떻게 놓일지 정하는 규칙(정리 도우미) display:flex
        -(a태그)display:block [box]링크확대 = display:block-인라인을 블록(box) 
        -display:none 화면상에 안보이게 숨기기 (h태그에서 주의)
         :div.di p.item a:last-child{display:none;}
        -display:inline > 블록을 인라인으로-한줄로 배치 
         :<display:inline[콘텐츠]>
          <ul class="d1"> <li>apple</li> <li>banana</li> <li>coconut</li> </ul>
          <-display:inline-block [콘텐츠-width 0]-->
          <ul class="d2"> <li>apple</li> <li>banana</li> <li>coconut</li> </ul>

2.flex

flex : flex 컨테이너로 설정 (display:flex)
-{flex-direction:row;} : 가로(row)로 나란히 배치
-{flex-direction: column;} : 세로(column)로 나란히 배치
-{justify-content:space-between;} : 양 끝에 붙고, 나머지는 균등하게 떨어져 배치
-{justify-content:center;  (가로방향 정중앙) =가로,세로 모두 중앙에 배치
  align-items: center;     (세로방향 정중앙)
  height: 200px;}          (전체높이)
  
{flex-wrap: wrap; gap:10px;} : 공간이 부족하면 자동으로 줄바꿈되어 여러 줄에 배치
{align-items: flex-start;} : 세로 방향 위쪽(flex-start)에 맞춰 정렬
{align-items:flex-end;} : 세로 방향 아래쪽(flex-end)에 맞춰 정렬
{flex-grow:1;} : 박스가 남은 공간을 모두 차지


■ 1. html + css (  java는 오후에  eclipse 로  진행합니다    )
```
■ 복습문제  - 빈칸채우기   
    1. 레이아웃을 구성하는 대표적인 방식은 무엇인가?    (      ,       ,      )
    :float,position,display
    2. 박스를 화면의 왼쪽과 오른쪽에 각각 붙여서 배치하려면 어떤 방법을 사용해야 하는가?
      ① position: absolute
      ② float
      ③ display: inline-block
      ④ margin: auto
    :{float-left,right}
    3. 다음li를 왼쪽으로 붙이려고한다. 코드는?
    <style>
      ul { }
      li { }
    </style>
    <ul>
      <li>ONE</li><li>TWO</li><li>THREE</li>
    </ul>

    ① li { float: left; }       
    ② li { display: block; }
    ③ li { position: absolute; }
    ④ li { text-align: left; }
    :ul{overflow:hideen}
     li{float:left}

    4. 원하는 위치에 요소를 배치하기 위해 top, right, bottom, left 속성을 활용하려고 한다.
    부모 박스에는 어떤 속성을 주어 기준을 설정하는가?
    ① position: relative
    ② position: fixed
    ③ display: flex
    ④ margin: auto
    :position:relative
    자식 요소에는 어떤 속성을 사용하여 위치를 지정하는가?
    ① position: absolute
    ② position: sticky
    ③ float
    ④ inline-block
    :position:absolute
   5.  브라우저에 고정되도록 만드는 방법은?   
    :position:fixed;
   6.  a태그의 링크를 확대하려고 한다. 사용해야하는 방법은?
    :display:block
   7.  li태그들을 가로방향으로 배치하려고 한다.  width를 줘야하는데 사용해야하는 방법은?
    :display:inline-block;
   8.  header 안에서 로고와 내비게이션을 양쪽 끝에 배치하고, 콘텐츠 간 간격을 일정하게 유지하려면 어떤 레이아웃 방식을 사용해야 하는가?
    :header{display:felx;
    justify-content:space-between;}
```    

■ 2. java
```


1. if버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
   정수를 하나 입력받아 다음 조건에 따라 성적을 출력하는 프로그램을 작성하시오.
    90점 이상 → "A 학점"
    80점 이상 → "B 학점"
    70점 이상 → "C 학점"
    그 외 → "F 학점"

2. switch버젼에 해당하는 다음에 연결해서 문제를 작성하시오.
   위의 문제를 switch 로
  
    int avg=0;
    Scanner scanner = new Scanner(System.in);
    System.out.print("평균입력 > ");  avg = scanner.nextInt();
    
3. for, while, do while 버젼으로  문제를 풀으시오!  
    1 2 3

4. 이중 for를 이용해서 다음문제를 풀으시오.
  ★★★★
  ★★★★
  ★★★★
  ★★★★
    
  
```

day009

 - Todo1: css-layout
 - Todo2: java-for

 ---

### css-layout

-float: 왼쪽이나 오른쪽에 옆에 붙이기(끊기-clear:both)
-position: 정확한 자리를 정해서 붙이기(좌표)
-display: 블록에 줄서기,속성 바꾸기

-{list-style: none;}: li 리스트 속성 끊기
-{overflow:hidden;}:박스 안 튀어나온 텍스트,그림 삭제
-nth-child:첫번째,마지막 사이의 가상 선택자


### java-for
1.For

1)중괄호 블록내용을 반복적으로 실행할때 사용
2)for
  :반복의 횟수를 알고 있을때 주로 사용
  for(초기문;조건문;증감문){실행블록}
2-1)초기문은 1번만 사용
2-2)조건문이 안맞으면 for문은 종료 

2.for(;;)
:초기문,조건문,증감문 자리가 비워져있따면 아무런 조건을 보지 않기 때문에 무한반복하라는 의미
2-1)break
:-for,whild,do while문의 종료를 의미
 -switch문 종료를 의미
 -반복이 중첩된 경우(for안에 for, 이중for)break;문 가장 가까운 반복문만 종료
 2-2)continue
 :반복취소가 아니라 해당경우에만 skip



### 정리문제
1. 레이아웃잡는방법은? ( float    , position      ,  display    )
2. box를 왼쪽, 오른쪽에 붙이는 방법은?
: box{float:left;}-왼쪽 box{float:right;}-오른쪽 
3. 다음박스를 왼쪽 오른쪽에 배치하려고 한다. 들어가야하는 코드는?
<style>
   .left{}     .right{}    .clear{}
</style>
<div class="box">
  <div class="left">LEFT</div>
  <div class="right">RIGHT</div>
  <div class="clear">안따라갈려고</div>
</div>
:.left{float:left;}
.right{float:right;}
.clear{clear:both;}
4. 다음li를 왼쪽으로 붙이려고한다. 코드는?
<style>
  ul{}    li{}
</style>
<ul>
 <li>ONE </li><li>TWO</li><li>THREE</li>
</ul>
ul{overflow:hidden;}
li{float:left;}
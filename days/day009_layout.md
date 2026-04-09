### css-layout

-float: 왼쪽이나 오른쪽에 옆에 붙이기(끊기-clear:both)
-position: 정확한 자리를 정해서 붙이기(좌표)
-display: 블록에 줄서기,속성 바꾸기

-{list-style: none;}: li 리스트 속성 끊기
-{overflow:hidden;}:박스 안 튀어나온 텍스트,그림 삭제
-nth-child:첫번째,마지막 사이의 가상 선택자




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
ul{list-style:none;}
li{float:left;}
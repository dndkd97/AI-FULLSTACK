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
{flex-grow:1;} : 두 번째 박스가 남은 공간을 모두 차지

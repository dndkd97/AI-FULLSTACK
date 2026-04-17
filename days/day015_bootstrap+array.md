day015
 
 - Todo1: bootstrap
 - Todo2: java-array(2)

---

### CSS-bootstrap
1. 부트스트랩이 들어간 html페이지 만들기 (boot) bootstrap004_self.html
2. div 6개가 들어간 영역 나누기

■색
defauly,primary,success,info,warning,danger,link + subtle(불투명)

-ms:-left
-me:-right

### Array
1.다차원 배열
1)정의
-2차원배열 이상의 배열 의미
-수학의 행렬과 같은 자료구조

2)선언방법
-타입[][]변수;
 int [][] a1 = {{1,2,3},{4,5,6}};
 int [][] a2 = new int[2][3];

---

### 복습문제
■1. html + css + bootstrap
1. 부트스트랩에 해당하는 class와 문제를 풀으시오.

<li class="__________________ ____________________">열정</li>

- 버튼 스타일을 적용하는 기본 클래스
- 버튼 배경색을 빨간색으로 지정
 :btn btn-daner

■2. java (5분)

1. new 연산자 이용하여 다차원배열만들기
2. for + length 이용해서 대입   
3. for + length 이용해서 출력 
   101   102   103
   104   105   106  
: int num=101;
      
for(int i=0; i<arr.length; i++) {
for(int j=0; j<arr[i].length; j++) {
   arr[i][j]=num; num++;
}
}
for(int i=0; i<arr.length; i++) {
for(int j=0; j<arr[i].length; j++) {
   System.out.print(arr[i][j]+"\t");
}System.out.println();
}
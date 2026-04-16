day014

 - Todo1: Bootstrap
 - Todo2: java-array

 ---

### Bootstrap
1.정의
-미리 만들어진 스타일시트와 자바스크립트 플러그인라이브러리
 html 코드에 미리 정의된 [ 클래스 선택자를 삽입 ]만하면 레이아웃과 각종요소 만듬

.container   : 표, 전체박스,아파트
ex)container : 고정폭 레이아웃을 만들 때 사용
   container-fluid : 좌우로 꽉 찬 레이아웃
.row         : 박스안에 줄, 각 층 
.col-sm-칸수  : 칸, 12칸을 기준
ex)xs(for phones)
   sm(for tablets) : 768px이상
   md(for desktops) : 992px이상
   lg(for larger desktops) : 가로해상도 1200px이상
1-1.버튼(Button)
:-<a>,<dl>,<input> 등의 태그에 클래스를 추가하여 버튼 모양 사용가능
 -btn은 공통적으로 적용되는 모양을 정의
 -btn-default는 테두리나 배경색 등을 정의
 -크기(size) 버튼 크기를 정의하는 클래스는 btn-xs,sm,lg
 -btn-block은 버튼을 블록 요소로 만듬
 -disabled를 추가하면 비활성화된 상태의 모양을 만듬
 ex)btn btn-(색상)

■1.템플릿만들기-bootstrap.html(001~003)

### java-array

-new로 선언하는 방법

:int [] arr2 = new int[3];
 int data=10;
 for(int i=0; i<arr2.lenght; i++){arr2[i]=data; data+=10;}

---

### 복습문제

■1. 부트스트랩에 해당하는 class와 문제를 풀으시오.
1. __________
   - 전체 레이아웃을 감싸는 박스  
   - 웹 페이지의 최대 너비를 관리  
   - `container`(고정 폭) / `container-fluid`(가변 폭)
:container
2. __________
   - `container` 안에서 줄(행)을 만드는 역할   
:row
3. __________
   - `row` 안에서 칸(열)을 만드는 역할  
   - 기본 단위는 **12칸**   
:col
4. 4칸으로 균등하게 레이아웃을 지정하려고 한다. 줘야하는것은?
col-sm-3 x4
5. 전체 레이아웃을 감싸는 박스(여백있음) ,  선주기, 두께는 3으로, 둥근모서리 , 좋아하는 색상 , 배경초록색, 글자 하얀색
<div class="container border border-3 rounded border-info bg-success text-white"></div>


■2. JAVA
1.  for, while , do while을 이용해서 문제를 풀으시오.
     3   2   1
:for(int i=3; i>=1; i--) {System.out.print(i);}System.out.println();
		
		int i=3;
		while(i>=1) {System.out.print(i);i--;}System.out.println();
		
		int i2=3;
		do {System.out.print(i2); i2--;}while(i2>=1);System.out.println();
2 이중 for 버전
다음과 같은 모양을 출력하는 프로그램을 작성하시오.
★★★
★★
★
:for(int a=3; a>=1; a--) {
			for(int a1=a; a1>=1; a1--) {
				System.out.print("★");
			}System.out.println();
		}
3.  1차원배열      new 연산자 이용해서 배열만들기
    1. 배열명 : arr     
    2. 값 넣기 :   A B C        for+length 이용서 값 대입
    3. for + length 로 출력 
:/*	char [] arr1 = {'A','B','C'};
		for(int b=0; b<arr.length; b++) {
			
			arr[b]=arr1[b];
			
			System.out.print(arr[b]);} */
		
		char [] arr = new char [3];
			char ch='A';
			for(int b=0; b<arr.length; b++) {
				arr[b]=ch++;
				
				System.out.print(arr[b]);
			}
### animation
1. animation: fadeInUp  1.8s      ease          forwards;
           애니메이션이름 지속시간 등장시속도 애니메이션이 끝날때 마지막 상태 유지  
(1)
 - 시작: opacity 0, translateY(20px)
 - 종료: opacity 1, translateY(0) 
 @keyframes fadeInUp{
   from{opacity: 0; transform: translateY(20px);}
     to{opacity: 1; transform: translateY(0);} }
(2)
 - 시작: translateY(0), scale(1), opacity 0.5
 - 중간: translateY(-300px), scale(1.2), opacity 1
 - 종료: translateY(-600px), scale(0.8), opacity 0
 @keyframes rise{
   0%  {transform:translateY(0)      scale(1);   opacity: 0.5 ;}(opacity:0.5-반투명)-시작:살짝보임
   50% {transform:translateY(-300px) scale(1.2); opacity: 1;   }(opacity:1-완전 불투명)-중간:선명하게 보임
   100%{transform:translateY(-600px) scale(0.8); opacity: 0;  }}(opacity:0-완전 투명)-끝:점점 사라짐
                                                                (scale):크기
(3) 두 번째 카드에 애니메이션 지연을 주려면? 
 -.card를 대상으로 nth-of-type
 -부모를 기준으로   nth-child
(4)
  animation: rise 8s infinite;=무한반복
  animation: rise 8s ease-in;=시작:느리게 중간~끝:점점 빨라짐

### 복습문제
■ 1. html + css  
html + css 익히느라 수고하셨습니다~!
내일은 바로 부트스트랩 진행할께요~~! 


■ 2. java  [25분 안 쪽으로 끝나게 도전이요~!]
```
Scanner scanner = new Scanner(System.in);
System.out.print("숫자 입력(1,2,3) > ");
int day = scanner.nextInt();

1. if 버전
정수를 하나 입력받아 다음 조건에 따라 요일을 출력하는 프로그램을 작성하시오.
1이라면 1이다, 2라면 2이다, 3이라면 3이다    1,2,3이 아니다
:if(day==1) {System.out.println("1이다");}
else if(day==2) {System.out.println("2이다");}
else if(day==3) {System.out.println("3이다");}
else            {System.out.println("1,2,3이 아니다");}

2. switch 버전 - 위의 문제를 switch 문으로 작성하시오.
:switch(day) {
case 1:{System.out.println("1이다");}break;
case 2:{System.out.println("2이다");}break;
case 3:{System.out.println("3이다");}break;
default:{System.out.println("1,2,3이 아니다");}break;}
		
3. for, while, do while 버전
1 2 3 4  
:for(int i=1; i<=4; i++) {System.out.print(i);}System.out.println();
		
int a=1;
while(a<=4) {System.out.print(a); a++;}System.out.println();
		
int b=1;
do {System.out.print(b); b++;}while(b<=4);

4. 이중 for 버전
다음과 같은 모양을 출력하는 프로그램을 작성하시오.
★
★★
★★★
:for(int i=1; i<=3; i++) {
for(int a=1; a<=i; a++) {System.out.print("★");}System.out.println();}
			
5. 1차원배열  다음에 해당하는 값에서 index를 이용하여 3을 출력해주세요!
      int   [] arr2         =    {1,2,3}; 
:System.out.print(arr2[2]);

6. 1차원배열      new 연산자 이용해서 배열만들기
    1. 배열명 : arr     
    2. 값 넣기 : 1.1  , 1.2  , 1.3  , 1.4  , 1.5    
       for+length 이용해보기
    3. for + length 로 출력
:double [] arr = new double[5];
 double data =1.1;   
 for(int i=0; i<arr.length; i++) {arr[i]=data; data+=0.1;}
 for (int i=0; i<arr.length; i++) {System.out.printf("%.1f ",(double)arr[i]);}


```



day012
 - Todo1:  css 정리
 - Todo2:  java 정리

### ■4.  복습문제


■ 1. html + css (  java는 오후에  eclipse 로  진행합니다    )
```
1. float 속성을 사용할 때 부모 요소의 높이가 사라지는 문제를 해결하는 방법은?  
 :overflow:hidden;
2. position: absolute로 자식 요소를 배치할 때, 부모 요소에 반드시 설정해야 하는 속성은?  
 :position:relative;
3. 여러 요소를 가로 또는 세로로 쉽게 배치하기 위해 사용하는 레이아웃 방식은?  
 :display:flex;
4. float와 display의 차이점을 간단히 설명하시오.   
 :float-좌우배치, 여백은 margin으로 / display-배치 방식을 바꿈 여백은 자동으로 맞추는게 가능
5. position: sticky 속성은 어떤 상황에서 유용하게 사용되는가?  
 :스크롤할때 특정 위치에 붙이기
6. margin: auto를 사용하여 블록 요소를 가운데 정렬하려면 어떤 조건이 필요한가?  
 :width값 설정
7. z-index 속성은 어떤 경우에 사용되며, 값이 클수록 어떤 효과가 나타나는가?  
 :요소가 겹칠때 사용되며 값이 클수록 위에 배치(우선순위가 높아짐)
8. header 안에서 로고와 내비게이션을 양쪽 끝에 배치하고 간격을 일정하게 유지하려면 어떤 방법을 사용하는가?  
 :justify-content:space-between;
```    

■ 2. java
```
1. if 버전
정수를 하나 입력받아 다음 조건에 따라 요일을 출력하는 프로그램을 작성하시오.
1 → "월요일"
2 → "화요일"
3 → "수요일"
4 → "목요일"
5 → "금요일"
그 외 → "주말"
:	if(day==1) {System.out.println("월요일");}
	else if(day==2) {System.out.println("화요일");}
	else if(day==3) {System.out.println("수요일");}
	else if(day==4) {System.out.println("목요일");}
	else if(day==5) {System.out.println("금요일");}
	else  {System.out.println("주말");}

2. switch 버전 - 위의 문제를 switch 문으로 작성하시오.
: switch(day) {
	case 1:System.out.println("월요일");break;
	case 2:System.out.println("화요일");break;
	case 3:System.out.println("수요일");break;
	case 4:System.out.println("목요일");break;
	case 5:System.out.println("금요일");break;
	default:System.out.println("주말");break;}
	
```java
Scanner scanner = new Scanner(System.in);
System.out.print("요일 입력(1~7) > ");
int day = scanner.nextInt();
```

3. for, while, do while 버전
1 2 3 4 5 6 7 8 9 10
:for(int i=1; i<=10; i++) {System.out.print(i);}System.out.println();
		            
 int i1=1;
 while(i1<=10) {System.out.print(i1); i1++;}System.out.println();
	
 int i2=1;
 do {System.out.print(i2); i2++;}while(i2<=10);
	 System.out.println();
4. 이중 for 버전
다음과 같은 모양을 출력하는 프로그램을 작성하시오.
 
1234
1234
1234
1234
```
:for(int a=1; a<=4; a++) {
 for(int a1=1; a1<=4; a1++) {System.out.print(a1);}System.out.println();}
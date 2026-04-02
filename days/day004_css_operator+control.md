### CSS기본

CSS(1)
    -1.배경:background
    -2.글자:color
    -3.글자크기:font-size
    -4.정렬:text-align
    -5.밑줄:text-decoration
    -6.글꼴:font-family
    -7.굵게:font-weight
    -8.가로:width
    -9.바깥쪽여백:margin
    -10.안쪽여백:padding
    -11.선:border
    -12.둥근모서리:border-radius 
    -13.그림자효과:box-shadow

### 복습문제
    - 1. css(1)
1. 배경 : background
2. 글자 : color
3. 글자크기 : font-size
4. 정렬 : text-align
5. 밑줄 : text-decoration
6. 글꼴 : font-family
7. 굵게 : font-weight
8. 가로 : width
9. 바깥쪽여백: margin
10. 안쪽여백: padding
11. 선 : border
12. 둥근모서리 : border-radius
13. 그림자효과 : bow-shadow

- 2. java
  1. 자바의 자료형 분류( 기본형  / 참조형  )
  2. 기본형 : 값
    2-1 논리형 : 예) boolean  - true/false (1byte)   
    2-2 정수형 : byte-short-int★-long ( 1 < 2 < 4 <8L)
    2-3 실수형 : float-double★ (4f <8)
    2-4 문자형 : char (2)
  3. 자동형변환은 ( boolean )  빼고  ( byte < short < int < long < float < double ) 기본형


- 3. java [실습]
패키지명 : com.company.java003_ex
클래스명 : CastingEx001
출력내용 :  Scanner이용해서 나누기 프로그램만들기 
   숫자입력1>  _입력받기  10   ( ☆자료형을 int )
   숫자입력2>  _입력받기  3     ( ☆자료형을 int )              
   
   10 / 3 = 3.33

주어진조건 : 
      //변수
      int num1, num2;
      double result;
      Scanner scanner = new Scanner(System.in);


1. System.out.print("1") num1 = scanner.nextInt();
   System.out.print("2") num2 = scanner.nextInt();
   result= (double)num1+num2;
   System.out.printf(num1+"/"+num2+"="+"%.2f",result);
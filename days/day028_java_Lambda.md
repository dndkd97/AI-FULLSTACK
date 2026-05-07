day028

 - Todo :java-Lambda

---

1.Lambda?
- 자바에서 함수적 프로그래밍 지원기법
- 코드 간결하게
- 함수형 인터페이스 : 1개의 추상메서드를 갖는 인터페이스

ex):
package com.the703.basic015;

class RefClass{       void method(String str) {  System.out.println(str);}  }
interface InterUsing{ void inter( RefClass c  , String str); }  

public class Lambda003 {
public static void main(String[] args) {
//#1. 익명클래스
InterUsing a1 = new InterUsing() {
@Override public void inter(RefClass c, String str) { c.method(str);  }
}; a1.inter(new RefClass(), "Hello :)"); //부품객체(RefClass)의 method를 사용

//#2. 람다식 () -> {} [RefClass]의 [method]를 사용
//InterUsing a2 = (RefClass c, String str)-> { c.method(str);  };a2.inter(new RefClass(), "Hello :):)");
InterUsing a2 = (c,str)->c.method(str); //직접구현
a2.inter(new RefClass(), "Hello :):)");//부품객체(RefClass)의 method를 사용

//class RefClass{       void method(String str) {  System.out.println(str);}  }
//interface InterUsing{ void inter( RefClass c  , String str); }  
//#3. ::표현식(참고)
InterUsing a3 =  RefClass::method; //자동연결 1) RefClass 2) method
a3.inter(new RefClass(), "Hello :):):)")

---

<가격별 오름차순>
※package com.the703.days →public class Day028
-1.익명적객체
milks.sort(new Comparator<Milk>() {
@Override public int compare(Milk o1, Milk o2)
{  return Integer.compare(o1.getMprice(), o2.getMprice()); }});
	  
-2.람다식
 milks.sort((o1,o2)-> Integer.compare(o1.getMprice(), o2.getMprice()));
 @FunctionalInterface public interface Comparator<T> {int compare(T o1,T o2);}

-3.참조형 Integer 부품객체에 compare라는 기능박스
// error : milks.sort(Integer::compare); → Milk 객체에서 가격 꺼내야함
milks.sort(Comparator.comparingInt(Milk::getMprice));

---

### 복습문제
Q1. Player DTO 클래스 만들기
속성:
private String name;
private int score;

Q2. List (ArrayList) 출력
2-1. players 이름으로 ArrayList 만들기
2-2. 데이터 추가:
new Player("Mario", 1200),
new Player("Luigi", 1500),
new Player("Peach", 1800),
new Player("Bowser", 900)
new Player("Bowser", 900)

2-3. for + size 이용해서 출력

출력 예시
1   Mario    1200
2   Luigi    1500
3   Peach    1800
4   Bowser   900
5   Bowser   900

Q3. List에서 출력을 보면 Bowser   900  라는 같은데이터를 넣었는데 2개가 나옴. 이유는?
4   Bowser   900
5   Bowser   900


Q4. Set (HashSet) 출력
4-1. setPlayers 이름으로 HashSet 만들기
4-2. 동일한 데이터 넣기 (중복 허용 안됨)
4-3. Iterator 이용해서 출력
출력 예시
1   Mario    1200
2   Luigi    1500
3   Peach    1800
4   Bowser   900

Q5. Map (HashMap) 출력
5-1. mapPlayers 이름으로 HashMap 만들기
5-2.  데이터 넣기 (Key-Value 구조)
mapPlayers.put("mario", new Player("Mario", 1200));
mapPlayers.put("luigi", new Player("Luigi", 1500));
mapPlayers.put("peach", new Player("Peach", 1800));
mapPlayers.put("bowser", new Player("Bowser", 900));
5-3. for-each + entrySet 이용해서 출력
출력 예시
mario   Mario    1200
luigi   Luigi    1500
peach   Peach    1800
bowser  Bowser   900

Q6. 정렬 문제
6-1. List코드에서 익명 클래스로 점수 오름차순 정렬
6-2. 람다식으로 점수 내림차순 정렬
6-3. 메서드 참조로 점수 오름차순 정렬

출력 예시 (오름차순)
코드
Bowser   900
Bowser   900
Mario    1200
Luigi    1500
Peach    1800
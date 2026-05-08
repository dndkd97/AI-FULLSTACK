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

Q3. List에서 출력을 보면 Bowser   900  라는 같은데이터를 넣었는데 2개가 나옴. 이유는? //List는 중복허용
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

:
package com.the703.days;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

class Player{
	private String name;
	private int score;
	public Player() { super();  }
	public Player(String name, int score) { super(); this.name = name; this.score = score; }
	@Override public String toString() { return "Player [name=" + name + ", score=" + score + "]"; }
	@Override public int hashCode() { return Objects.hash(name, score); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return Objects.equals(name, other.name) && score == other.score;
	}
	public String getName() { return name; } public void setName(String name) { this.name = name; }
	public int getScore() { return score; } public void setScore(int score) { this.score = score; }
	
}

public class Day029 {
	public static void main(String[] args) {
		
		System.out.println("List"); //List
		List<Player> players = new ArrayList<>();
		players.add(new Player("Mario", 1200));
		players.add(new Player("Luigi", 1500));
		players.add(new Player("Peach", 1800));
		players.add(new Player("Bowser", 900));
		players.add(new Player("Bowser", 900));
		
//		players.sort(new Comparator<Player>() { //익명클래스
// @Override public int compare(Player o1, Player o2) {  return Integer.compare(o1.getScore(), o2.getScore()); }   });
		
//		players.sort((o1,o2)->Integer.compare(o1.getScore(), o2.getScore())); //람다식
		
		players.sort(Comparator.comparingInt(Player::getScore)); //참조형
		
		//Q3. List-중복허용
		int cnt =0;
		for(int i=0; i<players.size(); i++) {
			System.out.println(++cnt+ "\t"+players.get(i).getName()+"\t"+players.get(i).getScore());
		}
		System.out.println("Set"); //Set
		Set<Player> setPlayers = new HashSet<>();
		setPlayers.add(new Player("Mario", 1200));
		setPlayers.add(new Player("Luigi", 1500));
		setPlayers.add(new Player("Peach", 1800));
		setPlayers.add(new Player("Bowser", 900));
		setPlayers.add(new Player("Bowser", 900));
		cnt=0;
		Iterator<Player> iter = setPlayers.iterator();
		while(iter.hasNext()) {
			Player p = iter.next();
			System.out.println(++cnt+ "\t"+p.getName()+"\t"+p.getScore());
		}
		System.out.println("Map"); //Map
		Map<String,Player> mapPlayers = new LinkedHashMap<>();
		mapPlayers.put("mario", new Player("Mario", 1200));
		mapPlayers.put("luigi", new Player("Luigi", 1500));
		mapPlayers.put("peach", new Player("Peach", 1800));
		mapPlayers.put("bowser", new Player("Bowser", 900));
		
		for(Entry<String, Player> p : mapPlayers.entrySet()) {
			System.out.println(p.getKey()+"\t"+p.getValue().getName()+"\t"+p.getValue().getScore());
		}}}

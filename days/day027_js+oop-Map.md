day027

 - Todo1 : js
 - Todo2 : java - Map

---

### js 복습

1. 출력
:document.write("하이");
 console.log("브라우저확인");

2. 자료형 - var(전역) let(지역) const(상수)
:let num = 10;
 console.log(num+"10"); //20
 console.log(typeof(num),typeof("10")); //number,string
 console.log(num+Number("10")); //문자열을 숫자로

3. 이벤트대상-이벤트-이벤트핸들러
:document.getElementById("아이디값")
 document.getElementsByTagName("태그이름")
 document.querySelector("#id") //css 표현법


- 배열 사용법
(1)
:   console.log(typeof([])); //object
    console.log(typeof({})); //object
    /////////////////////////////////////////////
    console.log("사용법(1) 리터럴 "); 
    const arr1 = [1,2,3];
    for(let i in arr1){console.log(arr1[i]);}

    console.log("사용법(2) 배열생성자-1 "); 
    const arr2 = new Array(1,2,3);
    for(let i in arr2){console.log(arr2[i]);}

    console.log("사용법(3) 배열생성자-2 "); 
    const arr3 = new Array(3);
    arr3[0]=1; arr3[1]=2; arr3[2]=3;
    for(let i in arr3){console.log(arr3[i]);}

    console.log("사용법(4) 원하는 콘텐츠 다  "); 
    const arr4 = new Array();
    arr4[0]= 'dog'; arr4[1]= 7; arr4[2]= '인천';
    for(let i in arr4){console.log(arr4[i]);}

    arr4.push('진돗개'); // 데이터 추가
    for(let i in arr4){console.log(arr4[i]);}

    arr4.pop(); // 데이터 빼기
    for(let i in arr4){console.log(arr4[i]);}

(2)
:   const obj1 = ['Number' ,1,2,3]; // 0 1,2,3
    console.log(obj1);
    console.log(typeof(obj1)); // object
    console.log(obj1[0]); // 첫번째 값 -Number

    const obj2 = {'type':'Object','o1':1,'o2':2};
    console.log(obj2);
    console.log(typeof(obj2));
    console.log(obj2['o1']);
    console.log(obj2.o1);

    function MyCat(name,age){ //대문자 생성자
        this.name = name;
        this.age = age;
        this.hi = function(){console.log(`Hi, 나는 ${this.name},${this.age}살`);};
    }
    const cat1 = new MyCat('철수','3');
    const cat2 = new MyCat('유리','4');
    cat1.hi();
    cat2.hi();

### Collection Framework 복습문제

1. 콜렉션프레임워크
- [ ##1. 배열    ]의 단점을 개선한 클래스 [ ##2. 객체   ]만 저장가능   
- 저장공간의 크기를 [ ##3. 동적    ]으로 관리함. →동적배열

String []       arr = new String[100]; // 자로형 고정, 갯수고정
List<UserInfo> list = new ArrayList<>(); // 내가 원하는 객체(틀), 갯수 무한대

2. 핵심 인터페이스 [##4. 3개 : List , set , Map ]
- 인터페이스를 통해서 틀이 잡혀 있는 방법으로 
  다양한 컬렉션 클래스를 이용함.

  List : ##5.   기차   인덱스여부 [순서:o] ,  중복허용여부 [o] ,  
  				 [add,get,size,remove,contains  ] 
  Set  : ##6.   주머니  인덱스여부 [순서:x] ,  중복허용여부 [x]  ,  
  				 [add,get(순서) x → 향상된 for/Iterator,size,remove,contains    ] 
  Map  : ##7.   사전   [ 키:값 ] - 쌍(Entry),        
  				 [add(x) put,get(key),size,remove,contains   ] 


### java - Map

- Map(사전) - key:value  | put , get(key) , size , remove , contains

:package com.the703.basic014;
 import java.util.HashMap;
 public class Map001 {
	public static void main(String[] args) {
		Map<String, Integer> maps = new HashMap<>();
		maps.put("one",1); //키,값
		maps.put("two",2); //엔트리
		maps.put("three",3);
		
		System.out.println("1 : "+maps);
		System.out.println("2 : "+maps.get("two"));
		System.out.println("3 : "+maps.size());
		
		System.out.println("4-1 : "+maps.remove("two"));
		System.out.println("4-2 : "+maps);
		
		System.out.println("5-1 : "+maps.containsKey("three"));
		System.out.println("5-2 : "+maps.containsValue(2)); // 없는값
		
		System.out.println("6-1 : "+maps.entrySet()); // key:value 한쌍의 묶음
		System.out.println("6-2 : "+maps.keySet()); // key 객체들로만 이뤄진 묶음
		//Entry<String, Integer>
		for( Entry<String, Integer> m:maps.entrySet() ) {
			System.out.println( m.getKey() + "-" + m.getValue());
		}
		//maps.keySet() - [one,three]
		for( String key : maps.keySet()) {
			System.out.println(key + "-" + maps.get(key));
		}//get(key) 키를 주면 값을 줄게
		Iterator<Entry<String, Integer>> iter =maps.entrySet().iterator();
		//#1.반복자 - 알아서처리 → maps.entrySet() 키와 value의 한쌍으로.iterator() 줄을서시오.
		//iter → [one=1, three=3]
		while(iter.hasNext()) { //#2. hasNext() 처리대상확인 iter → [one=1, three=3]
			Entry<String, Integer> m = iter.next();//#3. next() 한개씩꺼내오기
			System.out.println(m.getKey()+"-"+m.getValue());
		}
		Iterator<String> kiter = maps.keySet().iterator();
		//#1.maps.keySet() 키들을 모아서 [one,three] iterator() 줄으서시오
		//   kiter →[one,three]
		while(kiter.hasNext()) {//#2. hasNext() 처리대상확인 kiter →[one,three]
			String key = kiter.next();//#3. next() 한개씩꺼내오기
			System.out.println(key+"-"+maps.get(key));
			}
		}
	}

### 복습문제

Q1. 빈칸 채우기
1.  List는 순서가 [ 있는 ] 구조로 데이터를 관리하며, 중복을 [ 허용 ]
    - 주요 메서드: add, get, size, remove, contains
2. Set은 순서가[ 없는 ] 구조로 데이터를 관리하며,  중복을 [ 허용x ]
    - 주요 메서드: add,get(x) 향상for/Iterator,size,remove,contains
3. Map은 [__키__]와 [__값__]의 쌍으로 데이터를 관리한다. 
    - 주요 메서드: put,get(key),size,remove,containskey,containsValue,entrySet,keySet
 
---

Q2. ArrayList, HashSet, HashMap을 작성하시오.  

1. Milk Dto 클래스 만들기  
   - 속성 : private String mname; private int mprice;  
   :class Milk{
	private String mname; private int mprice;
	public String getMname() { return mname; }  public void setMname(String mname) { this.mname = mname; }
	public int getMprice() { return mprice; }  public void setMprice(int mprice) { this.mprice = mprice; }
	@Override public int hashCode() { return Objects.hash(mname, mprice); }
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Milk other = (Milk) obj;
		return Objects.equals(mname, other.mname) && mprice == other.mprice;}
	@Override public String toString() { return "Milk [mname=" + mname + ", mprice=" + mprice + "]"; }
	public Milk(String mname, int mprice) { super(); this.mname = mname; this.mprice = mprice;}
	public Milk() { super();  }
}

2. milks 이름으로 ArrayList 만들기  
3. 다음의 데이터 넣기  
   new Milk("바나나우유", 1300),  
   new Milk("메론맛우유", 1800),  
   new Milk("커피우유", 1500),  
   new Milk("커피우유", 1500)  
4. for + size 이용해서 데이터 출력  
```
1     바나나우유       1300
2     메론맛우유       1800
3     커피우유         1500
4     커피우유         1500
```
:System.out.println("<List>");
    List<Milk> milks = new ArrayList<>();
    milks.add(new Milk("바나나우유", 1300));
    milks.add(new Milk("메론맛우유", 1800));
    milks.add(new Milk("커피우유", 1500));
    milks.add(new Milk("커피우유", 1500));
    int cnt =0;
    for(int i=0; i<milks.size(); i++) {
        System.out.println(++cnt+ "\t"+milks.get(i).getMname()+"\t"+milks.get(i).getMprice());}
//ver-2	System.out.print("%d %s %d\n", cnt+1,milks.get(i).getMname(),milks.get(i).getMprice());
//ver-3	for(Milk m : milks) {
    //System.out.printf("%d %s %d\n", ++cnt,m.getMname(),m.getMprice()); }

5. sets 이름으로 HashSet 만들기  
6. 다음의 데이터 넣기  
   new Milk("바나나우유", 1300),  
   new Milk("메론맛우유", 1800),  
   new Milk("커피우유", 1500),  
   new Milk("커피우유", 1500)  
7. Iterator 이용해서 데이터 출력   
```
1     바나나우유       1300
2     메론맛우유       1800
3     커피우유         1500
```
:System.out.println("<Set>");
    Set<Milk> sets = new LinkedHashSet<>();
    sets.add(new Milk("바나나우유", 1300));
    sets.add(new Milk("메론맛우유", 1800));
    sets.add(new Milk("커피우유", 1500));
    sets.add(new Milk("커피우유", 1500));
    Iterator<Milk> milkss = sets.iterator(); // Iterator<Milk> iter = sets.iterator(); , 줄세우기
    int cnt1=0;
    while(milkss.hasNext()) { //while(iter.hasNext()){ //처리대상 확인
        Milk m = milkss.next();
        System.out.println(++cnt1 + "\t"+ m.getMname()+"\t"+m.getMprice());}
 
8. maps 이름으로 HashMap 만들기  
9. 다음의 데이터 넣기 (Key-Value 구조)  
   maps.put("banana", new Milk("바나나우유", 1300));  
   maps.put("melon", new Milk("메론맛우유", 1800));  
   maps.put("coffee", new Milk("커피우유", 1500));  
   maps.put("coffee2", new Milk("커피우유", 1500));  

10. for-each + keySet 이용해서 데이터 출력  
```
banana    바나나우유       1300
melon     메론맛우유       1800
coffee    커피우유         1500
coffee2   커피우유         1500
``` 
:System.out.println("<Map>");
    Map<String,Milk> maps = new LinkedHashMap<>();
    maps.put("banana", new Milk("바나나우유", 1300));  
    maps.put("melon", new Milk("메론맛우유", 1800));  
    maps.put("coffee", new Milk("커피우유", 1500));  
    maps.put("coffee2", new Milk("커피우유", 1500)); 
    //   for(String m : maps.keySet()) {
    //	   Milk u = maps.get(m);
    //	   System.out.println(m + "\t"+u.getMname()+"\t"+u.getMprice());}
    for(String key : maps.keySet()) { // for(Entry<String, Milk> e :maps.entrySet()){ // e.getkey(),e.getValue()
        System.out.printf("%s %s %s\n",key,maps.get(key).getMname(),maps.get(key).getMprice());}
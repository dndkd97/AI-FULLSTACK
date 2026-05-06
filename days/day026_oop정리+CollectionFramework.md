day026

 - Todo1 : java-OOP 정리
 - Todo2 : java-콜렉션 프레임워크

---

Repeat001~005_oop - java oop 정리

### Collection Framework

1.저장단위
- 변수 < 배열 < 클래스 < 콜렉션프레임워크 < 파일 < DB

2.콜렉션프레임워크
- [배열]의 단점을 개선한 클래스, 객체(클래스)만 저장가능
- 동적배열

※배열) 같은타입만 묶어서 저장가능, 배열생성시 크기를 저장해서 사용, 추후 변경이 불가능
  String [] arr = new String[3]
  
3. 핵심 인터페이스
1) List - 기차( 순서 o, 중복허용 o )
          add , get , size , remove , contains
2) Set  - 주머니 ( 순서 x, 중복허용 x )
          add , get(x) 향상된for/Iterator , size , remove , contains
3) Map  - 사전 - key, value 쌍
          add(x) put , get(key) , size , remove , contains

---
     

1.콜렉션 프레임워크: [배열]의 단점을 개선한 [객체]만 저장가능 [동적배열]
2.List,Set,Map
-List(기차) - 순서o , 중복o / add,get,size,remove,contains
-Set(주머니) - 순서x , 중복x / add,향상된 for/ Iterator,size,remove,contains
day045

 - Todo1 : spring

---

#3. 스프링

---------------------
#3.  Bean
---------------------

1.  xml   vs  Annotation
>> xml : 운영
>> Annotation : 개발
XML - [운영] , 모든 Bean을 명시적으로 xml에 등록
    - 여러개발자가 같은 설정파일을 공유해서 개발하면 
      수정시 충돌이 일어날 경우가 많음.

2.@Component
- @Component 일반적인 컴포넌트  <bean> 스프링이 관리하는 객체
- @Component 구체화된 형식
   @Controller  웹요청받아서 응답
   @Service     서비스 레이어, 비즈니스 로직
   @Repository  데이터베이스

3. Bean 의존관계주입
   1. @Autowired - 정밀한 의존관계 
      - 프로퍼티, setter, 생성자,, 적용
   2. @Qualifier - 동일한타입의 bean 구분
   3. @Value  단순값
   4. @Resource - 자원연결(  .properties)   

4. component-scan
<context:component-scan  base-package="경로설정"/>


 
#4. 포트포리오 안내 - 팀회의 (주제)

1   JAVA, JSP웹프로그래밍 >  
   [spring + mysql + jsp + mybatis] board + 멤버관리  → 수업예제

2   프로젝트Ⅰ(완성된 웹서비스 플랫폼 프로젝트 리뉴얼)   > 미니프로젝트  (5일)
   1) crud 중점 :  새로운주제 - 관리자
   상품관리 
   재고관리     ....
   프로모션관리  

3   Spring & MyBatis & GPT   
   [spring boot + oracle + 타임리프 + mybatis + api]  → 수업예제    
   
4   프로젝트ⅡBtoC 웹서비스 구축(Spring Framework 활용)       
   2) api → 사용자측

5   Node.js & Express Server & React          
   [node + react]  → 수업예제    

6   프로젝트Ⅲ홍보/마케팅에 활용 가능한 SNS 사이트 제작(Node.js 와 React 활용)   
   back [spring boot +  jpa + jwt + redis + oauth2.0 + api]  
       +
   front[react + next]   → project3

7   MSA & 리눅스 & 클라우드      
    → project3

........................................................
> 이력서준비 / 진도 / 면접
8   Django & Fluter         
9   프로젝트Ⅳ 매출 및 생산성 향상 앱개발[플러터(DART)활용 ]
    → project4
........................................................   

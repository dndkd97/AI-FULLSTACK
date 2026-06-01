day044

 - Todo1 : Spring

---

#1. SPRING?

▶ Step0. jsp
1. mvc1    -  jsp( controller )역할
2. mvc2 - servlet( controller )역할

예) JSP = html + java → web

▶ Step1.  framework
1. framework  [  디자인패턴 + 라이브러리 = 프레임워크 ]
2. 소프트웨어 개발의 뼈대역할

#2. DI

▶ Step2.  ioc + di
1. ioc
 - inversion of control
 - 제어의 역전
 - 인스턴스의 생성~소멸까지 생명주기를 개발자가 아니라 컨테이너가 하는 것
 - pojo ( plain old java object)

  class A{}
  A a1 = new A()

  생성 → 초기화 → 서비스  → 소멸
    ↑                                      ↓
     ----------------------------------
 
   ioc가 아닌경우   - [ 개발자★  → ( Class A)  
                                    → ( Class B)
                                          → ( Class C)     ] 컨테이너

   ioc인      경우   - [ 개발자  ← ( Class A)  
                                    ← ( Class B)
                                         ← ( Class C)★     ] 컨테이너



2. di ( dependency injection : 의존성주입 )
- 각 클래스간의 의존관계를  [설정파일]

* 실습
1. dynamic web project - spring001
2. configure  - [Convert to Maven Project]
3. spring      - add Spring project Nature
4. java se-11 / project facts, build path
5. build path - add Libraries - JUnit 4

구조확인
1. pom.xml         설치 다운로드
            2. src/main/java   실제 자바파일들 위치
            3. src/test/java    실제 테스트파일위치
            4. src/main/webapp   jsp 파일들위치

* SPRING 정리

1.  프레임워크
   - 소프트웨어개발의 뼈대역할 [디자인패턴 + 라이브러리]
2.  IOC
   - 인스턴스 생성~소멸까지 생명주기를 스프링이 관리
3.  DI
   - 각클래스의 의존관계를  [설정파일]을 통해서 컨테이너가 자동연결
4.  BEAN
   -  스프링이 관리하는 객체(부품)
   - beanFactory   ← ApplicationContext

    [AnimalFarm]  (사용)→    [<<interface>>Animal]   
    ↑(삽입)                    ↑(구현)       ↑ (구현)   
    [beans1.xml ]  (생성)→      [Cat     /     Dog]

    >> di? 각클래스의 의존관계를 [설정파일]을통해서 컨테이너가 자동연결

#1. 프레임워크
   - 소프트웨어 개발의    [  #1. 뼈대   ] 역할
   - 실행흐름 담당
#2. IOC
   -  인스턴스 생성~ 소멸까지 [#2. 생명주기]를  [#3. 스프링]이 관리
#3. DI
   각 클래스의 의존관계를 [#4. 설정파일]을통해서 컨테이너가 자동연결
#4. BEAN
   -  [#5. 관리되는 객체]

#5.  예시
---------------------------------
1) 롬복사용하려고함. 생성자, getter/setter까지 자동 생성되게

@Data        #6
class MyA{
   private String name;
   private Animal ani;

   public MyA(String name, Animal ani){
      this.name = name;
      this.ani = ani;
   }
}
---------------------------------
1. setter 방식    #7
  다음에 해당하는 코드를 클래스 설정파일에 셋팅하시오.
     MyA myA = new MyA()  
     myA.setName("sally");
     myA.setAni("cat" );

```
<bean id="cat"  class="com.company.Cat"/>       
<bean  id="myA"  class="com.company.MyA">     #7-1
   <property name="name"   value="sally"/>   #7-2
   <property name="ani"    ref="cat"/>   #7-3
</bean>
```

2.  생성자
다음에 해당하는 코드를 클래스 설정파일에 셋팅하시오.
     MyA myA = new MyA("sally" , "cat" );

```
<bean  id="myA"  class="com.company.MyA">    #8-1
   <constructor-arg   index="0"   value="sally"/>   #8-2
   <constructor-arg   index="1"   ref="ani"/>    #8-3
</bean>
```

3. di-properties
다음과 같이 셋팅설정파일- config/test.properties
name=sally
ani=cat
다음에 해당하는 코드를 클래스 설정파일에 셋팅하시오.

```
<context:property-placeholder location="classpath:config/test.properties"/>   #9-1
<bean  id="myA"  class="com.company.MyA">     #9-2
   <constructor-arg   index="0"   value="${name}"/>   #9-3
   <constructor-arg   index="1"   ref="${ani}"/>   #9-4
</bean>
```


#6.  스프링 - 실습
>  프로젝트만들기 - spring002_db_mysql

    1. dynamic web project - spring002_db_mysql
    2. configure  - [Convert to Maven Project]
    3. spring      - add Spring project Nature
    4. java se-11 / project facts, build path
day 024

 - Todo1 : java-abstract
 - Todo2 : java-interface

part1. 제어문 - 절차지향
part2. OOP   - 객체지향

2-1. 클래스 사용 (클래스 vs 객체)
2-2. 클래스 설정 (static, final, public ■캡슐화)
2-3. 클래스 ■상속
2-4. ■다형성 (부모타입으로 자식타입들 관리)
2-5. ■추상화 (공통적인 속성 뽑기)

---

1. 추상화( abstract )
- 실체화된 객체들 간 공통되는 특성을 추출
- 미완성적인 개념 (new 사용하지 못함)
- 공통된 필드와 메서드의 이름을 통일할 목적

---

1.interface
- 개발코드 변경없이 객체를 바꿔낄수 있는 역할

2.abstract ( Is A : 고양이는 동물이다 ) vs interface ( can do this )
- 추상화 정도가 interface 가 더 높다
1) abstract - 인스턴스변수, 일반메서드, 추상메서드 가질 수 있으나 
2) interface - 상수(public static final) + 추상메서드(public abstract)

3. 프로젝트 진행시 interface 사용하면
다른구성원들이 각각의 부분을 완성할때 까지 기다리지 않고 
규약만 정해놓고 본인부분만 작성

4. 형식
interface 인터페이스명 {
  상수;     // public static final
  추상메서드; // public abstract - {} this 사용불가 
}

class 클래스명 implements 인터페이스명 {}

class 클래스명 extends 클래스명 implements 인터페이스명1, 인터페이스명2{}
  구현력이 없어서 다중상속이 가능

---

### 복습문제

////////////////////////////////////////////////////////////////////////////////////////복습문제 (1)
Q1. 다음의 상속도를 그리시오.
 Animal{ name / eat(), sleep(), poo() }
 ↑   ↑
Cat Dog { @eat(), @sleep(), @poo() }

Q2. 상속도에서  각각의 클래스에서 사용가능한 멤버변수/멤버함수를  적으시오.

abstract class Animal{    
   String name; 
   abstract void eat();   
   abstract void sleep(); 
   abstract void poo();  
}
class Cat  extends Animal{  // 구현클래스 - 고양이는 동물이다
   @Override void eat()   {  System.out.println(super.name + "고양이 냠냠!");  }
   @Override void sleep() {  System.out.println(super.name + "고양이 수면!");  }
   @Override void poo()   {  System.out.println(super.name + "고양이 시원");  }
}
class Dog  extends Animal{  // 구현클래스 - 강아지는 동물이다
   @Override void eat()   {  System.out.println(super.name + "강아지 냠냠!");  }
   @Override void sleep() {  System.out.println(super.name + "강아지 수면!");  }
   @Override void poo()   {  System.out.println(super.name + "강아지 시원");  }
}
public class Abstract001 {
   public static void main(String[] args) {
      //1. abstract  class : 일반클래스 + 설계
      Animal ani = new Animal();   Q3. 이코드에서 오류나는 이유는? :new 메모리 빌리고 객체생성, Animal 초기화 {} 구현부가 없음
    
      Animal ani = null;
      ani = new Cat();   //Q4.    업캐스팅/다운캐스팅 ? :업캐스팅
      ani.name = "sally";   ani.eat();
 
      
      //2. 사용목적
      Animal [] arr = {new Cat() , new Cat() , new Dog() , new Dog() , };
      int cnt=0;
      //Q5.  다음이 출력되게 코드를 작성하시오.
      /*ani1고양이 냠냠!
        ani2고양이 냠냠!
        ani3강아지 냠냠!
        ani4강아지 냠냠!   */
     :for(Animal a : arr) {a.name = "ani"+ ++cnt; a.eat();}
   }
}


//////////////////////////////////////////////////////////////////////////////////////// 복습문제 (2)

// Q6. 오류나는 부분을 주석달고 이유를 적으시오.

class Papa{   int brain; }
class Mama{   int brain; }
class Son extends Papa, Mama{}  //자바에서의 상속은 단일상속

interface Animal2{
   String company="(주) thejoa";    //Q7.  interface에서의 멤버변수에 붙는 키워드는? :static final
   void eat();     //Q8.  interface에서의 멤버함수에 붙는 키워드는? :abstract
}
class Saram implements Animal2{ 
   @Override public void eat() { 
      company="kakao";  
      System.out.println( Animal2.company  + " 랍스탑.... 냠냠 "   );
   }
} 
 

////////////////////////////////////////////////////////////////////////////////////////// 복습문제 (3)

//Q9.  Driver 클래스를 작성하시오.   
class Driver{
    void drive(Vehicle v){
        if(v instanceof MotorCycle) {((MotorCycle) v).helmet();}
        v.run();
    }
}

interface Vehicle {  public void run();    } 
class MotorCycle implements Vehicle {
   @Override   public void run() {   System.out.println("오토바이가 달립니다.");   }
    public void helmat() {   System.out.println("헬멧을 착용합니다.");   }
}
class Car implements Vehicle {
   @Override  public void run() {     System.out.println("자동차가 달립니다.");   }
}
public class InterfaceEx002{
   public static void main(String[] args) {
      Driver driver = new Driver();
      
      Car car = new Car();
      MotorCycle mo = new MotorCycle();
      
      driver.drive(car);
      driver.drive(mo);
   }
}

>> 실행화면
자동차가 달립니다.

헬멧을 착용합니다.
오토바이가 달립니다.     
package com.the703.basic013_ex;

interface Animal { public void sound(); }
	class Dog implements Animal {
	   @Override public void sound() { System.out.println("멍멍!"); }
	   public void playFetch() { System.out.println("강아지가 공을 물어옵니다."); }
	}
	class Cat implements Animal {
	   @Override public void sound() { System.out.println("야옹~"); }
	   public void scratch() { System.out.println("고양이가 발톱을 세웁니다."); }
	}
	class Bird implements Animal {
	   @Override public void sound() { System.out.println("짹짹!"); }
	   public void fly() { System.out.println("새가 하늘을 납니다."); }
	}
	class ZooKeeper{
		void show(Animal animal) {
			animal.sound();
			if(animal instanceof Dog) {((Dog) animal).playFetch();}
			else if(animal instanceof Cat) {((Cat)animal).scratch();}
			else if(animal instanceof Bird) {((Bird)animal).fly();}
		}
	}
public class InterfaceEx003 {
	public static void main(String[] args) {
		 java.util.Scanner sc = new java.util.Scanner(System.in);

	      while (true) {
	         System.out.println("=== 동물원 메뉴판 ===");
	         System.out.println("1. 강아지");
	         System.out.println("2. 고양이");
	         System.out.println("3. 새");
	         System.out.println("0. 종료");
	         System.out.print("선택: ");
	         int choice = sc.nextInt();

	         if (choice == 0) {
	            System.out.println("동물원 관람을 종료합니다.");
	            break;
	         }

	         Animal animal = null;
	         switch (choice) {
	            case 1: animal = new Dog(); break;
	            case 2: animal = new Cat(); break;
	            case 3: animal = new Bird(); break;
	            default: System.out.println("잘못된 선택입니다."); continue;
	         }

	         // ZooKeeper 클래스의 show() 메서드 호출
	         ZooKeeper keeper = new ZooKeeper();
	         keeper.show(animal);
	         System.out.println();
	      }
	      sc.close();
	}

}

package com.the703.basic013_ex;


abstract class Robot{
	String model;
	String name;
	int battery;
	abstract void charge(int levels);
	abstract void move();
	abstract void speack();
}
class CleaningRobot extends Robot{
	String name = "청소로봇";
	@Override void charge(int levels) { System.out.println(name+" 충전중 ... 배터리"+levels+"%"); }
	@Override void move()   { System.out.println(name+": 먼지를 제거합니다!");  }
	@Override void speack() { System.out.print("Robo1 ");  }
	
}
class SecurityRobot extends Robot{
	String name = "경비로봇";
	@Override void charge(int levels) { System.out.println(name+" 태양광 충전 중... 배터리"+levels+"%");  }
	@Override void move()   {  System.out.println(name+": 이상 없음. 안전 확보!"); }
	@Override void speack() {  System.out.print("Robo2 "); }
}
class CookingRobot  extends Robot{
	String name = "요리로봇";
	@Override void charge(int levels) { System.out.println(name+ " 인덕션 충전 중... 배터리"+levels+"%");  }
	@Override void move()   { System.out.println(name+": 오늘의 메뉴는 파스타입니다!");  }
	@Override void speack() {  System.out.print("Robo3 "); }
}

public class AbstractEx001 {
	public static void main(String[] args) {
		  //Robot robot  = new Robot();  // Q1.why? 오류이유? abstract 클래스
	      System.out.println("\n--- 로봇 배열 시뮬레이션 ---");
	      Robot [] bots = { new CleaningRobot(), new SecurityRobot() , new CookingRobot() };
	      int[] levels = { 50, 70, 95 };
//	      for(int i=0; i<bots.length; i++) {
//	    	  bots[i].speack();
//	    	  bots[i].charge(levels[i]);
//	    	  bots[i].speack();bots[i].move(); }
	      int cnt =0;
	      for(Robot a : bots) {
	    	  a.speack(); 
	    	  a.charge(levels[cnt]);
	    	  a.speack(); a.move();
	    	  cnt++; }
	      
//	      for(int i=0; i<bots.length; i++) {
//	    	  bots[i].model = "Robo"+(i+1);
//	    	  bots[i].battery = levels[i];
//	    	  System.out.print(bots[i].model);
//	    	  bots[i].charge();
//	    	  System.out.println(bots[i].battery+"%");
//	    	  bots[i].move();
//	      }
	    	  
	     
	     
	}

}

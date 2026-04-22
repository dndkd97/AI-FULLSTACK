package com.the703.basic010_ex;

	class Sawon3{ 
		    int pay      =10000;     //인스턴스변수 - new - heap area - 생성자관련 - this
		    static int su=10;        //클래스변수 - static - method area - 공용 - 클래스명.su
	//	    static int basicpay=pay; //클래스변수=인스턴스변수 static은 인스턴스 변수(this) 불가
		    static int basicpay2;    //클래스변수 - static - method area - 공용 - 클래스명.변수
		    
		    public static void showSu() {   System.out.println(su);  } //클래스메서드          
	//	    public static void showPay() {   System.out.println(this.pay);  } //클래스메서드,클래스안에서 인스턴스사용
		  
		    public  void  showAll001() {   //인스턴스메서드 (static x)
		       System.out.println(su);  
		       System.out.println(this.pay); // new 객체를 만들어야 사용가능
		    } 
		    public static  void  showAll002() {   //클래스메서드 (static o)
	//	        showAll001();  //인스턴스 메서드 - this 사용 불가
	//	       System.out.println(this.pay); //클래스안에서 인스턴스사용
		    } 
		} 

public class MemberVarEx001 {

	public static void main(String[] args) {
//		-- class Sawon3작성해주세요 
//		1. 인스턴스변수, 클래스변수, 지역변수 를 구분하시오.
//		2. 인스턴스메서드, 클래스메서드 구분하시오.
//		3. 오류나는 이유는?
	
		   Sawon3   sola = new Sawon3();  //지역변수
		   sola.showAll001();
	}

}
//////////////////////////////////////////////////////
/* [RUNTIME DATA AREA]
------------------------------------
[METHOD:정보] sawon3.class , MemberVarEx001.class#1
Sawon3.su=10; Sawon3.basicpay2; Sawon3.basicpay;  Sawon3.showSu() Sawon.All002()
------------------------------------
[HEAP:동적]            |  [STACK:지역]

1번지:{pay=10000   
     showAll001()}    ←  sola[1번지] - 1)new 2)생성자 3)번지
                           main #2
------------------------------------
*/
//////////////////////////////////////////////////////
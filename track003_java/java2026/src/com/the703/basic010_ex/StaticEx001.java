package com.the703.basic010_ex;

class Area1{
	//Area1.pi (클래스 변수-static)
	//Area1.rect(10,5) (클래스 메서드-static)
	static double pi;
    static {pi=3.14159;}
	static double rect(double num1,double num2) {return num1*num2; }
	static double triangle(double num1, double num2) {return (num1*num2)/2; }
}

public class StaticEx001 {
	public static void main(String[] args) {
		   System.out.println("원의 면적    : " + 10 * 10 * Area1.pi);
		   System.out.println("사각형의 면적 : " + Area1.rect(10, 5));
		   //public static 리턴값 메서드명()
		   //public static 50.0(10,5){사각형의 면적}
		   System.out.println("삼각형의 면적 : " + Area1.triangle(10, 5));

	}
}
/*-- class Area1 작성해주세요   ※ pi값은 3.14159
public class StaticEx001{
  public static void main(String[] args) {  
   System.out.println("원의 면적    : " + 10 * 10 * Area1.pi);
   System.out.println("사각형의 면적 : " + Area1.rect(10, 5));
   System.out.println("삼각형의 면적 : " + Area1.triangle(10, 5));
  }
} 

출력내용 : 
원의 면적    : 314.159
사각형의 면적 : 50.0
삼각형의 면적 : 25.0
*/
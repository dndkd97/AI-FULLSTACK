day016

 - Todo1: bootstrap
 - Todo2: java-method

----

### bootstrap

 ■1.bootstrap004_self.html 완성
  -깃허브 자기소개서 업로드

### java-method

1. method

1-1.method의 정의
-코드를 재사용
-실행하고자 하는 명령어들을 {}안에 한꺼번에 모아놓고,메서드 이름이 호출되면 실행되는 기능
-function,method,멤버함수 함수라고도 부름

1-2.사용법
(1)함수정의
(2)함수호출해서 사용

1-3.함수 기본 구조
:명령어들을 {} 안에 한꺼번에 모아놓고, 메서드이름이 호출되면 실행되는 기능
1)함수정의
:public static void main(String [] args){}
-함수명은 처리하는 내용의 의미를 담아서 작성
-함수의 첫글자는 (소)문자 클래스명 클래스의 첫글자는 (대)문자로 작성
-jvm이 제일 먼저 찾아서 프로그램을 실행하는 main()함수안에서 함수정의 불가능

2. method 매개변수

2-1.method 매개변수
-재료,인수,인자,파라미터,알규먼트라고도 부름
-매개변수 파라미터는 처리해야할 데이터를 의미하는데 처리해야할 내용물이 파라미터가 됨.

2-2. method-return 값

3.리턴값

3-1. 메서드가 종료되는 경우
-{}이 끝날때       :명령어들을 다 수행하고 마무리 종료→메서드가 끝날때
-return을 만났을때 :정지버튼→현재 위치에서 메서드 종료, 아래 명령어 실행 x

3-2. return
-현재 실행중인 메서드를 종료하고 호출한 메서드로 돌아감
-반환없는 경우 return 타입대신 void 사용
 ex)public static void ass(){System.out.println("종료");}
-반환있는 경우 return 뒤에 반환값을 지정해줘야함
 ex)public static in one(int a){return 1;}
    public static double add(int a, double b){return a+b;} // a(int) + b(double)
                 //타입이 일치해야함


■ 정리
:함수구조 public static 리턴값(결과물) 메서드명(마법상자 이름) (파라미터:재료) { 할일 }

ex)
(1) System.out.println("1. 당신의 이름은?" + sing());
    ∟ public static String sing() {return " 용감한 자바전사";}

(2) System.out.println("2. 당신의 소개는?" + intro("홍길동",9));
    ∟ public static String intro(String name, int level) 
                                {return " "+name+"님의 레벨은"+level; }

(3) System.out.println("3. 반타작의 저주 > " + spell(9));
    ∟public static double spell(int num) {return (double)num/2;}
	



day 017
 
 - Todo1 : bootstrap 정리+자기소개 페이지 만들기
 - Todo2 : java-Bank ver 2 , StringEquals

 ---

### bootstrap

-자기소개 페이지 만들기- index.html + my.css
 
■ 색상:primary,secondary,success,danger,warning,info,light,dark,black,whitd,transparent
   배경색 그래디언트:bg-(색상).bg-gradient
   투명도 조절:bg-opacity-(10,25,50,75)

table-striped:한 줄씩 색 다르게 나옴
table-bordered:모든 셀에 border 추가,칸 구분
table-hover:마우스 올리면 색 바뀜
table-light:색상 적용

### java method

- method 기본 문제

>정리1 - 놓친 부분 정리

>정리2 - Bank 미니프로젝트

-Bank ver1 : control 제어문
-Bank ver2 : array(3열짜리)배열 ★
※ 옵션
   public static void main(String[] args) {
    //변수                          0   1    2
    String []id=new String[3];       //  one two three
    String []pass = new String[3];   // 1111 2222 3333
    double []balance = new double[3];// 1100 2200 3300   
    int menu=-1;  
    Scanner scanner = new Scanner(System.in);
    } 
-Bank ver3 : method 메서드

-StringEquals
:String id = "abc"; // 기본값 x
 String id2 = "abc"; // 참조감 o
 String id3 = new String("abc"); // id, id2, id3 참조값(주소값)

 System.out.println("1)" + ( id == id2)); // true
 System.out.println("1)" + ( id == id3)); // false

 System.out.println(System.identityHashCode(id));//1746572565
 System.out.println(System.identityHashCode(id2));//1746572565
 System.out.println(System.identityHashCode(id3));//989110044

 System.out.println("3)" + (id.equals(id3))); //ture
 //문자열 비교 equals 이용




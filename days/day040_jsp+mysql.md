day040

 - Todo1: jsp
 - Todo2: mysql

---

### jsp
1. scope (내장객체 유효범위)
-1. application(웹애플리케이션이 실행되고 있는동안, 서버가 꺼질때까지 유지) 
        > session(특정브라우저와 연결된 세션, 브라우저 종료시 소멸) 
            > request(요청:form, a요청) 
                > page(해당jsp 페이지에서만)
                
-2. 객체.setAttribute("속성","값") / 객체.getAttribute("속성")

:       application.setAttribute("name","D.application-웹 애플리케이션 실행");
           session.setAttribute("name","c.session-브라우저종료/로그인 후 아이디 유지");
       	   request.setAttribute("name","B.request-a.jsp → b.jsp 요청할때");
       pageContext.setAttribute("name","A. 현재페이지에서만 유지");

2. error
-1. 4xx : 클라이언트 오류
   404(페이지 없음) / 400(bad quest)
-2. 5xx : 서버오류      
   500(내부 서버 오류) / 502(서버과부하)
* 해결방안
-1. error페이지만들기
-2. [src]-[main]-[webapp]-[WEB-INF]-web.xml 에러처리 설정

### mysql

select (3) - 함수 ( Number, String, Date , if, switch )

1. 시스템의 현재 시각 조회 
select now(); 
select current_time();
select current_date();

2.  요일  ( 0= Mon  , 1=Tue    6=Sun) 
select weekday(now()); -- 1 화요일
select weekday("2026-05-26"); -- 1 화요일

3.  날짜형식  date_format(  날짜지정, '%Y-%m-%d %H:%i-%s' )
select date_format("2023-11-28", "%Y-%m-%d");
select date_format(now(), "%Y-%m-%d");
select date_format(now(), "%Y-%m-%d %H:%i-%s");

참고사항) https://www.w3schools.com/sql/func_mysql_date_format.asp



4.  100일전/ 100일 후  - date_add 
select date_add(now(),interval -10 day);
select date_add(now(), Interval 10 day);
select date_add(now(), interval -3 hour);

YEAR MONTH DAY HOUR MINUTE SECOND
참고사항) https://www.w3schools.com/sql/func_mysql_date_add.asp


5. datediff  /  timestampdiff 
select datediff("2026-05-28", "2026-05-26");
select timestampdiff(hour, "2026-05-28", "2026-05-26");
-- now () , weekday (0=월,6=일) , date_format(날짜,"%Y-%m-%d %H:%i-%s"), date_add

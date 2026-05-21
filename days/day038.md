day038

 - Todo1 : mysql
 - Todo2 : jsp

---

### mysql

#### 1. Number
1.   ceil     올림
2.   floor   내림
3.   round 반올림
4.   mod(숫자 , 나눌 수)   나머지 연산자

#### 2. String
length
-upper / lower

- instr( 문자열, 찾을 문자열 ) - 위치
- substr( 문자열, 시작, 갯수 )  - 문자열일부분 추출
- left( 문자열, 갯수)
- right( 문자열, 갯수)

- concat ( 문자열, 문자열 ) - 문자열연결

- trim()  - ltrim, rtrim  공백제거
- replace (문자열, 찾아서, 바꾸기)
- repeat (문자열, 몇번)
- lpad(문자열, 전체자리수, 특정문자)
- rpad(문자열, 전체자리수, 특정문자)



### jsp

     1. http요청에 대한 응답저장하는 객체
     2. jsp에서 다른페이지로 이동
          (1) sendRedirect      - 브라우저 url을 변경o , request / response객체가 유지안됨.
          (2) RequestDispatcher - 위임(요청전달) ,  
                                - 브라우저 url을 변경x,  request / response객체가 유지 됨.

 //1. utf-8 userage 나이 넘어오는 데이터 확인(getParameter)
 //2. 만약 19세 미만이라면 jsp013_child.jsp 파일 넘기기 (sendRedirect)
 //     아니라면( jsp013_adult.jsp 경로 안보이게 숨기기 - dispatch)

### 복습문제

복습문제   #1~#5로 들어가져있는 부분을 채우세요!
Q1) 다음 form 태그를 완성하시오.
1. 처리해줄경로              :  result.jsp
2. 주소표시창줄 노출여부 o
3. 쿼리스트링으로 해서 넘길때 이름  userage

     <form action="[#1]" method="[#2]" onsubmit="return check()">
      <div class="my-2">
         <label for="userage">나이입력</label> 
         <input type="text" class="form-control" placeholder=""  id="userage" name="[#3]" />
         <button type="submit" class="btn btn-success mt-3 d-block">성인여부</button>
      </div>
    </form>

Q2. 다음과 같이 처리
1. 위의폼      jsp013_implicit.jsp (나이입력받는폼)
2. 처리         result.jsp  처리
                             19세 미만이라면 -   c.jsp    (경로가 바뀜) 
                             19세 이상이라면 -   보여주는 주소표시창줄은   result.jsp   /  보이는화면은   a.jsp      
<%
//1.  나이 넘어오는데이터 확인  (getParameter)    [#4]
//2.  만약 19세 미만이라면 c.jsp 파일 넘기기 (sendRedirect)  [#5]
//    아니라면           a.jsp (경로 안보이게 숨기기 - dispatch 이용)

%>
int userage = Integer.parseInt(request.getParameter("userage"));
if(userage < 19) {response.sendRedirect("jsp013_child.jsp?userage="+userage);  }
else{request.getRequestDispatcher("jsp013_adult.jsp").forward(request,response);}
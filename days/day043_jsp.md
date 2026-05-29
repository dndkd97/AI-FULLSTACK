day043

 - Todo1 : jsp

---

### jsp

1. el
1) 출력 EL(Expression Language, 표현식 언어)
2) 자바코드없이 출력, jstl와 같이 사용

ex)
<p>${"hello"} ${1} ${3.14 } ${'A' } ${"sally"}</p>

2. jstl
1) JavaServer Pages Standard Tag Library
2) 제어문이나 반복문을 태그로 표현
3) jar 파일 다운로드 -[WEB-INF] - [lib]
https://mvnrepository.com/artifact/javax.servlet/jstl/1.2

ex)
<%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
1)if
<c:if test="${10>3}"> 10은 3보다 크다</c:if>

2)choose
<c:set var="num" value="2"/>
<c:choose>
    <c:when test="${num==1}"> 1이다.</c:when>
    <c:when test="${num==2}"> 2이다.</c:when>
    <c:when test="${num==3}"> 3이다.</c:when>
</c:choose>

3) forEach
<c:set var="numbers" value="1,2,3"/>
<c:forEach var="i" items="${numbers}">
${i} <br/>
</c:forEach>
<% //서버에서 list형식으로 셋팅
String [] numbers2 = {"one","two","three"};
request.setAttribute("numbers2", numbers2);
%>

<c:forEach var="i" items="${numbers2}" varStatus="status" >
${status.first} - ${status.index}  -  ${i} <br/>
</c:forEach>
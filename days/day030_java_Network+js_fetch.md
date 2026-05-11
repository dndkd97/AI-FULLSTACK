day030

 - Todo1 :java - Network
 - Todo2 :js - fetch

---

### java- Buffered

1.보조스트림
- 스트림이란? 네트워크,파일,문자,,,,,,,사용연결통로
- new BufferedReader(new InputStreamReader(new FileInputStreamReader(file))) 
-1) new FileInputStreamReader(file) - byte (0101....)
-2) new InputStreamReader      - 바이트를 [문자]스트림으로, 인코딩
-3) new BufferedReader         - 속도향상, (a → a (x) , abc → abc(o))


### java 네트워크 통신

구조)
try {
    //1. Url	
        URL url =new URL("https://www.google.com/");
    //2. 연결객체(HttpUrlConnection)
    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
    //3. 요청설정(Request)
    conn.setRequestMethod("GET"); // 주소표시창줄레 자원요청
    //4. 응답코드(Response)
    int code =conn.getResponseCode(); // 200응답성공/ 404페이지없음/ 500오류
    System.out.println(code);
    //5. 응답데이터
    // #BufferedReader > [프로그램 Network001.java] > BufferedWriter
    BufferedReader br;
    if(code==200) {
        //      한줄씩 속도향상   - 바이트스트림을 문자 스트림 -   응답데이터스트림
        br =new BufferedReader(new InputStreamReader(conn.getInputStream()));
    }
    else {
        br =new BufferedReader(new InputStreamReader(conn.getErrorStream()));
    }
    String line=""; 
    StringBuffer sb = new StringBuffer();
    while((line=br.readLine())!=null) {sb.append(line+"\n");}
    System.out.println(sb.toString());
    br.close(); conn.disconnect();
    
        
    }catch (MalformedURLException e) {  e.printStackTrace(); } catch (IOException e) {
        e.printStackTrace();
}

#### 네이버 개발자센터의 api 이용

---
1. 네이버개발자 - 로그인

2. 애플리케이션 - 사용할 api 설정
Client ID:xuqdAQ1YqKezf_W5e6Fr
Client Secret:LCI2xrrULC

>URL
https://openapi.naver.com/v1/search/news.xml	XML
https://openapi.naver.com/v1/search/news.json	JSON

 > 옵션
   프로토콜    :HTTPS
   HTTP 메서드 :GET
   파라미터    :query	String
> GET /v1/search/news.xml?query=%EC%A3%BC%EC%8B%9D&display=10&start=1&sort=sim HTTP/1.1
> Host: openapi.naver.com
> User-Agent: curl/7.49.1
> Accept: 
> X-Naver-Client-Id: {애플리케이션 등록 시 발급받은 클라이언트 아이디 값}
> X-Naver-Client-Secret: {애플리케이션 등록 시 발급받은 클라이언트 시크릿 값}
---

3. http 통신 이용해서 데이터 가져오기
:try {
    //1. URL 주소확인
    String apiurl="https://openapi.naver.com/v1/search/news.json?query="
    +URLEncoder.encode("etc", "UTF-8"); //##검색어
    URL url = new URL(apiurl);
    
    //2. HttpURLConnection 연결객체
    //GET /v1/search/news.xml?query=%EC%A3%BC%EC%8B%9D&display=10&start=1&sort=sim HTTP/1.1
    HttpURLConnection conn = (HttpURLConnection)url.openConnection();
    
    //3. 요청설정 GET
//			> X-Naver-Client-Id: {애플리케이션 등록 시 발급받은 클라이언트 아이디 값}
//			> X-Naver-Client-Secret: {애플리케이션 등록 시 발급받은 클라이언트 시크릿 값}
//			Client ID:xuqdAQ1YqKezf_W5e6Fr
//			Client Secret:LCI2xrrULC
    conn.setRequestMethod("GET");
    conn.setRequestProperty("X-Naver-Client-Id", "xuqdAQ1YqKezf_W5e6Fr");
    conn.setRequestProperty("X-Naver-Client-Secret", "LCI2xrrULC");
    
    //4. 응답확인
    int code = conn.getResponseCode();
    
    //5. 응답데이터
    BufferedReader br;
    if(code==200) {br =new BufferedReader(new InputStreamReader(conn.getInputStream()));}
    else {br =new BufferedReader(new InputStreamReader(conn.getErrorStream()));}
    String line="";
    StringBuffer sb = new StringBuffer();
    while((line=br.readLine())!=null) {
        sb.append(line+"\n");
    }
    System.out.println(sb.toString());
    br.close(); conn.disconnect();
    
    
}catch(Exception e ) {e.printStackTrace();}



### String,StringBuffer

:	//#1. String
    String str="ABC";
    System.out.println("1. str의 주소 >"+str+" "+System.identityHashCode(str)); 
    //1. str의 주소 >ABC 681842940
    
    str+="D";
    System.out.println("2. str의 주소 >"+str+" "+System.identityHashCode(str));
    //2. str의 주소 >ABCD 135721597
    
    //#2. StringBuffer
    StringBuffer sb =new StringBuffer();
    
    sb.append("ABC");
    System.out.println("3. sb의 주소 >"+sb+" "+System.identityHashCode(sb));
    //3. sb의 주소 >ABC 142257191
    
    sb.append("D");
    System.out.println("4. sb의 주소 >"+sb+" "+System.identityHashCode(sb));
    //4. sb의 주소 >ABCD 142257191

### js-fetch

-Ajax (Asynchronous JavaScript and XML)
비동기 통신 : 페이지 전체를 새로고침 안해도 서버와 데이터를 주고 받을 수 있음
데이터 포맷 : xml, json, csv

1)Ajax-text fetch() 로컬텍스트파일 가져오기

:    function text(){
    //alert('test');
    // 경로  성공시 실패시
    fetch("./data/text1.txt")
    .then(res=>{
        if(!res.ok){throw new Error('파일에러,상태코드: '+res.status);}
        return res.text();
    })
    .then(txt=>{
        document.getElementById("result0").innerHTML=txt;
    })
    .catch(err=>{
        document.getElementById("result0").innerHTML="에러발생: "+err.message;
        console.error(err)
    });
}

2)-fetch()로 로컬 XML 파일 가져오기
  -응답을 .text()로 받아서 DOMParser로 XML 파싱
  -item 태그를 순회하며 name, price 출력하기

:   function showXml2(){
    fetch("./data/xml2.xml")
    .then(res=>res.text())
    .then(xml=>{
        let parser = new DOMParser();
        let xmlDoc = parser.parseFromString(xml,"application/xml")

        let item = xmlDoc.getElementsByTagName("item");
        let name = item[0].getElementsByTagName("name")[0].textContent;
        let price = item[0].getElementsByTagName("price")[0].textContent;

        document.getElementById("xml2").innerHTML=
        `<div><span>${name}</span><span>${price}</span></div>`;
    })
    .catch(err=>{
        document.getElementById("xml2").innerHTML=err.message;
    });
}
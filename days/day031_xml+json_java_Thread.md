day031

 - Todo1 : xml,json
 - Todo2 : java-Thread

---

### xml,json

1. Ajax-xml fetch()로 로컬 XML 파일 가져오기
:function showXml4(){
    fetch("./data/xml4.xml")
    .then(res=>res.text())
    .then(xml=>{
        let parser= new DOMParser();
        let xmlDoc = parser.parseFromString(xml,"application/xml");
        let result="";
        
        let member =xmlDoc.getElementsByTagName("member");
        // for(let i=0; i<member.length; i++){ ver-1
        //   let name = member[i].getElementsByTagName("name")[0].textContent;
        //   let age = member[i].getElementsByTagName("age")[0].textContent;
        //   let address = member[i].getElementsByTagName("address")[0].textContent;
        //   let mobile = member[i].getElementsByTagName("mobile")[0].textContent;
        //   result+=`<div><span>${name}</span>
        //     <span>${age}</span>
        //     <span>${address}</span>
        //     <span>${mobile}</span></div>`;
        // }
        
        for(let me of member){//ver-2
        let name = me.getElementsByTagName("name")[0].textContent;
        let age = me.getElementsByTagName("age")[0].textContent;
        let address = me.getElementsByTagName("address")[0].textContent;
        let mobile = me.getElementsByTagName("mobile")[0].textContent;
        result+=`<div>${name}-${age}-${address}-${mobile}</div>`;
        }

        document.getElementById("xml4").innerHTML=result;
    })
    .catch(err=>{
        document.getElementById("xml3").innerHTML=err.message; });
}

2. Ajax-json fetch() 로컬 정보 가져오기
:function json3(){
    fetch("./data/json3.json")
    .then(res=>res.json())
    .then(json=>{
    let result="";
    for(let me of json){
    result+=`<tr><td>${me.name}</td>
                    <td>${me.age}</td>
                    <td>${me.address}</td>
                    <td>${me.mobile}</td>
                    </tr>`;
    }
    document.querySelector("#resultJson tbody").innerHTML=result;
    })
    .catch(err=>{
    document.querySelector("#resultJson tbody").innerHTML=err.message;
    });
}

### java - Thread

1. Thread
1) 프로세스 : 실행 중인 하나의 프로그램
2) 멀티프로세스 : 동시에 여러 프로세스 실행
3) 구성
 - 자원(Resource) + Thread(자원으로 실제 작업 수행)
 - 모든 프로세스는 최소한 하나의 스레드(main)
 - 같은 프로세스 내의 스레드들은 서로 자원을 공유

* 프로세스 - 실행중인 프로그램
* 프로세스 - 자원 + Thread(실제작업수행)
* 작업수행클래스 - Thread(상속 - run - start), Runnable

구조)
package com.the703.basic018_ex;

import javax.swing.JOptionPane;

class cnt extends Thread{

	@Override
	public void run() {
//		try { Thread.sleep(10); } catch (InterruptedException e) {  e.printStackTrace(); }
		for(int i=10; i>0; i--) {System.out.println(i); try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {  System.out.println("종료"); return; }}}} 

public class ThreadEx001 {
	public static void main(String[] args) {
		Thread cntt = new cnt(); cntt.start();
		String answer = JOptionPane.showInputDialog("사과 알파벳을 입력하세요."); //팝업창
		System.out.println(answer);
		if(answer.equals("apple")) {System.out.println("정답입니다"); cntt.interrupt(); /*cntt 종료*/}
		//  System.out.println(answer.toLowerCase().equals("apple")?"정답":"오답");// -> 다 소문자로 
		else {System.out.println("정답이아니다");}}}

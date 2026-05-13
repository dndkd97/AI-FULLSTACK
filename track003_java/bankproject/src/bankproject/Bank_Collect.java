package bankproject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BankDto{
	private String id;
	private String pass;
	private double balance;
	
	public BankDto(String id, String pass, double balance) {
		super();
		this.id = id;
		this.pass = pass;
		this.balance = balance;
	} 
}
class Bank1{
	List<BankDto>  users;
	public Bank1() { super(); }
	public Bank1(List<BankDto> users) { super(); this.users = users; }
	// 메뉴 - 안에 내용작성
	public void menu() {
		System.out.print("\n\n🌟💰 WELCOME TO BANK SYSTEM 💰🌟\r\n"
				+ "[1] ➕ 계좌 추가 [2] 🔍 계좌 조회 [3] 💵 입금하기 [4] 💸 출금하기 [5] 🗑️ 계좌 삭제  [9]종료\r\n" + "👉 번호를 선택하세요:");
		
	}   
	// 유저추가  (add)
	public void add() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		
		     if(num ==1 ) {}
		else if(num ==2 ) {}
		else if(num ==3 ) {}
		     
		//변수
		//입력 - 사용자에게 정보입력받기
		//처리 
//		users.add( new BankDto("aaa" , "pass" , 1 ) );
		//출력
	}
	// 입금   (get)
	// 출금   (get)
	// 유저삭제(remove)
	// 종료   
}



public class Bank_Collect {

	public static void main(String[] args) {
		List<BankDto>  users = new ArrayList<>();
		Bank1      controller = new Bank1(users);
		controller.menu();
		controller.add();
       System.out.println(controller.users);

	}

}

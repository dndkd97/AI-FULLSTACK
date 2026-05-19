package delivery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class UserDto{
	 private String id;
	 private String pass;
	 private int point;
	 
	 public UserDto() {}
	 public UserDto(String id) { this.id = id; }
	 public UserDto(String id, String pass, int point)  {
	 super(); this.id = id; this.pass = pass; this.point = point; }
	 public String getId() { return id; } 
	 public void setId(String id) { this.id = id; }
	 public String getPass() { return pass; } 
	 public void setPass(String pass) { this.pass = pass; }
	 public int getPoint() { return point; } 
	 public void setPoint(int point) { this.point = point; }
	 @Override public int hashCode() { return Objects.hash(id); }
	 @Override
	 public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		UserDto other = (UserDto) obj;
		return Objects.equals(id, other.id);
	 }
}

class MenuDto{
	private int menuNo;
	private String menuName;
	private int price;
	
	public MenuDto() {}
	public MenuDto(int menuNo, String menuName, int price) {
	super(); this.menuNo = menuNo; this.menuName = menuName; this.price = price;}
	public int getMenuNo() { return menuNo; } 
	public void setMenuNo(int menuNo) { this.menuNo = menuNo; }
	public String getMenuName() { return menuName; } 
	public void setMenuName(String menuName) { this.menuName = menuName; }
	public int getPrice() { return price; } 
	public void setPrice(int price) { this.price = price; }
	@Override
	public int hashCode() {
		return Objects.hash(menuName, menuNo, price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuDto other = (MenuDto) obj;
		return Objects.equals(menuName, other.menuName) && menuNo == other.menuNo && price == other.price;
	}
}

class OrderDto{
    private String userId;
    private String menuName;
    private int count;
    private int totalPrice; 
    
    public OrderDto() {}
	public OrderDto(String userId, String menuName, int count, int totalPrice) {
	super(); this.userId = userId; this.menuName = menuName; this.count = count; this.totalPrice = totalPrice;}
	public String getUserId() { return userId; } 
	public void setUserId(String userId) { this.userId = userId; }
	public String getMenuName() { return menuName; }
	public void setMenuName(String menuName) { this.menuName = menuName; }
	public int getCount() { return count; }
	public void setCount(int count) { this.count = count; }
	public int getTotalPrice() { return totalPrice; }
	public void setTotalPrice(int totalPrice) { this.totalPrice = totalPrice; }
	@Override
	public int hashCode() {
		return Objects.hash(count, menuName, totalPrice, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDto other = (OrderDto) obj;
		return count == other.count && Objects.equals(menuName, other.menuName) && totalPrice == other.totalPrice
				&& Objects.equals(userId, other.userId);
	}
}

class DeliveryController
 {
	List<MenuDto> menus = new ArrayList<>();
	List<UserDto> users = new ArrayList<>();
	List<OrderDto> orders = new ArrayList<>();
	// public DeliveryController(List<UserDto> users) { super(); this.users = users; }
    UserDto loginUser = null;
	Scanner sc = new Scanner(System.in);
	public DeliveryController() {
		menus.add(new MenuDto(1,"치킨",20000));
		menus.add(new MenuDto(2,"피자",23000));
		menus.add(new MenuDto(3,"떡볶이",14000));
		menus.add(new MenuDto(4,"김치찌개",16000));
		menus.add(new MenuDto(5,"짜장면",7000));
	}
	void menu(){
		int menu=-1;
				while(menu!=9) {	
				System.out.println("[1] 회원가입\r\n"
				+ "[2] 로그인\r\n"
				+ "[3] 메뉴조회\r\n"
				+ "[4] 음식주문\r\n"
				+ "[5] 주문내역조회\r\n"
				+ "[6] 주문취소\r\n"
				+ "[7] 포인트조회\r\n"
				+ "[9] 종료");menu = sc.nextInt();
				if(menu==9) {System.out.println("시스템을 종료합니다");}
		   else if(menu>=1 && menu<=7) {
			 //  UserDto user = login();
			 //  if (user == null) { System.out.println("정보확인해주세요.");continue;}
			   switch(menu) {
			   case 1:add(); break;
			   case 2:loginUser = login();
               if (loginUser == null)
               { System.out.println("로그인 실패"); } else { join(); } break;
			   case 3:view(); break;
			   case 4:if(loginCheck())  order();     break;
			   case 5:if(loginCheck())  orderView(); break;
			   case 6:if(loginCheck())  cancel();    break;
			   case 7:if(loginCheck())  pointView(); break;
			   default:System.out.println("번호 입력 오류");
			  }//switch
		 }//else if
	}//while
}//menu
	 public boolean loginCheck() {
	        if (loginUser == null) { System.out.println("로그인 먼저 해주세요."); return false;
	        }  return true; }
	public void add() { //회원가입
		System.out.println("아이디 입력>");String id = sc.next();
		if(users.contains(new UserDto(id))) {System.out.println("중복 아이디입니다"); return;}
		System.out.println("비밀번호 입력>");String pass = sc.next();
		users.add(new UserDto(id,pass,0));
	}
	UserDto login() {// 3.사용자 인증기능
		System.out.print("아이디  입력 > "); String tempid = sc.next();
		System.out.print("비밀번호 입력 > "); String temppass = sc.next();
		for(UserDto u : users) { if(u.getId().equals(tempid) && u.getPass().equals(temppass)){return u;}}
		return null; } 
	public void join() { //로그인
		System.out.printf("%s님 로그인 성공!\n",loginUser.getId());
	}
	public void view() { //메뉴조회
		System.out.println("메뉴판");
		for(MenuDto m : menus) {System.out.println(m.getMenuNo()+"\t"+m.getMenuName()+"\t"+m.getPrice()+"원\t");}
	}
	public void order() { //음식주문
		// UserDto user = login();
		view();
		System.out.println("메뉴 번호 입력>"); int num = sc.nextInt();
		MenuDto no = null;
		for(MenuDto m : menus) {
			if(m.getMenuNo() == num) {no=m;}}
			if(no==null) {System.out.println("주문 실패"); return;
		}System.out.println("수량 입력>"); int count=sc.nextInt();
		int totalprice = no.getPrice()*count;
		orders.add(new OrderDto(loginUser.getId(),no.getMenuName(),count,totalprice));
		int point =totalprice/20;
		loginUser.setPoint(loginUser.getPoint()+point);
		// user.setPoint
		System.out.println("주문완료!");
		System.out.println("결제금액: "+totalprice);
		System.out.println("포인트: "+point);
	}
	public void orderView() { //주문내역조회
		boolean found = false;
	for(OrderDto o : orders) {
		if(o.getUserId().equals(loginUser.getId())) {
		System.out.printf(" 메뉴: %s\n수량: %d\n금액: %d\n",o.getMenuName(),o.getCount(),o.getTotalPrice());
		found=true;}}if(!found) {System.out.println("주문 내역 없음");}
	}
	public void cancel() { //주문취소
		System.out.println("주문 취소 할 메뉴: ");String name =sc.next();
		Iterator<OrderDto> it = orders.iterator();		
		while(it.hasNext()) {
			OrderDto o = it.next();
			if(o.getUserId().equals(loginUser.getId()) //로그인 사용자만 조회
	                && o.getMenuName().equals(name)) {it.remove();
			System.out.println("주문 취소 완료"); return;}
		}System.out.println("주문 취소 실패");
	}
	public void pointView() { //포인트조회
		System.out.printf("%s 님의 포인트: %d\n",loginUser.getId(),loginUser.getPoint());
	}
}
public class Delivery{
	public static void main(String[] args) {
		DeliveryController delivers = new DeliveryController();
		delivers.menu();
	}

}

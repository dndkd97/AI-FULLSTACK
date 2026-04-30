package com.the703.basic014_ex;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

class UserInfo2Dto {
	private int no; 
	private String name; 
	private  int age;
	public UserInfo2Dto() { super();  }
	public UserInfo2Dto(int no, String name, int age) {
		super(); this.setNo(no); this.setName(name); this.setAge(age); }
	@Override public String toString() {
		return "UserInfo2Dto [no=" + getNo() + ", name=" + getName() + ", age=" + getAge() + "]"; }
	@Override public int hashCode() { return Objects.hash(getName()); }
	@Override public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo2Dto other = (UserInfo2Dto) obj;
		return Objects.equals(getName(), other.getName()); }
	public int getNo() { return no; } public void setNo(int no) { this.no = no; }
	public int getAge() { return age; } public void setAge(int age) { this.age = age; }
	public String getName() { return name; } public void setName(String name) { this.name = name; } }
public class SetEx001 {
	public static void main(String[] args) {
		double avg=0;
        Scanner sc = new Scanner(System.in);
		Set<UserInfo2Dto> users = new HashSet<>();
		users.add(new UserInfo2Dto(1, "아이언맨" , 50));
		users.add(new UserInfo2Dto(2, "헐크" , 40));
		users.add(new UserInfo2Dto(3, "캡틴" , 120));
		users.add(new UserInfo2Dto(3, "캡틴" , 120));
		
		for(UserInfo2Dto user : users ) {System.out.println(user.getNo()+" - "+user.getName()+" - "+user.getAge());
		avg+= (user.getAge())/3.0; }
		System.out.println(">찾을 유저이름 :");String name1 = sc.next();

		for(UserInfo2Dto u : users){ 
		if(u.getName().equals(name1)) {System.out.println(u+"\n"+avg); }break;} 
	}

}

package com.the703.basic010_ex;

import com.the703.basic010.UserInfo2;

//import com.the703.basic010.UserInfo;

// 패키지는(폴더) 에서까지 사용가능

public class UserInfoSon2 extends UserInfo2{ 
	public void show() {
		System.out.println("::홍길동 아버지 이름 >" + name); // public
		System.out.println("::홍길동 아버지 비밀번호 >" + safeCode); //protected
		//System.out.println("::홍길동 아버지 집 >" + house); //같은 패키지가 아니어서
		System.out.println("::홍길동 아버지 iQ >" + getiQ()); //privatd:getters+setters
	}
}

package com.the703.service;

import com.the703.dto.AuthDto;
import com.the703.dto.AuthUserDto;
import com.the703.dto.UserDto;

public interface UserService {

	public int      	 insert(UserDto dto);  
	public int findLogin (UserDto dto);
	public UserDto findByUno(int uno);
	public String   findByEmail( String email);
	public String  findByNickname(   String nickname);
	
	
	public     AuthUserDto    readAuth(String email);
	public  int          insertAuth(AuthDto  dto); 
	public UserDto  findByEmailUserInfo(   String email);
	
}


package com.the703.service;

import com.the703.dto.UserDto;

public interface UserService {
	public int insert(UserDto dto);
	public int findLogin(UserDto dto);
	public UserDto findByUno(int uno);
	public String findByEmail(String email);

}

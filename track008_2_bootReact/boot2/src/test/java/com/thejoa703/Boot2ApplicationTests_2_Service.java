package com.thejoa703;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.transaction.annotation.Transactional;

import com.thejoa703.dto.LoginRequest;
import com.thejoa703.dto.UserDto.UserRequestDto;
import com.thejoa703.dto.UserDto.UserResponseDto;
import com.thejoa703.service.UserService;

@SpringBootTest
@Transactional
class Boot2ApplicationTests_2_Service {
	@Autowired UserService userService;
	
	//userService-crud
    private Long createTestUser(String email, String nickname) {
        UserRequestDto signupDto = new UserRequestDto();
        signupDto.setEmail(email);
        signupDto.setPassword("password123");
        signupDto.setNickname(nickname);
        signupDto.setProvider("local");

        MockMultipartFile profileImage = new MockMultipartFile(
                "profileImage", "test.png", "image/png", "test image content".getBytes()
        );

        UserResponseDto res = userService.createUser(signupDto, profileImage); // ###
        return res.getId();
    }
    
   //userService-crud
    @Test
    @DisplayName("userservice")
    void testAppUserService() {
    	Long userId = createTestUser("test1@email.com","test1");
    	
    	LoginRequest loginDto = new LoginRequest();
    	loginDto.setEmail("test1@email.com");
    	loginDto.setPassword("password123");
    	loginDto.setProvider("local");
    	
    	UserResponseDto loginRes = userService.login(loginDto);
    	assertThat(loginRes).isNotNull();
    	assertThat(loginRes.getId()).isEqualTo(userId);
    	
    	//이메일 중복검사 - 존재확인
    	assertThat(userService.existsByEmail("test1@email.com")).isTrue();
    	
    	//닉네임 중복검사 - 존재확인
    	assertThat(userService.existsByNickname("test1")).isTrue();
    	
    	//마이페이지
    	UserResponseDto foundUser = userService.getUser(userId);
    	assertThat(foundUser.getNickname()).isEqualTo("test1");
    	
    	//유저닉네임수정
    	UserResponseDto updateUser = userService.updateNickname(userId,"111");
    	assertThat(updateUser.getNickname()).isEqualTo("111");
    	
    	//유저삭제
    	userService.deleteById(userId);
    	//UserResponseDto deleteUser = userService.getUser(userId);
    	//assertThat(deleteUser).isNull();
    }

	
}

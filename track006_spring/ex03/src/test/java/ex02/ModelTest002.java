package ex02;

import java.net.UnknownHostException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.the703.dao.UserMapper;
import com.the703.dto.AuthDto;
import com.the703.dto.UserDto;
import com.the703.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:config/*-context.xml")
@ContextConfiguration(locations ={"classpath:config/root-context.xml", "classpath:config/security-context.xml"})
public class ModelTest002 {
 @Autowired UserMapper user;
 @Autowired UserService service;
 @Autowired @Qualifier("passwordEncoder")PasswordEncoder pwencoder;
 

 
    /* security */
    @Test public void test2() {
	 
	 AuthDto dto2 = new AuthDto(); dto2.setEmail("a@a");
	 System.out.println(service.readAuth(dto2));
	
//    AuthDto dto1 = new AuthDto(); dto1.setEmail("a@a"); dto1.setAuth("ROLE_MEMBER");
//	 AuthDto dto1 = new AuthDto(); dto1.setEmail("a@a"); dto1.setAuth("ROLE_ADMIN");
//	 System.out.println(user.insertAuth(dto1));
 	 
//	 /* 회원가입(암호화)pwencoder.encode("a") */
//	 UserDto dto = new UserDto();
//	 dto.setNickname("a"); dto.setBpass(pwencoder.encode("a"));
//	 dto.setEmail("a@a"); dto.setMobile("010123"); 
//	 System.out.println(service.insert(dto));
//   System.out.println(pwencoder.encode("a"));
	 
 }
 
 @Ignore @Test public void test1() throws UnknownHostException{
	 //이메일 중복
//	 System.out.println(user.findByEmail("dndkd98@naver.com"));
	// String foundByEmail = user.findByEmail("dndkd98@naver.com");
    // if(foundByEmail != null) { System.out.println(" 존재하는 이메일(중복)입니다. "); } 
    // else { System.out.println(" 사용 가능한 이메일입니다. "); }
	 //마이페이지
//	 System.out.println(service.findByUno(7));
	 //로그인
//     UserDto dto2 = new UserDto();
//     dto2.setBpass("1");   dto2.setEmail("dndkd98@naver.com"); 
//     System.out.println("로그인 > " + service.findLogin(dto2));
	// dto.
	 //회원가입 inesrt
//	 UserDto dto = new UserDto();
//	 dto.setNickname("최다영"); dto.setBpass("1"); dto.setEmail("dndkd98@naver.com"); dto.setMobile("010-1"); 
//	 dto.setBip(InetAddress.getLocalHost().getHostAddress());
//	 System.out.println(user.insert(dto));
	 
 }
 

}

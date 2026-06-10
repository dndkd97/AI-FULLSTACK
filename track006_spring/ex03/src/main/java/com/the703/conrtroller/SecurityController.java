package com.the703.conrtroller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dto.UserDto;
import com.the703.service.UserService;

@Controller
@RequestMapping("/security/*")
public class SecurityController {
	@Autowired UserService service;
	
	@RequestMapping("/all")    public String all() {  return "security/all"; }
	@RequestMapping("/member") public String member() {  return "security/member"; }
	@RequestMapping("/join")   public String join() {  return "security/join"; }
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join_post(UserDto dto, RedirectAttributes rttr){
		String result="회원가입실패";
		if(service.insert(dto)>0) {result="회원가입 성공";}
		rttr.addFlashAttribute("success",result);
		return "redirect:/security/login";
	}
	
	@RequestMapping("/login")  public String login() { return "security/login"; }
	@RequestMapping("/fail")   public String fail() {  return "security/fail"; }
	
	// Authentication - Principal(현재 로그인 한 사용자 정보)
	@RequestMapping("/mypage") public String mypage(Principal principal, Model model) {
		System.out.println(".............."+principal);
		System.out.println("..............."+principal.getName());
		
		model.addAttribute("dto", service.findByEmailUserInfo(principal.getName()));
		return "security/mypage";}
}

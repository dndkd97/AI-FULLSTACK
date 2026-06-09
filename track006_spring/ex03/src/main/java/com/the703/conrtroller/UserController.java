//package com.the703.conrtroller;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.the703.dto.UserDto;
//import com.the703.service.UserService;
//
//@Controller
//public class UserController {
//@Autowired UserService service;
//
//	@RequestMapping(value="/users/login.do", method=RequestMethod.POST)
//	public String loing(UserDto dto,HttpServletRequest session,RedirectAttributes rttr) {
//		int result = service.findLogin(dto);
//		if(result>0) {
//			session.setAttribute("email",dto.getEmail());
//			return "redirect:/users/mypage.do";
//		}
//		else {rttr.addFlashAttribute(rttr)}
//	}
//	
//	@RequestMapping("/users/mypage.do")
//	public String detail(int bno, Model model) {
//	//	model.addAttribute("dto", service.detail(bno));
//		return "users/mypage";
//	}
//	   
//}

package com.the703.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dao.Sboard2Dao;
import com.the703.dto.Sboard2Dto;
import com.the703.service.Sboard2Service;
import com.the703.util.UtilPaging;

@Controller
@RequestMapping("/board") //공동 prefix #1)
public class Sboard2Controller {
	
	@Autowired private Sboard2Service service;
	@Autowired private Sboard2Dao dao;
	
	//1. 전체리스트
	@GetMapping("/list") //#2) /board/list
	public String list(Model model, @RequestParam(value="pageNo", defaultValue = "1") int pageNo) 
	{ 
	  model.addAttribute("paging",new UtilPaging(service.selectCnt(), pageNo));
	  model.addAttribute("list",service.list10(pageNo));
		return "board/list"; 
	} // prefix(/templates) + board/list + suffix(.html)
	
	//2. 글쓰기 폼 /board/white
	@GetMapping("/write")
	public String write() {return "board/write";}
	
	//3. 글쓰기 기능
	@PostMapping("/write")
	public String write_post(Sboard2Dto dto,MultipartFile file, RedirectAttributes rttr) {
		String result = "글쓰기 실패";
		if(service.insert(file, dto)>0) {result="글쓰기 성공";}
		rttr.addFlashAttribute("success", result);
		return "redirect:/board/list";}
	
	//4. 상세보기
	@GetMapping("/detail")
	public String detail(Model model, Sboard2Dto dto, @RequestParam("id")int id) {
		model.addAttribute("dto",service.detail(dto));
		return "board/detail";}
	
	//5. 수정폼 
	@GetMapping("/edit")
	public String edit(Model model, Sboard2Dto dto) {
		model.addAttribute("dto",service.updateForm(dto));
		return "board/edit";}
	
	//5. 수정 기능
	@PostMapping("/edit")
	public String edit_post(Sboard2Dto dto, Model model, 
			MultipartFile file,RedirectAttributes rttr) {
		String result="글수정 실패";
		if(service.update(file, dto)>0) {result="글수정 성공";}
		rttr.addFlashAttribute("success",result);
		return "redirect:/board/detail?id="+dto.getId();}
	
	//7. 삭제폼
	@GetMapping("delete")
	public String delete(Sboard2Dto dto) {
		
		return "board/delete";}
	
	//8. 삭제 기능
	@PostMapping("delete")
	public String delete_post(Sboard2Dto dto, RedirectAttributes rttr) {
			String result="글삭제 실패";
			if(service.delete(dto)>0) {result="글삭제 성공";}
		rttr.addFlashAttribute("success",result);
		return "redirect:/board/list";}

}
/*
1. controller (서비스 빼고 연동)
- view
- 경로

2. controller (서비스 연결)

*/

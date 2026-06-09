package com.the703.conrtroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.the703.dto.MvcboardDto;
import com.the703.service.BoardService;
import com.the703.util.PagingUtil;

@Controller
// @RequestMapping("/borad")
public class BoardController {

	@Autowired
	BoardService service;

	// ■1.전체 리스트
//	@RequestMapping("/board/list.do")
//	public String list(Model model) {
//		model.addAttribute("list", service.selectAll());
//		return "board/list";
//	}// 테스트 : http://localhost:8080/spring003_mvc/board/list.do
	// /view(폴더) + board(폴더)/list(파일명) + .jsp(확장자)
	
	@RequestMapping("/board/list.do")
	public String list(Model model,@RequestParam(value="pstartno", defaultValue = "1")int pstartno) {
		model.addAttribute("paging", new PagingUtil(service.selectCnt(),pstartno)); /* service 전체 갯수 */
		model.addAttribute("list", service.select10(pstartno)); /* list10 */
		return "board/list";
	}
	
	// ■2.글쓰기 폼경로
	@RequestMapping(value = "/board/write.do", method = RequestMethod.GET)
	public String write() {
		return "board/write";
	}// http://localhost:8080/spring003_mvc/board/write.do

	// ■2.글쓰기 기능
	@RequestMapping(value = "/board/write.do", method = RequestMethod.POST)
	public String write_post(MvcboardDto dto, 
			@RequestParam("file") MultipartFile file,
			RedirectAttributes rttr) {
		String result = "글쓰기 실패";
		if (service.insert(dto,file) > 0) {
			result = "글쓰기 성공";
		}
		rttr.addFlashAttribute("result", result); // Flash - 1번만 동작
		return "redirect:/board/list.do";
	 }// response.sendRedirect + alert

	// ■3.글 상세보기
	@RequestMapping("/board/detail.do")
	public String detail(int bno, Model model) {
		model.addAttribute("dto", service.detail(bno));
		return "board/detail";
	}// http://localhost:8080/spring003_mvc/board/detail.do


	   // ■4. 글수정폼 경로
	   @RequestMapping(value="/board/edit.do" , method=RequestMethod.GET)
	   public String edit(int bno, Model model) {
	      model.addAttribute("dto", service.editView(bno));
	       return "board/edit";
	   }//테스트 : http://localhost:8080/spring003_mvc/board/edit.do
	     
	   // ■4. 글수정 기능
	   @RequestMapping( value="/board/edit.do" , method=RequestMethod.POST)
	   public String edit_post(MvcboardDto dto,@RequestParam("file") MultipartFile file, RedirectAttributes rttr) {
	      String result = "비밀번호 확인!";
	      if(service.edit(dto,file) > 0) { result = "수정 성공"; }
	      rttr.addFlashAttribute("result", result);  // Flash - 1번만 동작
	      return "redirect:/board/detail.do?bno="+dto.getBno();  // response.sendRedirect + alert (x)
	   }

//	   ■5.글삭제폼 경로	
//	   @RequestMapping(value="/board/delete.do", method= RequestMethod.GET) 
//	   public String delete(MvcboardDto dto) { return "board/delete"; }
	   
	   @RequestMapping( value="/board/delete.do" , method=RequestMethod.GET )
	   public String delete(int bno, Model model) {
	      model.addAttribute("dto", service.editView(bno));     
	       return "board/delete"; }
	 
//	   ■5.글삭제폼 경로 
	   @RequestMapping(value="/board/delete.do", method= RequestMethod.POST)
	   public String delete_post(int bno,String bpass,RedirectAttributes rttr) {
	    MvcboardDto dto =  new MvcboardDto(); dto.setBno(bno); dto.setBpass(bpass);
		String result="글삭제 실패";
		if(service.delete(dto)>0) {result="글삭제 성공";}
		rttr.addFlashAttribute("result",result);
		return "redirect:/board/list.do";
	}// http://localhost:8080/spring003_mvc/board/delete.do	 
}
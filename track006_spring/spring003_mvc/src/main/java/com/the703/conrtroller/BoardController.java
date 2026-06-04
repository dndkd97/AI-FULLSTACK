package com.the703.conrtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// @RequestMapping("/borad")
public class BoardController {

	@RequestMapping("/board/list.do")
	public String list() {
		return "board/list";
	}//
	@RequestMapping("write.do")
	public String write() {
		return "board/write";
	}
	@RequestMapping("datail.do")
	public String detailj() {
		return "board/datail";
	}
	@RequestMapping("edit.do")
	public String edit() {
		return "board/edit";
	}
	@RequestMapping("delete.do")
	public String delete() {
		return "board/delete";
	}
}

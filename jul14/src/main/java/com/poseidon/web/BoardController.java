package com.poseidon.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	//1. board리스트 보는화면 = board.jsp
	@GetMapping("/board")
	public String board(Model model) {
		//데이터 붙이기하고자 합니다.
		model.addAttribute("name", "1234");
		
		//service에서 메소드를 불러오겠습니다.
		List<BoardDTO> list = service.boardList();
		//나오는 결과값은 모델에 붙인다.
		
		if(!list.isEmpty()) {
			model.addAttribute("list", list);
			return "board";
		} else {
			return "redirect:/"; //리다이렉트 : 다시 컨트롤러 지나갑니다.
		}
			
		
		
	}
	//2. detail 상세보기 화면 = detail.jsp
	@GetMapping("/detail")
	public String detail(HttpServletRequest request) {
		String bno=request.getParameter("bno");
		
		try {
			int no = Integer.parseInt(bno);
			System.out.println("숫자입니다.");
		} catch (Exception e) {
			System.out.println("숫자가 아닙니다.");
		} 
		
		
		/*
		if () {
		} else {
			
		}*/
			
		return "detail";
	}
}

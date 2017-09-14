package com.portfolio.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.portfolio.service.ChatBoardService;

@Controller
@RequestMapping("/board/")
public class BoardController {

	@Inject
	private ChatBoardService chatService;
	
	@RequestMapping(value = "/chatBoard", method = RequestMethod.GET)
	public String chatBoardList(Model model) throws Exception {
		return "/myfolio/board/chatBoard";
		//model.addAttribute("listBoard", chatService.listBoard());
	}
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String chatBoard(Model model) throws Exception {
		return "forward:/myfolio/chatBoard";
		//model.addAttribute("listBoard", chatService.listBoard());
	}
	
	@RequestMapping(value = "/registBoard")
	public void chatBoardRegister(Model model) throws Exception {
		
	}
}

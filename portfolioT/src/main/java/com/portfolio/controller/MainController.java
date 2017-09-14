package com.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/myfolio/")
public class MainController {
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String mainPage() throws Exception {
		return "/myfolio/main";
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String registerGET() throws Exception {
		return "forward:/join/joinPage";
	}
	
	@RequestMapping(value = "/works", method = RequestMethod.GET)
	public String worksPage() throws Exception {
		return "forward:/works/worksPage";
	}
	
	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public String listArticles() throws Exception {
		
		return "forward:/works/news";
	}

	@RequestMapping(value = "/chatBoard", method = RequestMethod.GET)
	public String chatBoard(Model model) throws Exception {
		return "forward:/board/chatBoard";
		//model.addAttribute("listBoard", chatService.listBoard());
	}
	
}

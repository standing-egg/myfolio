package com.portfolio.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.portfolio.domain.Article;
import com.portfolio.service.NewsService;
import com.portfolio.service.SummaryService;

@Controller
@RequestMapping(value = "/works/")
public class WorksController {

	@Inject
	private NewsService newsService;
	@Inject
	private SummaryService summaryService;
	
	@RequestMapping(value = "/worksPage", method = RequestMethod.GET)
	public String worksPage() throws Exception {
		return "/myfolio/works/worksPage";
	}
	
	@RequestMapping(value = "/works", method = RequestMethod.GET)
	public String works() throws Exception {
		return "forward:/main/works";
	}
	
	@RequestMapping(value = "/summary", method = RequestMethod.GET)
	public String summaryPage() throws Exception {
		return "/myfolio/works/summary";
	}
	
	@RequestMapping(value = "/summary", method = RequestMethod.POST)
	public ResponseEntity<List<String>> summaryPage(@RequestBody String article) throws Exception {
		
		ResponseEntity<List<String>> entity = null;
		try {
			entity = new ResponseEntity<>(summaryService.summary(article), HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return entity;
	}
	
	@RequestMapping(value = "/tetris", method = RequestMethod.GET)
	public String startTetris(Model model) throws Exception {
		return "/myfolio/works/tetris";
	}
	
	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public String listArticles(Model model) throws Exception {
		
		newsService.listPeppermint();
		model.addAttribute("articles", newsService.listPeppermint());
		
		return "/myfolio/works/news";
	}
	
	@RequestMapping(value = "/news", method = RequestMethod.POST)
	public ResponseEntity<List<Article>> listArticles(@RequestBody int journalName) throws Exception {
		
		ResponseEntity<List<Article>> entity = null;
		try {
			if (journalName==1) {
				entity = new ResponseEntity<>(newsService.listPeppermint(), HttpStatus.OK);				
			} else if (journalName==2) {
				entity = new ResponseEntity<>(newsService.listHan21(), HttpStatus.OK);				
			} else if (journalName==3) {
				entity = new ResponseEntity<>(newsService.listKhan(), HttpStatus.OK);				
			} else {
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return entity;
	}
	
}

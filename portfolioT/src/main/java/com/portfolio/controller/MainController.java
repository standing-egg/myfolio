package com.portfolio.controller;

//import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.portfolio.domain.Article;
import com.portfolio.domain.ChatBoardVO;
import com.portfolio.domain.MemberVO;
import com.portfolio.service.ChatBoardService;
import com.portfolio.service.MemberService;
import com.portfolio.service.NewsService;
//import com.portfolio.service.NewsServiceImpl;
import com.portfolio.service.SummaryService;

@Controller
@RequestMapping("/myfolio/")
public class MainController {
	
	@Inject
	private MemberService mService;
	@Inject
	private NewsService newsService;
	@Inject
	private SummaryService summaryService;
	@Inject
	private ChatBoardService chatService;

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void mainPage() throws Exception {
		
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void registerGET(MemberVO vo, Model model) throws Exception {
		
	}
	
	@RequestMapping(value = "/checkId", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody int checkId(@RequestBody String mid, Model model) throws Exception {
		return mService.checkId(mid);
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String registerPOST(MemberVO vo, RedirectAttributes rttr) throws Exception {
		mService.registMember(vo);
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/myfolio/main";
	}
	
	@RequestMapping(value = "/works", method = RequestMethod.GET)
	public void worksPage() throws Exception {
		
	}
	
	@RequestMapping(value = "/summary", method = RequestMethod.GET)
	public String summaryPage() throws Exception {
		return "/myfolio/works/summary";
	}
	
	@RequestMapping(value = "/summary", method = RequestMethod.POST)
	public ResponseEntity<List<String>> summaryPage(@RequestBody String article) throws Exception {
		
		/*SummaryService textsummary = new SummaryService();
		List<String> senten = textsummary.summary(article);*/
		ResponseEntity<List<String>> entity = null;
		try {
			//entity = new ResponseEntity<>(senten, HttpStatus.OK);
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
	public String listArticles(/*@RequestBody String journalName,*/ Model model) throws Exception {
		
		/*List<Article> articles = PeppermintCrawler.getArticles();
		TextSummary textsummary = new TextSummary();
		for (int i = 0; i < articles.size(); i++) {
			articles.get(i).setSumArticle(textsummary.summary(articles.get(i).getContent()));			
		}*/
		
		/*NewsServiceImpl newsService = new NewsServiceImpl();
		List<Article> articles = newsService.listPeppermint();
		model.addAttribute("articles", articles);*/
		newsService.listPeppermint();
		model.addAttribute("articles", newsService.listPeppermint());
		
		return "/myfolio/works/news";
	}
	
	@RequestMapping(value = "/news", method = RequestMethod.POST)
	public ResponseEntity<List<Article>> listArticles(@RequestBody int journalName) throws Exception {
		/*NewsServiceImpl newsService = new NewsServiceImpl();
		List<Article> articles = new ArrayList<>();*/
		ResponseEntity<List<Article>> entity = null;
		try {
			if (journalName==1) {
				//articles = newsService.listPeppermint();
				entity = new ResponseEntity<>(newsService.listPeppermint(), HttpStatus.OK);				
			} else if (journalName==2) {
				//articles = newsService.listHan21();
				entity = new ResponseEntity<>(newsService.listHan21(), HttpStatus.OK);				
			} else if (journalName==3) {
				//articles = newsService.listKhan();
				entity = new ResponseEntity<>(newsService.listKhan(), HttpStatus.OK);				
			} else {
				
			}
			//entity = new ResponseEntity<>(articles, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return entity;
	}
	
	@RequestMapping(value = "/chatBoard", method = RequestMethod.GET)
	public void chatBoard(Model model) throws Exception {
		/*return "/myfolio/board/chatBoard";*/
		model.addAttribute("listBoard", chatService.listBoard());
	}
	
}

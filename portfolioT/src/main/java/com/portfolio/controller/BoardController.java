package com.portfolio.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.portfolio.domain.BoardVO;
import com.portfolio.domain.Criteria;
import com.portfolio.domain.PageMaker;
import com.portfolio.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	private BoardService chatService;
	
	@RequestMapping(value = "/chatBoard", method = RequestMethod.GET)
	public String chatBoardList(Criteria cri, Model model) throws Exception {
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(cri);
		pageMaker.setTotalCount(chatService.listCountCriteria(cri));
		
		model.addAttribute("list", chatService.listCriteria(cri));
		model.addAttribute("pageMaker", pageMaker);
		//model.addAttribute("list", chatService.listBoard());
		return "/myfolio/board/chatBoard";
	}
	
	@RequestMapping(value = "/writePage", method = RequestMethod.GET)
	public String registGet(BoardVO vo, Model model) throws Exception {
		return "/myfolio/board/writePage";
	}

	@RequestMapping(value = "/writePage", method = RequestMethod.POST)
	public String registPost(BoardVO vo, RedirectAttributes rttr) throws Exception {
		chatService.writingBoard(vo);
		return "redirect:/board/chatBoard";
	}
	
	@RequestMapping(value = "/readPage&bno={bno}", method = RequestMethod.GET)
	public String readPage(@PathVariable("bno") int bno, Criteria cri, Model model) throws Exception {
		/*PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(cri);
		pageMaker.setTotalCount(chatService.listCountCriteria(cri));
		
		model.addAttribute("list", chatService.listCriteria(cri));
		model.addAttribute("pageMaker", pageMaker);*/
		chatService.readCnt(bno);
		model.addAttribute(chatService.read(bno));
		//model.addAttribute("list", chatService.listBoard());
		return "/myfolio/board/readPage";
	}
	
	@RequestMapping(value = "/upCnt", method = RequestMethod.POST)
	public ResponseEntity<Integer> upCnt(@RequestBody int bno) throws Exception {
		chatService.upCnt(bno);
		ResponseEntity<Integer> entity = new ResponseEntity<Integer>(chatService.read(bno).getUp(), HttpStatus.OK) ;
		
		return entity;
	}
}

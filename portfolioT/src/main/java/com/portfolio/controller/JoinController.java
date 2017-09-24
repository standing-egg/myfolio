package com.portfolio.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.portfolio.domain.MemberVO;
import com.portfolio.service.MemberService;

@Controller
@RequestMapping(value = "/join/")
public class JoinController {

	@Inject
	private MemberService mService;
	
	@RequestMapping(value = "/joinPage", method = RequestMethod.GET)
	public String registerGET() throws Exception {
		System.out.println("aaa");
		return "/myfolio/joinPage";
	}
	
	@RequestMapping(value = "/checkId", method = {RequestMethod.GET, RequestMethod.POST})
	public @ResponseBody int checkId(@RequestBody String mid, Model model) throws Exception {
		return mService.checkId(mid);
	}
	
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String registerPOST(MemberVO vo, RedirectAttributes rttr) throws Exception {
		mService.registMember(vo);
		rttr.addFlashAttribute("msg", "success");
		
		return "redirect:/myfolio/main";
	}
}

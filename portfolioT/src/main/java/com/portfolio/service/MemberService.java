package com.portfolio.service;

import com.portfolio.domain.MemberVO;

public interface MemberService {

	public void registMember(MemberVO vo)throws Exception;
	
	public MemberVO readMember(String mid)throws Exception;

	public MemberVO login(String mid, String mpw)throws Exception;
	
	public Integer checkId(String mid) throws Exception;
}

package com.portfolio.persistence;

import com.portfolio.domain.MemberVO;

public interface MemberDAO {

	public String getTime();
	
	public void insertMember(MemberVO vo);
	
	public MemberVO readMember(String mid) throws Exception;

	public MemberVO login(String mid, String mpw) throws Exception;
	
	public Integer checkId(String mid) throws Exception;
}

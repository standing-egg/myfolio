package com.portfolio.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.portfolio.domain.MemberVO;
import com.portfolio.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	private MemberDAO dao;
	
	@Override
	public void registMember(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.insertMember(vo);
	}

	@Override
	public MemberVO readMember(String mid) throws Exception {
		// TODO Auto-generated method stub
		return dao.readMember(mid);
	}

	@Override
	public MemberVO login(String mid, String mpw) throws Exception {
		// TODO Auto-generated method stub
		return dao.login(mid, mpw);
	}

	@Override
	public Integer checkId(String mid) throws Exception {
		// TODO Auto-generated method stub
		return dao.checkId(mid);
	}

}

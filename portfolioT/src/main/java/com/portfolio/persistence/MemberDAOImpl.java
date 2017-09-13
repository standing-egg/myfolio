package com.portfolio.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.portfolio.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Inject
	private SqlSession sqlSession;
	
	private static final String namespace = "com.portfolio.mapper.MemberMapper";
	
	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert(namespace+".insertMember", vo);
	}

	@Override
	public MemberVO readMember(String mid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".selectMember", mid);
	}

	@Override
	public MemberVO login(String mid, String mpw) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		map.put("mid", mid);
		map.put("mpw", mpw);
		return sqlSession.selectOne(namespace+".readWithPW", map);
	}

	@Override
	public Integer checkId(String mid) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(namespace+".checkId", mid);
	}

}

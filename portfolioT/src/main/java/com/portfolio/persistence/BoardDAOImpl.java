package com.portfolio.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.portfolio.domain.BoardVO;
import com.portfolio.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO{

	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.portfolio.mapper.boardMapper";

	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".getTime");
	}

	@Override
	public List<BoardVO> listBoard() throws Exception {
		// TODO Auto-generated method stub
		return session.selectList("list", namespace+".list");
	}

	@Override
	public void register(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".writing", vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".read", bno);
	}

	@Override
	public List<BoardVO> listPage(int page) throws Exception {
		// TODO Auto-generated method stub
		if(page <= 0) {
			page = 1;
		}
		page = (page - 1) * 10;
		return session.selectList(namespace+".listPage", page);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectList(namespace+".listCriteria", cri);
	}

	@Override
	public int countPaging(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".countPaging", cri);
	}

	@Override
	public void readCnt(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".readCnt", bno);
	}

	@Override
	public void upCnt(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".upCnt", bno);
	}
		
}

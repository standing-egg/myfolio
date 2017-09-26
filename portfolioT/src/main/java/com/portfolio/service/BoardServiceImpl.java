package com.portfolio.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.portfolio.domain.BoardVO;
import com.portfolio.domain.Criteria;
import com.portfolio.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO dao;
	
	@Override
	public List<BoardVO> listBoard() throws Exception {
		// TODO Auto-generated method stub
		return dao.listBoard();
	}

	@Override
	public void writingBoard(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.register(vo);
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(bno);
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.countPaging(cri);
	}

	@Override
	public void readCnt(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		dao.readCnt(bno);
	}

	@Override
	public void upCnt(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		dao.upCnt(bno);
	}

}

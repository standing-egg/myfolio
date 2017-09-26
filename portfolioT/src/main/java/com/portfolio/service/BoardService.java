package com.portfolio.service;

import java.util.List;

import com.portfolio.domain.BoardVO;
import com.portfolio.domain.Criteria;

public interface BoardService {

	public List<BoardVO> listBoard() throws Exception;
	
	public void writingBoard(BoardVO vo) throws Exception;
	
	public BoardVO read(Integer bno) throws Exception;
	
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	
	public int listCountCriteria(Criteria cri) throws Exception;
	
	public void readCnt(Integer bno) throws Exception;
	
	public void upCnt(Integer bno) throws Exception;
	
}

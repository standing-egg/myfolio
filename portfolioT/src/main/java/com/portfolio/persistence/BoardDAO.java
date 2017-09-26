package com.portfolio.persistence;

import java.util.List;

import com.portfolio.domain.BoardVO;
import com.portfolio.domain.Criteria;

public interface BoardDAO {

	public String getTime();
	
	public List<BoardVO> listBoard() throws Exception;
	
	public void register(BoardVO vo) throws Exception;
	
	public BoardVO read(Integer bno) throws Exception;
	
	public List<BoardVO> listPage(int page) throws Exception;
	
	public List<BoardVO> listCriteria(Criteria cri) throws Exception;
	
	public int countPaging(Criteria cri) throws Exception;
	
	public void readCnt(Integer bno) throws Exception;
	
	public void upCnt(Integer bno) throws Exception;
}

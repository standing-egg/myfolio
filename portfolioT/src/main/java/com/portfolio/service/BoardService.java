package com.portfolio.service;

import java.util.List;

import com.portfolio.domain.BoardVO;

public interface BoardService {

	public List<BoardVO> listBoard() throws Exception;
	
	public void writingBoard(BoardVO vo) throws Exception;
	
	public BoardVO read(Integer bno) throws Exception;
}

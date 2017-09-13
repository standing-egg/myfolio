package com.portfolio.persistence;

import java.util.List;

import com.portfolio.domain.ChatBoardVO;

public interface ChatBoardDAO {

	public String getTime();
	
	public List<ChatBoardVO> listBoard();
}

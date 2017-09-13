package com.portfolio.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.portfolio.domain.ChatBoardVO;
import com.portfolio.persistence.ChatBoardDAO;

@Service
public class ChatBoardServiceImpl implements ChatBoardService{

	@Inject
	private ChatBoardDAO dao;
	
	@Override
	public List<ChatBoardVO> listBoard() {
		// TODO Auto-generated method stub
		return dao.listBoard();
	}

}

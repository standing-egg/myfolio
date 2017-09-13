package com.portfolio.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.portfolio.domain.ChatBoardVO;

@Repository
public class ChatBoardDAOImpl implements ChatBoardDAO{

	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.portfolio.mapper.chatBoardMapper";

	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".getTime");
	}

	@Override
	public List<ChatBoardVO> listBoard() {
		// TODO Auto-generated method stub
		return session.selectList("chatList", namespace+".listBoard");
	}
		
}

package com.portfolio.service;

import java.util.List;

import com.portfolio.domain.Article;

public interface NewsService {
	
	public List<Article> listPeppermint() throws Exception;

	public List<Article> listHan21() throws Exception;
	
	public List<Article> listKhan() throws Exception;
}

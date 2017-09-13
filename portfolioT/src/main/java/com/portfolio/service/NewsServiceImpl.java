package com.portfolio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.crawler.Han21Crawler;
import com.portfolio.crawler.KhanCrawler;
import com.portfolio.crawler.PeppermintCrawler;
import com.portfolio.domain.Article;

@Service
public class NewsServiceImpl implements NewsService{

	@Override
	public List<Article> listPeppermint() throws Exception {
		// TODO Auto-generated method stub
		List<Article> articles = PeppermintCrawler.getArticles();
		SummaryService textsummary = new SummaryService();
		for (int i = 0; i < articles.size(); i++) {
			//System.out.println(i);
			articles.get(i).setSumArticle(textsummary.summary(articles.get(i).getContent()));
		}
		return articles;
	}

	@Override
	public List<Article> listHan21() throws Exception {
		// TODO Auto-generated method stub
		List<Article> articles = Han21Crawler.getArticles();
		SummaryService textsummary = new SummaryService();
		for (int i = 0; i < articles.size(); i++) {
			//System.out.println(i);
			articles.get(i).setSumArticle(textsummary.summary(articles.get(i).getContent()));
		}
		return articles;
	}

	@Override
	public List<Article> listKhan() throws Exception {
		// TODO Auto-generated method stub
		List<Article> articles = KhanCrawler.getArticles();
		SummaryService textsummary = new SummaryService();
		for (int i = 0; i < articles.size(); i++) {
			//System.out.println(i);
			articles.get(i).setSumArticle(textsummary.summary(articles.get(i).getContent()));
		}
		return articles;
	}

}

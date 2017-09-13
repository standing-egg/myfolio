package com.portfolio.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.portfolio.domain.Article;

public class KhanCrawler {

	public static List<Article> getArticles() throws IOException {
		String link = "http://www.khan.co.kr";
		List<Article> news = new ArrayList<Article>();
		Document doc = Jsoup.connect(link).get();
		Element element = doc.select(".mainLeft .clt").get(0);
		Elements titles = element.select(".hd_title a:not([class=^last])");
		
		for (Element e : titles) {
			Article article = new Article();
			article.setJournal("경향신문");
			article.setJournalLink(link);
			article.setTitle(e.text());
			String url = e.getElementsByAttribute("href").attr("href");
			article.setHref(url);
			doc = Jsoup.connect(url).get();
			Elements content = doc.select(".art_body p");
			StringBuilder text = new StringBuilder();
			for (Element cont : content) {
				text.append(RegExp.getText(cont.html())+" ");
			}
			article.setContent(text.toString());
			news.add(article);
		}
		//System.out.println(news.get(2).getContent());
			
		return news;
	}
	
	/*public static void main(String[] args) throws IOException {
		String link = "http://www.khan.co.kr";
		List<Article> news = new ArrayList<Article>();
		Document doc = Jsoup.connect(link).get();
		Element element = doc.select(".mainLeft .clt").get(0);
		Elements titles = element.select(".hd_title a:not([class=^last])");
		System.out.println(element.children().size());
		
		for (Element e : titles) {
			Article article = new Article();
			article.setJournal("경향신문");
			article.setJournalLink(link);
			article.setTitle(e.text());
			String url = e.getElementsByAttribute("href").attr("href");
			article.setHref(url);
			doc = Jsoup.connect(url).get();
			Elements content = doc.select(".art_body p");
			StringBuilder text = new StringBuilder();
			for (Element cont : content) {
				text.append(RegExp.getText(cont.html())+" ");
			}
			System.out.println(article.getTitle());
			article.setContent(text.toString());
			news.add(article);
		}
	}*/
}

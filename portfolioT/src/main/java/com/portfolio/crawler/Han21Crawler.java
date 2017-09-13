package com.portfolio.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.portfolio.domain.Article;

public class Han21Crawler {

	public static List<Article> getArticles() throws ClientProtocolException, IOException {
		String link = "http://h21.hani.co.kr/";
		List<Article> news = new ArrayList<Article>();
		Document doc = Jsoup.connect(link).get();
		Element element = doc.select("div.table_home_sub").get(0);
		Elements titles = element.select(".title1 a:not([href^=https://])");

		for (Element e : titles) {
			Article article = new Article();
			article.setJournal("한겨레21");
			article.setJournalLink(link);
			article.setTitle(e.text());
			String url = "http://h21.hani.co.kr"+e.getElementsByAttribute("href").attr("href");
			article.setHref(url);
			doc = Jsoup.connect(url).get();
			Elements content = doc.select("div.text");
			StringBuilder text = new StringBuilder();
			for (Element cont : content) {
				text.append(RegExp.getText(cont.html()) + " ");
			}
			article.setContent(text.toString());
			news.add(article);
		}

		return news;
	}

	/*public static void main(String[] args) throws ClientProtocolException, IOException {

		List<Article> news = new ArrayList<Article>();
		Document doc = Jsoup.connect("http://www.hani.co.kr/").get();
		Element element = doc.select("div.article-serial").get(0);
		Elements titles = element.select("h4 a");
		System.out.println(titles.toString());
		for (Element e : titles) {
			Article article = new Article();
			article.setTitle(e.text());
			String url = "http://www.hani.co.kr"+e.getElementsByAttribute("href").attr("href");
			article.setHref(url);
			doc = Jsoup.connect(url).get();
			Elements content = doc.select("div.text");
			StringBuilder text = new StringBuilder();
			for (Element cont : content) {
				text.append(cont.text());
			}
			article.setContent(text.toString());
			news.add(article);
		}
		//System.out.println(news.get(2).getContent());
	}*/
}

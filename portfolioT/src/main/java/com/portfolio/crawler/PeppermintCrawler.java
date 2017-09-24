package com.portfolio.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.portfolio.domain.Article;

public class PeppermintCrawler {
		
	public static List<Article> getArticles() throws IOException {
		String link = "http://newspeppermint.com/";
		List<Article> news = new ArrayList<Article>();
		Document doc = Jsoup.connect(link).get();
		Element element = doc.select("ul.block2").get(0);
		Elements titles = element.select("h6 a");
		
		//for (Element e : titles) {
		for (int i=0; i<8; i++) {
			Article article = new Article();
			article.setJournal("뉴스페퍼민트");
			article.setJournalLink(link);
			article.setTitle(titles.get(i).text());
			String url = titles.get(i).getElementsByAttribute("href").attr("href");
			article.setHref(url);
			doc = Jsoup.connect(url).get();
			Elements content = doc.select(".main-content p:not(.comments p)");
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
		
	
	/*public static void main(String[] args) throws ClientProtocolException, IOException {
		
		List<Article> news = new ArrayList<Article>();
		Document doc = Jsoup.connect("http://newspeppermint.com/").get();
		Element element = doc.select("ul.block2").get(0);
		Elements titles = element.select("h6 a");
		
		for (Element e : titles) {
			Article article = new Article();
			article.setTitle(e.text());
			String url = e.getElementsByAttribute("href").attr("href");
			article.setHref(url);
			doc = Jsoup.connect(url).get();
			Elements content = doc.select(".main-content p:not(.comments p)");
			StringBuilder text = new StringBuilder();
			for (Element cont : content) {
				text.append(cont.text());
			}
			article.setContent(text.toString());
			news.add(article);
		}
		System.out.println(news.get(2).getContent());
		
	}*/
}

package com.portfolio.domain;

import java.util.List;

public class Article {

	private	String journal;
	private String journalLink;
	private String title;
	private String href;
	private String content;
	private List<String> sumArticle;
	
	public String getJournal() {
		return journal;
	}
	public void setJournal(String journal) {
		this.journal = journal;
	}
	public String getJournalLink() {
		return journalLink;
	}
	public void setJournalLink(String journalLink) {
		this.journalLink = journalLink;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<String> getSumArticle() {
		return sumArticle;
	}
	public void setSumArticle(List<String> sumArticle) {
		this.sumArticle = sumArticle;
	}
	
}

package com.portfolio.summary;

import java.util.Map;

public class Sentence {

	String text;
	Map<String, Integer> count;
	float jaccard;
	
	public Sentence(String text) {
		super();
		this.text = text;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Map<String, Integer> getCount() {
		return count;
	}
	public void setCount(Map<String, Integer> count) {
		this.count = count;
	}
	public float getJaccard() {
		return jaccard;
	}
	public void setJaccard(float jaccard) {
		this.jaccard = jaccard;
	}

}

package com.portfolio.domain;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private int displayPageNum = 10;
	private Criteria cri;
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}
	
	private void calcData() {
		endPage = (int) (Math.ceil(cri.getPage() / (double)displayPageNum) * displayPageNum);
		startPage = (endPage - displayPageNum) + 1;
		int totalPage = (int) Math.ceil(totalCount / (double)cri.getPerPageNum());
		if (endPage > totalPage) {
			endPage = totalPage;
		}
		
		prev = startPage == 1 ? false : true;
		next = endPage < totalPage ? true : false;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public Criteria getCri() {
		return cri;
	}

	public void setCriteria(Criteria cri) {
		this.cri = cri;
	}
	
	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount
				+ ", startPage=" + startPage 
				+ ", endPage=" + endPage 
				+ ", prev=" + prev 
				+ ", next=" + next 
				+ ", displayPageNum=" + displayPageNum 
				+ ", cri=" + cri + "]";
	}
	
	public String makeQuery(int page) throws Exception{
		UriComponents uriComponents =
				UriComponentsBuilder.newInstance()
				.queryParam("page", page).build();
		
		return uriComponents.toString();
	}
	
}

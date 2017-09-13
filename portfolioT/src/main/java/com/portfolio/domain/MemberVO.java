package com.portfolio.domain;

import java.util.Date;

public class MemberVO {

	private int mno;
	private String mid;
	private String mpw;
	private String email;
	private Date regdate;
	private int level;
	private int exp;
	private String about;
	private int buddy;
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public int getBuddy() {
		return buddy;
	}
	public void setBuddy(int buddy) {
		this.buddy = buddy;
	}
	/*public MemberVO(String mid, String mpw, String email, String about) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.email = email;
		this.about = about;
	}*/
	
}

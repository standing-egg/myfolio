package com.portfolio.domain;

import java.util.Date;

public class ReplyVO {

	private Integer rno;
	private Integer bno;
	private Integer mno;
	private String rtext;
	private Date regdate;
	private Date updatedate;
	private Integer rorder;
	private Integer parent;
	
	public Integer getRno() {
		return rno;
	}
	public void setRno(Integer rno) {
		this.rno = rno;
	}
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public Integer getMno() {
		return mno;
	}
	public void setMno(Integer mno) {
		this.mno = mno;
	}
	public String getRtext() {
		return rtext;
	}
	public void setRtext(String rtext) {
		this.rtext = rtext;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public int getRorder() {
		return rorder;
	}
	public void setRorder(int rorder) {
		this.rorder = rorder;
	}
	public Integer getParent() {
		return parent;
	}
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [rno=" + rno + ", bno=" + bno + ", mno=" + mno + ", rtext=" + rtext + ", regdate=" + regdate
				+ ", updatedate=" + updatedate + ", rorder=" + rorder + ", parent=" + parent + "]";
	}
	
}

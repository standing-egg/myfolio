package com.portfolio.summary;

import java.util.Comparator;

public class TextRank implements Comparator<Sentence> {
	
	// 세줄 요약
	@Override
	public int compare(Sentence o1, Sentence o2) {
		// TODO Auto-generated method stub
		if (o1.getJaccard() < o2.getJaccard()) {
			return -1;
		} else if (o1.getJaccard() > o2.getJaccard()) {
			return 1;
		} else {
			return 0;					
		}
	}

}


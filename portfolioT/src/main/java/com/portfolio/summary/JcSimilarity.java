package com.portfolio.summary;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Sets;

public class JcSimilarity {
	
	// 문장별 가중치 
	public static float weight(List<Sentence> sentences, int i) {
		//float d = 0.85f;
		int graphSize = sentences.size();
		float weight = 0;
			for (int j = 0; j < graphSize; j++) {
				if (i != j) {
					/*if (i==0) {
						weight += (jaccard(sentences.get(i).getCount(), sentences.get(j).getCount())*1.0001f);
					}*/
					weight += jaccard(sentences.get(i).getCount(), sentences.get(j).getCount());
				} else {
				}
			}
			//weight = 1-weight; /*(weight*(graphSize-i))/(i+1) + d*weight/(graphSize+i);*/
			//System.out.println(weight);
		return weight;
	}
	
	
	// 자카드 값 계산
	public static float jaccard(
			Map<String, Integer> sentence1, Map<String, Integer> sentence2) {
		float jaccard = (float) intersection(sentence1, sentence2)/union(sentence1, sentence2);
		//System.out.println(jaccard);
		return jaccard;
	}
	
	// 어휘 교집합
	public static int intersection(
			Map<String, Integer> sentence1, Map<String, Integer> sentence2) {
		Iterator<String> iter = Sets.intersection(sentence1.keySet(), sentence2.keySet()).iterator();
		//Iterator<String> iter = sentence1.keySet().iterator();
		int val=0;
		int cnt=0;
		while (iter.hasNext()) {
			String key = iter.next().toString();
			//if (sentence2.containsKey(key)) {
				if (sentence1.get(key)<=sentence2.get(key)) {
					val = sentence1.get(key);
				} else {
					val = sentence2.get(key);
				}
				cnt += val;
			//}
		}
		return cnt;
	}

	
	
	// 어휘 합집합
	public static int union(Map<String, Integer> sentence1, Map<String, Integer> sentence2) {
		
		Iterator<String> iter = Sets.union(sentence1.keySet(), sentence2.keySet()).iterator();
		int val = 0;
		int cnt = 0;
		while (iter.hasNext()) {
			String key = iter.next().toString();
			if (sentence1.containsKey(key) && sentence2.containsKey(key)) {
				if (sentence1.get(key) >= sentence2.get(key)) {
					val = sentence1.get(key);
				} else {
					val = sentence2.get(key);
				}
				cnt += val;
			} else {
				if (sentence1.containsKey(key)) {
					val = sentence1.get(key);					
				} else{
					val = sentence2.get(key);
				}
				cnt += val;
			}
		}
		return cnt;
	}
	

	// 전체 키워드와의 가중치
	/*public static float weightL(List<Sentence> sentences, Sentence sentenceL, int i) {
		//float d = 0.85f;
		int graphSize = sentences.size();
		float weight = 0;
		weight = jaccardL(sentences.get(i).getCount(), sentenceL.getCount());
		System.out.println(weight);
		return weight;
	}*/
	
	// 전체 키워드와의 자카드 값 계산
	/*public static float jaccardL(
			Map<String, Integer> sentence, Map<String, Integer> sentenceL) {
		float jaccard = (float) intersectionL(sentence, sentenceL)/unionL(sentence, sentenceL);
		//System.out.println(jaccard);
		return jaccard;
	}*/
		
	// 전체와의 어휘 교집합
	/*public static int intersectionL(
			Map<String, Integer> sentence, Map<String, Integer> sentenceL) {
		Iterator<String> iter = Sets.intersection(sentence.keySet(), sentenceL.keySet()).iterator();
		int val=0;
		int cnt=0;
		while (iter.hasNext()) {
			String key = iter.next().toString();
			if (sentence.get(key)<=sentenceL.get(key)) {
				val = sentence.get(key);
			} else {
				val = sentenceL.get(key);
			}
			cnt += val;
		}
		return cnt;
	}*/
		
	// 전체 어휘 합집합
	/*public static int unionL(Map<String, Integer> sentence, Map<String, Integer> sentenceL) {
		
		Iterator<String> iter = Sets.union(sentence.keySet(), sentenceL.keySet()).iterator();
		int val = 0;
		int cnt = 0;
		while (iter.hasNext()) {
			String key = iter.next().toString();
			if (sentence.containsKey(key) && sentenceL.containsKey(key)) {
				if (sentence.get(key) >= sentenceL.get(key)) {
					val = sentence.get(key);
				} else {
					val = sentenceL.get(key);
				}
				cnt += val;
			} else {
				if (sentence.containsKey(key)) {
					val = sentence.get(key);					
				} else{
					val = sentenceL.get(key);
				}
				cnt += val;
			}
		}
		return cnt;
	}*/
	
}

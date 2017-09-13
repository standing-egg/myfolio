package com.portfolio.summary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.StringTokenizer;

import org.openkoreantext.processor.KoreanTokenJava;
import org.openkoreantext.processor.OpenKoreanTextProcessorJava;
//import org.openkoreantext.processor.phrase_extractor.KoreanPhraseExtractor;
import org.openkoreantext.processor.tokenizer.KoreanTokenizer;

import scala.collection.Seq;

public class Counter {
	
	// 문장 나누기
	public List<Sentence> getSentence(String text) {
		//text = text.replaceAll("\\”", ". ");
		text = text.replaceAll("\r\n|\n|[.]+\\”+\\s", ". ");
		//text = text.replaceAll("\r\n|\n", ". ");
		//text = text.replaceAll("\\<+/^(?=.*[a-zA-Z])(?=.*[!@#$%^~*+=-])(?=.*[0-9]).{10,20}$/+\\>", " ");
		//text = text.replaceAll("[가-힣]+[.]+[가-힣]", ". ");
		String[] item = text.split("[.]+\\s");
		//StringTokenizer token = new StringTokenizer(text, "[.]+\\s|\n|◇");
		List<Sentence> sentence = new ArrayList<>();
		for (int i = 0; i < item.length; i++) {
			Sentence tlist = new Sentence(item[i]);
			//System.out.println(tlist.getText());
			sentence.add(tlist);
		}
		/*while (token.hasMoreTokens()) {
			sentence.add(tlist);
		}*/
		return sentence;
	}
	
	// 형태소 분석
	public List<Sentence> analyzeSentence(List<Sentence> sentences) {
		CharSequence normalized;
		Seq<KoreanTokenizer.KoreanToken> tokens;
		//List<KoreanPhraseExtractor.KoreanPhrase> phrases;
		List<KoreanTokenJava> list;
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for (int i = 0; i < sentences.size(); i++) {
			normalized = OpenKoreanTextProcessorJava.normalize(sentences.get(i).getText());
			tokens = OpenKoreanTextProcessorJava.tokenize(normalized);
			//phrases = OpenKoreanTextProcessorJava.extractPhrases(tokens, true, false);
			list = OpenKoreanTextProcessorJava.tokensToJavaKoreanTokenList(tokens);
			
			map = countNounVerb(list);
			//countPhrases(phrases, map);
			sentences.get(i).setCount(map);
			//System.out.println(map);
		}
		
		return sentences;
	}
	
	// 전체 텍스트의 형태소 분석
	/*public Sentence analyzeSentence(Sentence sentence) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		CharSequence normalized = OpenKoreanTextProcessorJava.normalize(sentence.getText());
		Seq<KoreanTokenizer.KoreanToken> tokens = OpenKoreanTextProcessorJava.tokenize(normalized);
		List<KoreanTokenJava> list = OpenKoreanTextProcessorJava.tokensToJavaKoreanTokenList(tokens);
		map = countNounVerb(list);
		sentence.setCount(map);
		//System.out.println(map);
		
		return sentence;
	}*/
	
	// 명사, 동사 카운터
	public Map<String, Integer> countNounVerb(
			List<KoreanTokenJava> list/*, Map<String, Integer> map*/) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (KoreanTokenJava koreanTokenJava : list) {
			if (koreanTokenJava.getPos().toString() == "Noun" 
					/*|| koreanTokenJava.getPos().toString()=="Verb"*/
					/*|| koreanTokenJava.getPos().toString() == "Adjective"*/) {
				map.computeIfPresent(koreanTokenJava.getText(), (k, v) -> v+1);
				map.putIfAbsent(koreanTokenJava.getText(), 1);
				/*if (map.containsKey(koreanTokenJava.getText())) {
					map.put(koreanTokenJava.getText(), map.get(koreanTokenJava.getText())+1);
				} else {
					map.put(koreanTokenJava.getText(), 1);
				}*/
			}
		}
		return map;
	}
	
	// 어구 카운터
	/*public Map<String, Integer> countPhrases(
			List<KoreanPhraseExtractor.KoreanPhrase> phrases, Map<String, Integer> map){
		//Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < phrases.size(); i++) {
			map.putIfAbsent(phrases.get(i).text(), 1);
			if (map.containsKey(phrases.get(i).text())) {
				map.put(phrases.get(i).text(), map.get(phrases.get(i).text())+1);
			} else {
				map.put(phrases.get(i).text(), 1);
			}
		}
		return map;
	}*/
	
	// Noun, Verb, Phrase를 담은 map을 list로 변환 (중복 허용을 위해)
	/*public List<String> mapToList(Map<String, Integer> map) {
		
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			for (int i = 0; i < map.get(key); i++) {
				//System.out.println(map.get(key));
				list.add(key);
			}
		}
		return list;
	}*/
	
}

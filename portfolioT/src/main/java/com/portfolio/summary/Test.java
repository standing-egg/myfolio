package com.portfolio.summary;

/*import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.openkoreantext.processor.KoreanTokenJava;*/

//import com.twitter.penguin.korean.KoreanTokenJava;

/*import org.openkoreantext.processor.OpenKoreanTextProcessorJava;
import org.openkoreantext.processor.phrase_extractor.KoreanPhraseExtractor;
import org.openkoreantext.processor.phrase_extractor.KoreanPhraseExtractor.KoreanPhrase;
import org.openkoreantext.processor.tokenizer.KoreanTokenizer;
import org.openkoreantext.processor.tokenizer.KoreanTokenizer.KoreanToken;*/
//import org.openkoreantext.processor.tokenizer.Sentence;
//import org.springframework.util.CollectionUtils;

/*import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;*/

/*import com.twitter.penguin.korean.TwitterKoreanProcessor;
import com.twitter.penguin.korean.TwitterKoreanProcessorJava;
import com.twitter.penguin.korean.phrase_extractor.KoreanPhraseExtractor;
import com.twitter.penguin.korean.tokenizer.KoreanTokenizer;
import com.twitter.penguin.korean.tokenizer.KoreanTokenizer.KoreanToken;*/

/*import scala.collection.Seq;*/

public class Test {

	/*public static void main(String[] args) {
		
			
			String name = "hani21";
			String pp = "peppermint";
			String h = "hani21";
			
			if (name.toString()=="peppermint") {
				System.out.println(name+": 1");
			} else if (name.equals("hani21")) {
				System.out.println(name+": 2");
			} else {
				System.out.println(name+": 3");
			}
		}*/
		
		//String text = "고양이 이름이 이름 이름 고양이 이름이 43.2 뭐요 뭐 뭐. 어린이들에게는 타고난 언어 능력이 있지만 노력 없이 이것이 성인기까지 이어지리라고 기대해서는 안 됩니다. 플로리다아틀란틱대학의 발달심리학자 에리카 호프 교수는 “어떤 이유나 배경 때문에건 아이를 이중언어 구사자로 키우고자 한다면, 언어 습득에는 엄청난 노출이 반드시 필요하다는 사실을 명심해야 한다”고 말합니다.";
		//String text = "점을 분명히 하고 싶어요.”"+" 바로 지금 이 문제를";
		
		//String text = "고양이 이름이 이름 이름 고양이 이름이 뭐요 뭐 뭐.";
		//System.out.println(text);
		//String[] item = text.split("[.]+\\s|\\n");
		//String[] item = text.split("[\\”]");
		//System.out.println(text.replaceAll("\\”", "x"));
		/*String[] item = text.split("[&quot;]");
		for (int i = 0; i < item.length; i++) {
			System.out.println(item[i]);
		}*/
		//System.out.println("================");
		/*StringTokenizer token = new StringTokenizer(text, ".|?|!|\"|\n");
		List<Sentence> ttlist = new ArrayList<>();
		while (token.hasMoreTokens()) {
			Sentence tlist = new Sentence(token.nextToken().trim());
			System.out.println(tlist.getText());
			ttlist.add(tlist);
		}
		System.out.println(ttlist.get(1).getText());
		
		CharSequence normalized = OpenKoreanTextProcessorJava.normalize(ttlist.get(1).getText());*/
		
		//Seq<KoreanTokenizer.KoreanToken> tokens1 = OpenProcessorJava.tokenize(normalized);
		
		/*Seq<KoreanTokenizer.KoreanToken> tokens = 
				OpenKoreanTextProcessorJava.tokenize(normalized);*/
		//System.out.println(tokens);
		/*List<KoreanPhraseExtractor.KoreanPhrase> phrases = 
				OpenKoreanTextProcessorJava.extractPhrases(tokens, true, false);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		List<KoreanTokenJava> list = OpenKoreanTextProcessorJava.tokensToJavaKoreanTokenList(tokens);
		
		for (KoreanTokenJava koreanTokenJava : list) {
			if (koreanTokenJava.getPos().toString()=="Noun" || koreanTokenJava.getPos().toString()=="Verb") {
				map.computeIfPresent(koreanTokenJava.getText(), (k, v) -> v+1);
				map.putIfAbsent(koreanTokenJava.getText(), 1);
			}
		}
				
		List<String> list2 = new ArrayList<>();
		List<String> list3 = new ArrayList<>();
		
		for (int i = 0; i < phrases.size(); i++) {
			//list3.add(phrases.get(i).text());
			if (phrases.get(i).text().toString().contains(list.toString())) {
			} else {
				list2.add(phrases.get(i).text());				
			}
			map.putIfAbsent(phrases.get(i).text(), 1);
		}
		ttlist.get(1).setCount(map);
		System.out.println(map);
		System.out.println(ttlist.get(1).getCount());*/
		
		/*Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key = (String) iterator.next();
			for (int i = 0; i < map.get(key); i++) {
				//System.out.println(map.get(key));
				list3.add(key);
			}
		}*/
		//System.out.println(list3);
		
		/*list2.add("뭐");
		list2.add("뭐");
		list2.add("이름");
		list2.add("이름");
		list2.add("이름");
		list2.add("야옹");*/
		//System.out.println(list2);
		//list3.retainAll(list2);
		//System.out.println(list3);
		
		/*Map<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("이름", 7);
		map2.put("뭐", 2);
		map2.put("고양이", 2);
		map2.put("고무", 10);
		System.out.println(map2);
		
		int intersec=0;
		int unio=0;
		
		Iterator<String> iterator2 = map.keySet().iterator();
		
		int val=0;
		int cnt=0;
		while (iterator2.hasNext()) {
			String key = (String) iterator2.next();
			if (map2.containsKey(key)) {
				if (map.get(key)<=map2.get(key)) {
					val = map.get(key);
					//System.out.println(key+":"+val);
				} else {
					val = map2.get(key);
					//System.out.println(key+":"+val);
				}
				cnt += val;
				//System.out.println(cnt);
			}
			intersec = cnt;
		}
		
		Iterator<String> iter = Sets.union(map.keySet(), map2.keySet()).iterator();
		val = 0;
		cnt = 0;
		while (iter.hasNext()) {
			String key = (String) iter.next();
			if (map.containsKey(key) && map2.containsKey(key)) {
				if (map.get(key)>=map2.get(key)) {
					val = map.get(key);
				} else {
					val = map2.get(key);
				}
				cnt += val;
			} else {
				if (map.containsKey(key)) {
					val = map.get(key);					
				} else{
					val = map2.get(key);
				}
				cnt += val;
				//System.out.println(key+":"+val);
			}
			unio=cnt;
		}
		
		float jaccard = (float)intersec/unio;
		System.out.println(jaccard);*/
		
		/*Seq<KoreanTokenizer.KoreanToken> tokens = 
				TwitterKoreanProcessorJava.tokenize(text);
		List<KoreanPhraseExtractor.KoreanPhrase> phrases = 
				TwitterKoreanProcessorJava.extractPhrases(tokens, true, true);
		System.out.println(tokens);
		
		List<KoreanTokenJava> tokenList = TwitterKoreanProcessorJava.tokensToJavaKoreanTokenList(tokens, false);
		for (Iterator iterator = tokenList.iterator(); iterator.hasNext();) {
			KoreanTokenJava koreanTokenJava = (KoreanTokenJava) iterator.next();
			if (koreanTokenJava.getPos().toString()=="Noun") {
				System.out.println(koreanTokenJava);
			}
		}*/
		
		
	}

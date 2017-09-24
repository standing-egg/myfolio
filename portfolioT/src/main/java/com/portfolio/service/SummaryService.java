package com.portfolio.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.summary.Counter;
import com.portfolio.summary.JcSimilarity;
import com.portfolio.summary.Sentence;
import com.portfolio.summary.TextRank;

@Service
public class SummaryService {

	public List<String> summary(String article) {
		
		List<String> sumAticle = new ArrayList<>();
		
		Counter counter = new Counter();
		List<Sentence> sentences = counter.getSentence(article);
		
		counter.analyzeSentence(sentences);
		
		for (int i = 0; i < sentences.size(); i++) {
			sentences.get(i).setJaccard(JcSimilarity.weight(sentences, i));
		}
		
		TextRank rank = new TextRank();
		Collections.sort(sentences, rank);
		Collections.reverse(sentences);
		
		for (int i = 0; i < 3; i++) {
			//System.out.println("senten: "+i+" : "+sentences.get(i).getText());
			sumAticle.add(i+1+") "+sentences.get(i).getText()+".<br/><br/>");
			//System.out.println(sentences.get(i).getText());
			//System.out.println(sumAticle.get(i));
		}
		
		return sumAticle;
	}

	/*public static void main(String[] args) {
		
		String text = "김상조 공정거래위원장 후보자가 인사검증 과정에서 신용카드 사용액을 밝히지 않은 이유를 이렇게 설명했다. 김 후보자는 카드 사용액이 총소득의 4분의 1을 넘어야 하는 소득공제 요건을 충족하지 못한 것이다. 월급쟁이라면 응당 카드 소득공제를 받는 것으로 생각하지만 김 후보자처럼 공제를 포기하거나 받지 못하는 사람들도 적지 않다. 게다가 고소득자를 중심으로 올해부터 카드 소득공제 혜택을 줄일 예정이라 카드 공제받기가 더 까다로워진다. 11일 국세통계연보에 따르면, 2015년 기준으로 1733만명인 근로소득자 중에서 카드 소득공제를 받은 사람은 49.4%인 856만명으로 절반에 못 미쳤다. 그중 소득세가 면세(免稅)돼 세금을 내지 않은 257만명을 제외하고 실제로 세금을 낸 사람 중에서 카드 소득공제를 받은 사람은 599만명으로 전체 월급쟁이의 34.5%였다. ◇연봉 5000만원대가 84%로 카드 공제 가장 많이 받아. 신용카드 소득공제를 받으려면 총소득의 4분의 1 이상을 카드로 써야 한다. 4분의 1 문턱에서 1원이라도 모자라면 한 푼도 공제받을 수 없다. 수억원대의 고소득자일수록 카드로 소득의 4분의 1 이상을 쓰기 쉽지 않기 때문에 소득이 높을수록 공제를 못 받는 경우가 늘어난다. 2015년 기준으로 근로소득세를 내는 사람 중에서 카드 소득공제를 받는 비율이 가장 많은 소득 구간은 연봉 5000만~6000만원이었다. 전체의 84%가 혜택을 봤다. 연봉 6000만~8000만원 사이에서도 83%, 8000만~1억원 구간은 79%가 공제를 받았다. 반면 1억~2억원 사이에서는 공제받은 사람 비율이 68%로 줄었고, 2억~3억원인 사람은 31%만 카드 공제를 받은 것으로 나타났다. 국세청 관계자는 “월급쟁이가 카드를 쓰는 용도가 다들 엇비슷해서 고소득자라고 해서 카드 사용액이 월등하게 늘어나지는 않기 때문에 소득이 높을수록 ‘4분의 1 문턱’을 넘기가 어려워지는 경향이 있다”고 말했다. 또 고소득자들이 외국에 나가 카드를 많이 사용하지만, 해외에서의 카드 사용액을 일절 공제해주지 않는 점도 영향이 있는 것으로 분석된다. ◇소득 낮은 부부는 한 사람 명의의 카드 써야 유리. 소득이 연 5000만원에 못 미치는 서민층에서도 카드 공제를 받는 사람들의 비율이 낮아지는 경향을 보인다. 연봉 4000만원대는 81%, 3000만원대는 73%, 2000만원대는 55%만 카드 소득공제를 받은 것으로 나타났다. 이런 현상이 나타나는 이유는 우선 저소득층일수록 허리띠를 졸라매는 경향이 있어 ‘4분의 1 문턱’을 넘지 못하는 경우가 상당하기 때문인 것으로 추정된다. 또 소득이 넉넉하지 않은 맞벌이의 경우 한 사람 명의로 카드를 발급받아 한 사람의 카드 사용액이 ‘4분의 1 문턱’을 넘도록 몰아주고, 나머지 배우자는 카드 소득공제를 포기하는 절세 노하우를 보여주는 사례도 많다고 국세청 관계자들은 설명했다. 서울지역의 한 세무사는 “부부가 각자 명의로 카드를 쓰다가 둘 다 ‘4분의 1 문턱’을 못 넘겨 안 내도 될 세금을 더 내는 경우가 있으니 주의해야 한다”고 말했다. 2015년 기준으로 카드 소득공제를 받은 599만명은 평균 245만원을 공제받은 것으로 나타났다. 300만원인 공제한도를 채우지 못한 사람들이 적지 않다는 뜻이다. 카드 소득공제는 4분의 1 문턱을 초과하는 액수에 대해 신용카드는 15%, 체크카드는 30%에 해당하는 액수를 300만원 한도로 공제하는 방식이다. 전통시장에서 결제한 금액과 대중교통비에 대해서는 각각 100만원씩 공제 한도가 더 늘어난다. ◇연봉 1억2000만원 이상은 올해부터, 7000만원 이상은 내년부터 공제한도 축소. 신용카드 소득공제는 올해부터 순차적으로 한도가 줄어들게 되므로 관련 제도 변화를 유심히 살펴볼 필요가 있다. 고소득자의 공제 폭을 줄여 실질적인 근로소득세 증세(增稅)가 예고돼 있다. 우선 연소득 1억2000만원이 넘는 월급쟁이는 올해 사용분부터 공제한도가 기존 300만원에서 200만원으로 줄어든다. 내년 초 연말정산 때 돌려받는 세금이 수십만원 정도 줄어들거나, 토해내는 세금이 수십만원 늘어난다는 뜻이다. 연봉 7000만~1억2000만원 근로자의 공제 한도는 내년 사용분부터 300만원에서 250만원으로 축소될 전망이다. 연봉 7000만~1억2000만원인 근로자에 대해 정부는 2019년부터 한도를 축소하기로 했지만 지난해 국회가 1년 앞당겨 실시하기로 결정했다.";
		
		
		Counter counter = new Counter();
		List<Sentence> sentences = counter.getSentence(text);
		
		Sentence sentenceL = new Sentence(text);
		
		counter.analyzeSentence(sentences);
		counter.analyzeSentence(sentenceL);
		
		// 전체 키워드 많은 것 10개
		List<Entry<String, Integer>> list = new ArrayList<>(sentenceL.getCount().entrySet());
		Collections.sort(list, new Comparator<Object>() {
			@SuppressWarnings("unchecked")
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return ((Comparable<Integer>) ((Map.Entry<String, Integer>) (o1)).getValue()).compareTo(((Map.Entry<String, Integer>) (o2)).getValue());
			}
		});
		Map<String, Integer> result = new HashMap<>();
	    for (Iterator<Entry<String, Integer>> it = list.iterator(); it.hasNext();) {
	        Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) it.next();
	        result.put(entry.getKey(), entry.getValue());
	    }
		System.out.println("--------------------");
		Collections.reverse(list);
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			map.put(list.get(i).getKey(), list.get(i).getValue());
		}
		
		sentenceL.setCount(map);
		System.out.println(sentenceL.getCount());
		
		for (int i = 0; i < sentences.size(); i++) {
			JcSimilarity.weightL(sentences, sentenceL, i);			
		}
		
		for (int i = 0; i < sentences.size(); i++) {
			sentences.get(i).setJaccard((JcSimilarity.weight(sentences, i))+JcSimilarity.weightL(sentences, sentenceL, i));
		}
		
		TextRank rank = new TextRank();
		Collections.sort(sentences, rank);
		Collections.reverse(sentences);
		for (int i = 0; i < 3; i++) {
			System.out.println(sentences.get(i).getText());
		}

		JcSimilarity.jaccard(sentences.get(0).getCount(), sentences.get(1).getCount());
		JcSimilarity.jaccard(sentences.get(1).getCount(), sentences.get(2).getCount());
		JcSimilarity.jaccard(sentences.get(2).getCount(), sentences.get(0).getCount());
		
		System.out.println(sentences.get(0).getJaccard());
		System.out.println(sentences.get(1).getJaccard());
		System.out.println(sentences.get(2).getJaccard());
	}*/


	/*public String summary(String article) {
	
	//String sumAticle = "";
	
	Counter counter = new Counter();
	List<Sentence> sentences = counter.getSentence(article);
	
	counter.analyzeSentence(sentences);
	
	for (int i = 0; i < sentences.size(); i++) {
		sentences.get(i).setJaccard(JcSimilarity.weight(sentences, i));
	}
	
	TextRank rank = new TextRank();
	Collections.sort(sentences, rank);
	Collections.reverse(sentences);
	
	StringBuilder sumArticle = new StringBuilder();
	for (int i = 0; i < 3; i++) {
		System.out.println(sentences.get(i).getText());
		
		sumArticle.append(i+1+") "+sentences.get(i).getText()+". <br/><br/>");
	}
	
	return sumArticle.toString();
}*/
}

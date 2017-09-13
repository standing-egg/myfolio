package com.portfolio.summary;

import java.util.List;

public class GraphMatrix {

	// 그래프 생성 (각 문장의 jaccard 설정)
	public float /*List<Sentence>*/ createGraph(List<Sentence> sentences, int i) {
		int graphSize = sentences.size();
		//float[][] graph = new float[graphSize][graphSize];
		float weight = 0;
		//for (int i = 0; i < graphSize; i++) {
			for (int j = 0; j < graphSize; j++) {
				if (i != j) {
					weight += JcSimilarity.jaccard(
							sentences.get(i).getCount(), sentences.get(j).getCount());
					/*graph[i][j] = JcSimilarity.jaccard(
							sentences.get(i).getCount(), sentences.get(j).getCount());
					weight += graph[i][j];*/
				} else {
					//graph[i][j] = 0;
				}
				//sentences.get(i).setJaccard(weight);
				//weight = 0;
			}
			//System.out.println(weight);
			//System.out.println(i + ": "+sentences.get(i).getJaccard());
		//}
		return weight;
		//return sentences;
	}
	
}

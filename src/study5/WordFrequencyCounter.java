package study5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WordFrequencyCounter {
	public static void main(String[] args) {
		//샘플 텍스트
        String text = "자바는 객체 지향 프로그래밍 언어입니다. 자바는 1995년에 발표되었으며, "
                + "현재까지도 많은 개발자들이 자바를 사용하고 있습니다. 자바는 플랫폼 독립적인 "
                + "언어로, 한 번 작성하면 어디서든 실행할 수 있습니다. 객체 지향 프로그래밍은 "
                + "코드의 재사용성과 유지보수성을 높여줍니다.";
        
        // 단어 분리 및 소문자 변환
        String[] words = text.replaceAll("[.,]", "").split("\\s+");
        
        // HashMap을 사용하여 단어 빈도수 계산
        Map<String, Integer> wordFrequency = new HashMap<>();
        
        for (String word : words) {
            // getOrDefault: 키가 존재하면 값을 가져오고, 없으면 기본값(0)을 반환
            wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
        
        System.out.println("=== 단어별 등장 빈도수 ===");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.printf("'%s': %d번%n", entry.getKey(), entry.getValue());
        }
        
        // 가장 많이 등장한 단어 찾기
        String mostFrequentWord = null;
        int highestFrequency = 0;
        
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            if (entry.getValue() > highestFrequency) {
                highestFrequency = entry.getValue();
                mostFrequentWord = entry.getKey();
            }
        }
        
        System.out.printf("%n가장 많이 등장한 단어: '%s' (%d번)%n", 
                mostFrequentWord, highestFrequency);
        
        // 빈도수로 그룹화하기
        Map<Integer, List<String>> frequencyGroups = new HashMap<>();
        
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            int freq = entry.getValue();
            if (!frequencyGroups.containsKey(freq)) {
                frequencyGroups.put(freq, new ArrayList<>());
            }
            frequencyGroups.get(freq).add(entry.getKey());
        }
        
        System.out.println("\n=== 빈도수별 단어 그룹 ===");
        for (Map.Entry<Integer, List<String>> entry : frequencyGroups.entrySet()) {
            System.out.printf("%d번 등장: %s%n", entry.getKey(), entry.getValue());
        }
    }
}
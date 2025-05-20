package study5;

import java.util.HashSet;
import java.util.Set;

public class SetOperationsExample {
	public static void main(String[] args) {
		//두 개의 문자열 집합 생성
		Set<String> fruits1 = new HashSet<>();
		fruits1.add("사과");
		fruits1.add("바나나");
		fruits1.add("오렌지");
		fruits1.add("포도");
		
		Set<String> fruits2 = new HashSet<>();
		fruits2.add("바나나");
		fruits2.add("포도");
		fruits2.add("딸기");
		fruits2.add("키위");
		
		//원본 집합 출력
		System.out.println("과일 집합 1:" + fruits1);
		System.out.println("과일 집합 2:" + fruits2);
		
		//합집합 (Union)
		Set<String> union = new HashSet<>(fruits1);
		union.addAll(fruits2);
		System.out.println("합집합" + union); //중복은 하나로 합침
		
		//교집합 (Intersection)
		Set<String> intersection = new HashSet<>(fruits1);
		intersection.retainAll(fruits2);
		System.out.println("교집합: " + intersection); //중복되는거만 표시
		
		//차집합 (Difference)
		Set<String> difference = new HashSet<>(fruits1);
		difference.removeAll(fruits2);
		System.out.println("차집합 (1-2)" + difference);
		
		System.out.println("'사과'가 집합 1에 있나요?" + fruits1.contains("사과"));
		System.out.println("'멜론'이 집합 2에 있나요?" + fruits2.contains("멜론"));
	}
}

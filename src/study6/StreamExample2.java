package study6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample2 {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("apple", "banana", "kiwi", "strawberry", "grape");
		
		List<String> result = words.stream()
				.filter(word -> word.length() >= 5)
				.map(String::toUpperCase)
				.collect(Collectors.toList());
		
		System.out.println("결과" + result);
	}
}

package study6;

import java.util.Iterator;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class StreamExample6 {
	public static void main(String[] args) {
		int MAX_NUMBER = 10_000_000;
		
		// 소수 판별 함수
		Predicate<Integer> isPrime = num -> {
			if (num <= 1) return false;
			if (num <= 3) return true;
			if (num % 2 == 0 || num % 3 == 0) return false;
			
			for (int i = 5; i * i <= num; i+= 6) {
				if (num % i == 0 || num % (i + 2) == 0) return false;
			}
			return true;
		};
		
		// 일반 스트림으로 소수 찾기
		long startTime = System.currentTimeMillis();
		long count = IntStream.rangeClosed(1, MAX_NUMBER)
				.filter(n -> isPrime.test(n))
				.count();
		long endTime = System.currentTimeMillis();
		
		System.out.println("일반 스트림 처리 시간: " + (endTime - startTime) + "ms");
		System.out.println("소수 개수: " + count);
		
		// 병렬 스트림으로 소수 찾기
		startTime = System.currentTimeMillis();
		count = IntStream.rangeClosed(1, MAX_NUMBER)
				.parallel()
				.filter(n -> isPrime.test(n))
				.count();
		
		endTime = System.currentTimeMillis();
		
		System.out.println("병렬 스트림 처리 시간: " + (endTime - startTime) + "ms");
		System.out.println("소수 개수: " + count);
	}
}

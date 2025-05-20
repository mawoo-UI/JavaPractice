package study6;

import java.util.Arrays;

public class StreamExample1 {
	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		int result = Arrays.stream(numbers)
				.filter(n -> n % 2 == 0)
				.map(n -> n * n)
				.sum();
		
		System.out.println("짝수의 제곱 합: " + result);
	}
}

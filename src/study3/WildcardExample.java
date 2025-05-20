package study3;

import java.util.ArrayList;
import java.util.List;

public class WildcardExample {
	// 상한 경계 와일드카드: Number 또는 그 하위 클래스만 가능
	public static double sumOfList(List<? extends Number> list) {
		double sum = 0.0;
		for (Number n : list) {
			sum += n.doubleValue();
		}
		return sum;
	}
	public static void addNumbers(List<? super Integer> list) {
		for (int i = 1; i <= 5 ; i++) {
			list.add(i);
		}
	}
	// 하한 경계 와일드카드: Integer 또는 그 상위 클래스만 가능
	public static void main(String[] args) {
		List<Integer> integers = new ArrayList<>();
		integers.add(10);
		integers.add(20);
		
		List<Double> doubles = new ArrayList<>();
		doubles.add(10.5);
		doubles.add(20.5);
		
		System.out.println("정수 합: " + sumOfList(integers));
		System.out.println("실수 합: " + sumOfList(doubles));
		
		List<Number> numbers = new ArrayList<>();
		addNumbers(numbers);
		System.out.println("추가된 숫자: " + numbers);
	}
}

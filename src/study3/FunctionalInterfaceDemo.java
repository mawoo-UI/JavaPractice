package study3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceDemo {
	public static void main(String[] args) {
		// Predicate: 조건 검사 (T -> boolean)
		List<String> names = Arrays.asList("홍길동", "김철수", "이영희", "박지민", "최민준");
		Predicate<String> startsWithKim = name -> name.startsWith("김");
		filterAndPrint(names, startsWithKim);
		
		// Consumer: 데이터 소비(T -> void)
		Consumer<String> printer = name -> System.out.println("이름: "+ name);
		names.forEach(printer);
		
		//Function: 데이터 변환 (T -> R)
		Function<String, Integer> nameLength = name -> name.length();
		List<Integer> nameLengths = map(names, nameLength);
		System.out.println("이름 길이: " + nameLength);
		
		// Supplier: 데이터 공급 (() -> T)
		Supplier<Double> randomValue = () -> Math.random();
		System.out.println("랜덤 값: " + randomValue.get());
	}
	//Predicate를 사용한 필터링 메서드
	public static <T> void filterAndPrint(List<T> list, Predicate<T> condition) {
		System.out.println("필터링 결과:");
		for (T item : list) {
			if (condition.test(item)) {
				System.out.println(item);
			}
		}
	}
	//Function을 사용한 매핑 메서드
	public static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
		List<R> result = new ArrayList<>();
		for (T item : list) {
			result.add(mapper.apply(item));
			
		}
		return result;
	}
}

package study3;

public class GenericMethods {
	//배열의 요소들을 출력하는 제네릭 메서드
	public static <T> void printArray(T[] array) {
		for (T element : array) {
			System.out.println(element + " ");
		}
		System.out.println();
	}
	// 배열에서 최대값을 찾는 제네릭 메서드(숫자만 가능)
	public static <T extends Comparable<T>> T findMax(T[] array) {
		if (array == null || array.length == 0) {
			return null;
		}
		T max = array[0];
		for (int i = 0; i < array.length; i++) {
			if (array[i].compareTo(max) > 0) {
				max = array[i];				
			}
		}
		return max;
	}
	public static void main(String[] args) {
		Integer[] intArray = {1, 5, 3, 7, 2};
		String[] strArray = {"Apple", "Orange", "Banana", "Grape"};
		
		System.out.println("점수 배열:");
		printArray(intArray);
		
		System.out.println("문자열 배열:");
		printArray(strArray);
		
		System.out.println("최대값(정수)" + findMax(intArray));
		System.out.println("최대값(문자열): " + findMax(strArray));
		
	}
}

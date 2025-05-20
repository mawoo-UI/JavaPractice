package study3;

public class Main {
	public static void main(String[] args) {
		Pair<String, Integer> score = new Pair<>("홍길동", 95);
		System.out.println(score);
		
		Pair<Integer, String> coord = new Pair<>(10, "서울시청");
		System.out.println("위치: " + coord.getValue() + ", 거리" + coord.getKey() + "km");
	}
}

package study2;

interface Flyable {
	void fly();
	
	default void takeOff() {
		System.out.println("이륙 준비중...");
		fly();
	}
}

package study2;

public class Duck implements Flyable, Swimmer{
	public void fly() {
		System.out.println("오리가 날아갑니다.");
	}
	public void swim() {
		System.out.println("오리가 헤엄칩니다.");
	}
}

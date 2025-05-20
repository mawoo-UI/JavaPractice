package study2;

public class Airplane implements FlyingVehicle{
	public void move() {
		System.out.println("비행기가 이동합니다.");
	}
	public void takeOff() {
		System.out.println("비행기가 이륙합니다.");
	}
	public void land() {
		System.out.println("비행기가 착륙합니다.");
		
	}
}

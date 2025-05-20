package study2;

import study1.Animal;

public class Main {
	public static void main(String[] args) {
		Flyable duck = new Duck();
		duck.fly();
//		((Flaybal) duck).takeOff();
		
		Duck duck1 = new Duck();
		
		duck1.swim();
		Shape shape1 = new Circle(5.0);
	    Shape shape2 = new Rectangle(4.0, 6.0);
	     
	    System.out.println("원의 면적: " + shape1.getArea());
	    System.out.println("사각형의 면적: " + shape2.getArea());
	}
}

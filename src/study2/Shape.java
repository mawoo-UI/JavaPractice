package study2;

//인터페이스 정의
interface Shape {
 double getArea();
}

//구현 클래스들
class Circle implements Shape {
 private double radius;
 
 public Circle(double radius) {
     this.radius = radius;
 }
 
 public double getArea() {
     return Math.PI * radius * radius;
 }
}

class Rectangle implements Shape {
 private double width, height;
 
 public Rectangle(double width, double height) {
     this.width = width;
     this.height = height;
 }
 
 public double getArea() {
     return width * height;
 }
}

//메인 클래스
//public class Main {
// public static void main(String[] args) {
//     Shape shape1 = new Circle(5.0);
//     Shape shape2 = new Rectangle(4.0, 6.0);
//     
//     System.out.println("원의 면적: " + shape1.getArea());
//     System.out.println("사각형의 면적: " + shape2.getArea());
// }
//}
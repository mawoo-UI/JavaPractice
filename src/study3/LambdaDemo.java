package study3;

interface Calculator  {
	int calculate(int x, int y);
}
public class LambdaDemo {
	public static void main(String[] args) {
		// 덧셈 연산을 하는 람다식
		Calculator add = (x, y) -> x + y;
		
		//뺄셈 연산을 하는 람다식
		Calculator subtract = (x, y) -> x -y;
		
		// 곱셈 연산을 하는 람다식
		Calculator multiply = (x, y) -> x * y;
		
		//나눗셈 연산을 하는 람다식
		Calculator divide = (x, y) -> y != 0 ? x / y : 0;
		
		//계산 결과 출력
		System.out.println("10 + 5 = " + add.calculate(10, 5));
		System.out.println("10 - 5 = " + subtract.calculate(10, 5));
		System.out.println("10 * 5 = " + multiply.calculate(10, 5));
		System.out.println("10 / 5 = " + divide.calculate(10, 5));
		
	}
}

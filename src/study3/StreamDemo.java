package study3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Student {
	private String name;
	private int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() { return name; }
	public int getScore() { return score; }
	
	@Override
	public String toString() {
		return name + "(" + score + ")";
	}
}

public class StreamDemo {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("홍길동", 85),
				new Student("김철수", 92),
				new Student("이영희", 77),
				new Student("박지민", 95),
				new Student("최민준", 68)
		);
		
		//1. 90점 이상인 학생들
		List<Student> highScorers = students.stream()
				.filter(s -> s.getScore() >= 90)
				.collect(Collectors.toList());
		System.out.println("90점 이상 학생: " + highScorers);
		
		//2. 모든 학생의 평균 점수
		double average = students.stream()
				.mapToInt(Student::getScore)
				.average()
				.orElse(0.0);
		System.out.println("평균 점수: " + average);
	
		//3. 이름을 점수 순으로 정렬하여 출력
		System.out.println("점수 순 정렬:");
		students.stream()
		.sorted((s1, s2) -> s2.getScore() - s1.getScore())
		.forEach(s -> System.out.println(s.getName() + ": " + s.getScore() + "점"));
		
		//4. 모든 학생 이름을 쉼표로 구분하여 출력
		String nameList = students.stream()
				.map(Student::getName)
				.collect(Collectors.joining(", "));
		System.out.println("학생 명단:" + nameList);
	}
}

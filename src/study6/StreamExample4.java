package study6;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample4 {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("홍길동", 85),
	            new Student("김철수", 75),
	            new Student("이영희", 92),
	            new Student("박민수", 68),
	            new Student("정수정", 95),
	            new Student("강동원", 55),
	            new Student("조인성", 72),
	            new Student("이민기", 82)
				);
		
		Map<String, Long> gradeCount = students.stream()
				.collect(Collectors.groupingBy(
						student -> {
							int score = student.getScore();
							if (score >= 90) return "A";
							else if (score >=80) return "B";
							else if (score >=70) return "C";
							else if (score >=60) return "D";
							else return "F";
						},
						Collectors.counting()
						));
		System.out.println("등급별 학생 수: " + gradeCount);
	}
}

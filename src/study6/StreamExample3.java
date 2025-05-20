package study6;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamExample3 {
	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
	            new Student("홍길동", 85),
	            new Student("김철수", 75),
	            new Student("이영희", 90),
	            new Student("박민수", 80),
	            new Student("정수정", 95)
				);
		
		Map<String, Integer> highScorers = students.stream()
				.filter(s -> s.getScore() >= 80)
				.collect(Collectors.toMap(Student::getName,
						Student::getScore
						));
		
		System.out.println("80점 이상 학생의 성적: " + highScorers);
	}
}

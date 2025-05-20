package study5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GradeManagementSystem {
	public static void main(String[] args) {
		//학생 목록 생성
		List<Student2> student2 = new ArrayList<>();
		student2.add(new Student2(1001, "김철수"));
        student2.add(new Student2(1002, "이영희"));
        student2.add(new Student2(1003, "박민수"));
        
        //과목 목록 생성
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("CS101", "컴퓨터 개론", 3));
        courses.add(new Course("MA101", "대학수학", 3));
        courses.add(new Course("EN101", "영어회화", 2));
        courses.add(new Course("PH101", "물리학", 3));
        //성적 데이터 관리(학생별 -> 과목별 -> 점수)
        Map<Student2, Map<Course, Double>> gradeSystem = new HashMap<>();
        
        //김철수의 성적 데이터 추가
        Map<Course, Double> kimGrades = new HashMap<>();
        kimGrades.put(courses.get(0), 85.5); // 컴퓨터 개론
        kimGrades.put(courses.get(1), 90.0); // 대학수학
        kimGrades.put(courses.get(2), 78.5); // 영어회화
        gradeSystem.put(student2.get(0), kimGrades);
        
        // 이영희의 성적 데이터 추가
        Map<Course, Double> leeGrades = new HashMap<>();
        leeGrades.put(courses.get(0), 92.0); // 컴퓨터 개론
        leeGrades.put(courses.get(1), 88.5); // 대학수학
        leeGrades.put(courses.get(3), 95.0); // 물리학
        gradeSystem.put(student2.get(1), leeGrades);
        
        // 박민수의 성적 데이터 추가
        Map<Course, Double> parkGrades = new HashMap<>();
        parkGrades.put(courses.get(1), 79.0); // 대학수학
        parkGrades.put(courses.get(2), 92.5); // 영어회화
        parkGrades.put(courses.get(3), 87.0); // 물리학
        gradeSystem.put(student2.get(2), parkGrades);
        
        System.out.println("=== 학생별 성적 조회 ===");
        for (Student2 student : student2) {
			System.out.println("\n" + student.getName() + "의 성적:");
			Map<Course, Double> studentGrades = gradeSystem.get(student);
			
			if (studentGrades != null) {
				double totalPoints = 0;
				int totalCredits = 0;
				
				for (Map.Entry<Course, Double> entry : studentGrades.entrySet()) {
					Course course = entry.getKey();
					Double grade = entry.getValue();
					System.out.printf(" %s: %.1f점%n", course, grade);
					
					totalPoints += grade * course.getCredit();
					totalCredits += course.getCredit();
				}
				
				if (totalCredits > 0) {
					double gpa = totalPoints / totalCredits;
					System.out.printf("  평균 평점: %.2f%n", gpa);
				}
			}
		}
        
        System.out.println("\n=== 과목별 평균 성적 ===");
        Map<Course, List<Double>> courseGrades = new HashMap<>();
        
        for (Map<Course, Double> studentGrades : gradeSystem.values()) {
			for (Map.Entry<Course, Double> entry : studentGrades.entrySet()) {
				Course course = entry.getKey();
				Double grade = entry.getValue();
				
				if (!courseGrades.containsKey(course)) {
					courseGrades.put(course, new ArrayList<>());
				}
				courseGrades.get(course).add(grade);
			}
		}
        
        for (Course course : courses) {
			List<Double> grades = courseGrades.get(course);
			if (grades != null && !grades.isEmpty()) {
				double sum = 0;
				for (Double grade : grades) {
					sum += grade;
				}
				double average = sum / grades.size();
				System.out.printf("%s 평균: %.2f점 (수강인원: %d명)%n",
						course, average, grades.size());
			}
			else {
				System.out.printf("%s: 수강 데이터 없음 %n", course);				
			}
		}
        
        System.out.println("\n=== 과목별 최고 성적 학생 ===");
        for (Course course : courses) {
			Student2 topStudent = null;
			double highestGrade = 0;
			
			for (Map.Entry<Student2, Map<Course, Double>> entry : gradeSystem.entrySet()) {
				Student2 student = entry.getKey();
				Map<Course, Double> studentGrades = entry.getValue();
				
				if (studentGrades.containsKey(course) && studentGrades.get(course) > highestGrade) {
					highestGrade = studentGrades.get(course);
					topStudent = student;
				}
			}
			
			if (topStudent != null) {
				System.out.printf("%s 최고 성적: %s (%.1f.점)%n",
						course, topStudent, highestGrade); 
			} else {
				System.out.printf("%s: 수강 데이터 없음%n", course);
			}
		}
	}
}

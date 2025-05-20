package study5;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StudentListExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        
        // 학생 객체 추가
        students.add(new Student(1003, "김철수", 3.8));
        students.add(new Student(1001, "이영희", 4.2));
        students.add(new Student(1004, "박지성", 3.5));
        students.add(new Student(1002, "정민호", 4.0));
        
        System.out.println("=== 원본 학생 목록 ===");
        printList(students);
        
        // 학번 기준 정렬
        students.sort(Comparator.comparing(Student::getId));
        System.out.println("\n=== 학번 기준 정렬 ===");
        printList(students);
        
        // 이름 기준 정렬
        students.sort(Comparator.comparing(Student::getName));
        System.out.println("\n=== 이름 기준 정렬 ===");
        printList(students);
        
        // 평점 기준 내림차순 정렬
        students.sort(Comparator.comparing(Student::getGpa).reversed());
        System.out.println("\n=== 평점 기준 내림차순 정렬 ===");
        printList(students);
        
        // 특정 조건의 학생 찾기 (Java 8 스트림 활용)
        Optional<Student> topStudent = students.stream()
                .filter(s -> s.getGpa() > 4.0)
                .findFirst();
        
        System.out.println("\n평점 4.0 초과 첫 번째 학생: " + 
                (topStudent.isPresent() ? topStudent.get() : "없음"));
        
        // 인덱스 조작
        if (!students.isEmpty()) {
            Student removed = students.remove(1); // 두 번째 학생 제거
            System.out.println("\n제거된 학생: " + removed);
            System.out.println("\n=== 제거 후 학생 목록 ===");
            printList(students);
            
            // 특정 위치에 학생 추가
            students.add(0, new Student(1005, "최유리", 3.9));
            System.out.println("\n=== 첫 위치에 학생 추가 후 목록 ===");
            printList(students);
        }
    }
    
    private static void printList(List<Student> list) {
        for (Student s : list) {
            System.out.println(s);
        }
    }
}
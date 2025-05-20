package study5;

import java.util.Objects;

class Student2 {
	private int id;
    private String name;
    
    public Student2(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    
    @Override
    public String toString() {
        return name;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student2 student2 = (Student2) o;
        return id == student2.id;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

class Course {
    private String code;
    private String name;
    private int credit;
    
    public Course(String code, String name, int credit) {
        this.code = code;
        this.name = name;
        this.credit = credit;
    }
    
    public String getCode() { return code; }
    public String getName() { return name; }
    public int getCredit() { return credit; }
    
    @Override
    public String toString() {
        return String.format("%s(%s)", name, code);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(code, course.code);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(code);
    }
}
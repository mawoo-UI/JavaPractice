package study6;

public class Student {
	private String name;
	private int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() { return name;}
	public int getScore() { return score;}
	
	public String toString() {
		return "Student[name=" + name + ", score=" + score + "]";
	}
}

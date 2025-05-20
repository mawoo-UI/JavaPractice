package study5;

class Student {
	private int id;
	private String name;
	private double gpa;
	
	public Student(int id, String name, double gpa) {
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}
	
	public int getId() {return id;}
	public String getName() {return name;}
	public double getGpa() {return gpa;}

	@Override
	public String toString() {
		return String.format("학생[학번=%d, 이름=%s, 평점=%.2f]", id, name, gpa);
	}
	
	
}

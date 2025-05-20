package study5;

class Task {
	private String name;
	private int priority;
	private String description;
	
	public Task(String name, int priority, String description) {
		this.name = name;
		this.priority = priority;
		this.description = description;
	}
	public String getName() { return name; }
	public int getPriority() { return priority;}
	public String getDescription() { return description;}
	
	@Override
	public String toString() {
		return String.format("작업[이름=%s, 우선순위=%d, 설명=%s]", name, priority, description);
	}
}
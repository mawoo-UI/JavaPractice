package study5;

import java.util.Date;

class Task2 implements Comparable<Task2> {
	private String name;
    private int priority; // 우선순위 (낮을수록 높은 우선순위)
    private long deadline; // 마감시간 (밀리초 단위)
    
    public Task2(String name, int priority, long deadline) {
    	this.name = name;
    	this.priority = priority;
    	this.deadline = deadline;
	}
    
    public String getName() { return name;}
    public int getPriority() { return priority;}
    public long getDeadline() { return deadline;}
    
	@Override
	public int compareTo(Task2 other) {
		// 우선순위 먼저 비교 (낮은 숫자가 높은 우선순위)
        int priorityCompare = Integer.compare(this.priority, other.priority);
        if (priorityCompare != 0) {
            return priorityCompare;
        }
        // 우선순위가 같다면 마감시간 비교 (빠른 것이 먼저)
        return Long.compare(this.deadline, other.deadline);
    }

	@Override
	public String toString() {
		Date date = new Date(deadline);
		return String.format("작업[이름=%s, 우선순위=%d, 마감=%s]", name, priority, date);
	}
}

package study5;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityTaskScheduler {
	public static void main(String[] args) {
		// 우선순위 큐 생성 - 작업을 우선순위와 마감시간으로 정렬
        PriorityQueue<Task2> taskQueue = new PriorityQueue<>();
        
        // 현재 시간 기준
        long now = System.currentTimeMillis();
        
        //작업 추가 (우선순위와 마감시간 설정)
        taskQueue.offer(new Task2("버그 수정", 1, now + 3600000));
        taskQueue.offer(new Task2("기능 개발", 2, now + 86400000));
        taskQueue.offer(new Task2("문서 작성", 3, now + 7200000));
        taskQueue.offer(new Task2("긴급 패치", 1, now + 1800000));
        taskQueue.offer(new Task2("회의 준비", 2, now + 3600000));
        
        System.out.println("=== 작업 스케줄러 - 우선순위 큐 ===");
        System.out.println("총 작업 수: " + taskQueue.size());
        
        System.out.println("\n=== 우선순위에 따른 작업 처리 순서 ===");
        while (!taskQueue.isEmpty()) {
			Task2 task = taskQueue.poll();
			
			// 현재 시간과 마감시간 비교
			long timeLeft = task.getDeadline() - System.currentTimeMillis();
			String status = timeLeft > 0 ?
					String.format("(남은 시간: %.1f분)", timeLeft / 60000.0) :
						"(마감 시간 초과!)";
			
			System.out.println("처리 중: " + task + " " + status);
			
			//작업 처리를 시뮬레이션 하기 위한 지연
			try {
				Thread.sleep(500); // 0.5초 지연
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
        
        System.out.println("\n=== 마감시간 기준 작업 스케줄러 ===");
        
        // 마감시간만으로 정렬하는 비교자 생성
        Comparator<Task2> deadlineComparator = Comparator.comparing(Task2::getDeadline);
        PriorityQueue<Task2> deadlineQueue = new PriorityQueue<>(deadlineComparator);
        
        // 동일한 작업들을 다시 추가
        deadlineQueue.offer(new Task2("버그 수정", 1, now + 3600000)); // 1시간 후
        deadlineQueue.offer(new Task2("기능 개발", 2, now + 86400000)); // 1일 후
        deadlineQueue.offer(new Task2("문서 작성", 3, now + 7200000));  // 2시간 후
        deadlineQueue.offer(new Task2("긴급 패치", 1, now + 1800000));  // 30분 후
        deadlineQueue.offer(new Task2("회의 준비", 2, now + 3600000));  // 1시간 후
        
        System.out.println("총 작업 수: " + deadlineQueue.size());
        
        System.out.println("\n=== 마감시간에 따른 작업 처리 순서 ===");
        while (!deadlineQueue.isEmpty()) {
			Task2 task = deadlineQueue.poll();
			
			long timeLeft = task.getDeadline() - System.currentTimeMillis();
			String status = timeLeft > 0 ?
					String.format("(남은 시간: %.1f분)", timeLeft / 60000.0) : 
	                    "(마감 시간 초과!)";
			
			System.out.println("처리 중: " + task + " " + status);
		}
	}
}

package study5;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class TaskSchedulerExample {
	public static void main(String[] args) {
		// 큐 사용 예제: LinkedList로 FIFO 구현
		System.out.println("=== 작업 큐 예제 (FIFO) ===");
		Queue<Task> taskQueue = new LinkedList<>();
		
		taskQueue.offer(new Task("데이터 백업", 3, "서버 데이터 백업 수행"));
		taskQueue.offer(new Task("이메일 발송", 2, "월간 뉴스레터 발송"));
		taskQueue.offer(new Task("보고서 생성", 1, "주간 성과 보고서 작성"));
		
		System.out.println("대기 중인 작업 수: " + taskQueue.size());
		
		System.out.println("\n작업 처리 순서:");
		while (!taskQueue.isEmpty()) {
			Task currentTask = taskQueue.poll();
			System.out.println("처리 중: " + currentTask);
			
		}
		System.out.println("\n=== 작업 스택 예제 (LIFO) ===");
		Deque<Task> taskStack = new LinkedList<>();
		
		taskStack.push(new Task("메인 페이지 개발", 2, "웹사이트 메인 페이지 코딩"));
		taskStack.push(new Task("로그인 기능 구현", 1, "사용자 인증 시스템 개발"));
		taskStack.push(new Task("UI 디자인 수정", 3, "사용자 피드백 반영한 UI 개선"));
		
		System.out.println("대기 중인 작업 수: " + taskStack.size());
		while (!taskStack.isEmpty()) {
			Task currentTask = taskStack.pop();
			System.out.println("처리 중: " + currentTask );
			
		}
		System.out.println("\n=== 양방향 큐 예제 ===");
		Deque<String> browserHistory = new LinkedList<>();
		
		browserHistory.addLast("홈페이지");
		browserHistory.addLast("상품 목록");
		browserHistory.addLast("상품 상세");
		browserHistory.addLast("장바구니");
		
		System.out.println("현재 방문 기록: " + browserHistory);
		
		//뒤로 가기(마지막 방문한 페이지 제거)
		
		String lastVisited = browserHistory.removeLast();
		System.out.println("뒤로가기: " + lastVisited + "페이지에서 나옴");
		System.out.println("현재 페이지: " + browserHistory.peekLast());
		
		// 앞으로 가기를 위한 스택이 있다고 가정
		Deque<String> forwardStack = new LinkedList<>();
		forwardStack.push(lastVisited);
		
		// 다시 앞으로 가기
		if (!forwardStack.isEmpty()) {
			String nextPage = forwardStack.pop();
			browserHistory.addLast(nextPage);
			System.out.println("앞으로 가기: " + nextPage + "페이지로 이동");
		}
		System.out.println("최종 방문 기록: " + browserHistory);
	}
}

package study7;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
	public static void main(String[] args) {
		// 고정 크기 스레드 풀 생성 (3개의 스레드)
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		// 10개의 작업 제출
		for (int i = 0; i < 10; i++) {
			final int taskId = i;
			executor.submit(() -> {
				System.out.println("Task" + taskId + "시작, 스레드:" +
						Thread.currentThread().getName());
				
				try {
					//작업 시뮬레이션
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					 Thread.currentThread().interrupt();
				}
				System.out.println("Task" + taskId + "완료, 스레드: " +
						Thread.currentThread().getName());
				return null;
			});
		}
		
		// 새 작업 접수 중단
		executor.shutdown();
		
		try {
			// 모든 작업이 완료될 때 까지 대기 (최대 10초)
			
			if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
				// 타임아웃 발생 시 강제 종료
				executor.shutdownNow();
			}
		} catch (InterruptedException e) {
			executor.shutdownNow();
		}
		
		System.out.println("모든 작업 완료");
		
		
	}
}

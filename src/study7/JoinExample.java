package study7;

import java.util.Iterator;

public class JoinExample {
	public static void main(String[] args) {
		System.out.println("메인 스레드 시작");
		
		Thread worker = new Thread(()-> {
			System.out.println("작업 스레드 시작");
			try {
				for (int i = 0; i < 5; i++) {
					System.out.println("작업 진행 중..." + (i+1) + "/5");
					Thread.sleep(1000);
				}
				System.out.println("작업 스레드 완료");
			} catch (InterruptedException e) {
				 e.printStackTrace();
			}
		});
		worker.start();
		
		try {
			worker.join();
			System.out.println("메인 스레드: 작업 스레드 완료 확인");
		} catch (InterruptedException e) {
			 e.printStackTrace();
		}
		System.out.println("메인 스레드 종료");
	}
}

package study7;

public class DeadlockExample {
	private static final Object RESOURCE_A = new Object();
	private static final Object RESOURCE_B = new Object();
	
	public static void main(String[] args) {
		// 데드락 발생 시뮬레이션
	       Thread thread1 = new Thread(() -> {
	            System.out.println("Thread 1: RESOURCE_A 획득 시도");
	            synchronized (RESOURCE_A) {
	                System.out.println("Thread 1: RESOURCE_A 획득 성공");
	                try {
	                    Thread.sleep(100); // 데드락 발생 가능성 높이기
	                } catch (InterruptedException e) {}
	                
	                System.out.println("Thread 1: RESOURCE_B 획득 시도");
	                synchronized (RESOURCE_B) {
	                    System.out.println("Thread 1: RESOURCE_B 획득 성공");
	                }
	            }
	            System.out.println("Thread 1: 모든 작업 완료");
	        });
	        
	        Thread thread2 = new Thread(() -> {
	            System.out.println("Thread 2: RESOURCE_B 획득 시도");
	            synchronized (RESOURCE_B) {
	                System.out.println("Thread 2: RESOURCE_B 획득 성공");
	                try {
	                    Thread.sleep(100); // 데드락 발생 가능성 높이기
	                } catch (InterruptedException e) {}
	                
	                System.out.println("Thread 2: RESOURCE_A 획득 시도");
	                synchronized (RESOURCE_A) {
	                    System.out.println("Thread 2: RESOURCE_A 획득 성공");
	                }
	            }
	            System.out.println("Thread 2: 모든 작업 완료");
	        });
	        
	        thread1.start();
	        thread2.start();
	        
	        // 데드락 방지 예시 (리소스 순서 일관성 유지)
	        Thread safeThread1 = new Thread(() -> {
	            System.out.println("SafeThread 1: 항상 RESOURCE_A 먼저 획득");
	            synchronized (RESOURCE_A) {
	                System.out.println("SafeThread 1: RESOURCE_A 획득 성공");
	                try {
	                    Thread.sleep(100);
	                } catch (InterruptedException e) {}
	                
	                System.out.println("SafeThread 1: RESOURCE_B 획득 시도");
	                synchronized (RESOURCE_B) {
	                    System.out.println("SafeThread 1: RESOURCE_B 획득 성공");
	                }
	            }
	            System.out.println("SafeThread 1: 모든 작업 완료");
	        });
	        
	        Thread safeThread2 = new Thread(() -> {
	            System.out.println("SafeThread 2: 항상 RESOURCE_A 먼저 획득");
	            synchronized (RESOURCE_A) {
	                System.out.println("SafeThread 2: RESOURCE_A 획득 성공");
	                try {
	                    Thread.sleep(100);
	                } catch (InterruptedException e) {}
	                
	                System.out.println("SafeThread 2: RESOURCE_B 획득 시도");
	                synchronized (RESOURCE_B) {
	                    System.out.println("SafeThread 2: RESOURCE_B 획득 성공");
	                }
	            }
	            System.out.println("SafeThread 2: 모든 작업 완료");
	        });
	        
	        // 안전한 스레드는 첫 번째 예제가 데드락에 빠진 후에 실행
	        try {
	            Thread.sleep(5000);
	            System.out.println("\n데드락 방지 예제 시작\n");
	            safeThread1.start();
	            safeThread2.start();
	        } catch (InterruptedException e) {}
	    }
	}

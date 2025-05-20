package study7;

public class LambdaThreadExample {
	public static void main(String[] args) {
		//람다식으로 Runnable 구현
		Thread thread1 = new Thread(()-> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Thread1: " + i);
				try {
					Thread.sleep(500);
					
				} catch (InterruptedException e) {
					 e.printStackTrace();
				}
			}
		});
		Thread thread2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("Thread 2: " + i);
				try {
					Thread.sleep(700);
				} catch (InterruptedException e) {
					 e.printStackTrace();
				}
			}
		});
		
		thread1.start();
		thread2.start();
		
	}
}

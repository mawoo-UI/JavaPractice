package study7;

import java.util.Iterator;

public class ProducerConsumerExample {
	public static void main(String[] args) {
		MessageQueue queue = new MessageQueue();
		
		// 생산자 스레드
		Thread producer = new Thread(() -> {
			String[] messages = {
				"Hello", "World", "This", "Is", "Producer", "Consumer", "Example", "END"	
			};
			
			for (String msg : messages) {
				queue.send(msg);
				System.out.println("생산: " + msg);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					 Thread.currentThread().interrupt();
				}
			}
		});
		
		// 소비자 스레드
		Thread consumer = new Thread(() -> {
			String message;
			do {
				message = queue.receive();
				System.out.println("소비: " + message);
				
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					 Thread.currentThread().interrupt();
				}
			} while (!"End".equals(message));
			
			System.out.println("소비자 종료");
		});
		
		producer.start();
		consumer.start();
	}
}

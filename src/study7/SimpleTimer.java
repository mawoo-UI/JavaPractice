package study7;

public class SimpleTimer {
	public static void main(String[] args) {
		Thread timerThread = new Thread(()-> {
			for (int i= 10; i > 0; i--) {
				System.out.println("카운트다운: " + i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					 System.out.println("타이머 중단됨!");
					 return;
				}
			}
			System.out.println("타이머 종료!");
		});
		timerThread.start();
		
		//5초 후에 타이머 중단
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			 e.printStackTrace();
		}
	}
}

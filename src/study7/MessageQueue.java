package study7;

class MessageQueue {
	private String mesage;
	private boolean isEmpty = true;
	
	public synchronized String receive() {
		while (isEmpty) {
			try {
				wait();
			} catch (InterruptedException e) {
				 Thread.currentThread().interrupt();
			}
		}
		
		isEmpty = true;
		notifyAll(); // 생산자에게 공간이 생겼음을 알림
		return mesage;
	}
	public synchronized  void send(String message) {
		while (!isEmpty) {
			try {
				wait();
			} catch (InterruptedException e) {
				 Thread.currentThread().interrupt();
			}
		}
		
		this.mesage = message;
		isEmpty = false;
		notifyAll(); // 소비자에게 메세지가 도착했음을 알림
		
	}
}

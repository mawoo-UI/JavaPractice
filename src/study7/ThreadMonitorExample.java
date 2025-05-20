package study7;

public class ThreadMonitorExample {
	public static void main(String[] args) {
		// 스레드 그룹 생성
		ThreadGroup workerGroup = new ThreadGroup("WorkerGroup");
        
		final Object waitLock = new Object();
		
        // 다양한 상태의 스레드 생성
        Thread sleepingThread = new Thread(workerGroup, () -> {
            try {
                System.out.println("Sleeping 스레드 시작");
                Thread.sleep(10000);
                System.out.println("Sleeping 스레드 종료");
            } catch (InterruptedException e) {
                System.out.println("Sleeping 스레드 인터럽트됨");
            }
        }, "SleepingThread");
        
        Thread runningThread = new Thread(workerGroup, () -> {
            System.out.println("Running 스레드 시작");
            long sum = 0;
            for (long i = 0; i < 10_000_000_000L; i++) {
                sum += i;
                if (Thread.interrupted()) {
                    System.out.println("Running 스레드 인터럽트됨");
                    break;
                }
            }
            System.out.println("Running 스레드 종료: " + sum);
        }, "RunningThread");
        
        Thread waitingThread = new Thread(workerGroup, () -> {
            System.out.println("Waiting 스레드 시작");
            synchronized (waitLock) {  // 별도 객체를 사용
                try {
                    waitLock.wait();  // 스레드 객체 대신 waitLock 객체에 대해 wait 호출
                    System.out.println("Waiting 스레드 깨어남");
                } catch (InterruptedException e) {
                    System.out.println("Waiting 스레드 인터럽트됨");
                }
            }
            System.out.println("Waiting 스레드 종료");
        }, "WaitingThread");
        
        sleepingThread.start();
        runningThread.start();
        waitingThread.start();
        
        // 모니터링 스레드
        Thread monitorThread = new Thread(() -> {
            while (true) {
                System.out.println("\n--- 스레드 상태 모니터링 ---");
                System.out.println("활성 스레드 수: " + workerGroup.activeCount());
                
                Thread[] threads = new Thread[workerGroup.activeCount()];
                workerGroup.enumerate(threads);
                
                for (Thread t : threads) {
                    if (t != null) {
                        System.out.println(t.getName() + ": " + t.getState());
                    }
                }
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }, "MonitorThread");
        
        monitorThread.start();
        
        // 5초 후 모든 스레드 인터럽트
        try {
            Thread.sleep(5000);
            System.out.println("\n모든 작업자 스레드 인터럽트");
            workerGroup.interrupt();
            
            // 모니터링 스레드 종료 대기
            Thread.sleep(2000);
            monitorThread.interrupt();
            monitorThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("\n모니터링 종료");
    }
}

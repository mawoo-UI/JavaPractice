package study7;

import java.util.Iterator;

public class BankAccountExample {
	public static void main(String[] args) throws InterruptedException {
		// 안전하지 않은 계좌 테스트
        BankAccount unsafeAccount = new BankAccount();
        
        Thread[] unsafeThreads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            unsafeThreads[i] = new Thread(() -> {
                unsafeAccount.depositUnsafe(100);
            });
            unsafeThreads[i].start();
        }
        
        // 모든 스레드 완료 대기
        for (Thread t : unsafeThreads) {
            t.join();
        }
        
        System.out.println("동기화되지 않은 계좌 최종 잔액 (예상: 10,000): " + unsafeAccount.getBalance());
        
        // 동기화된 계좌 테스트
        BankAccount safeAccount = new BankAccount();
        
        Thread[] safeThreads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            safeThreads[i] = new Thread(() -> {
                safeAccount.depositSafe(100);
            });
            safeThreads[i].start();
        }
        
        // 모든 스레드 완료 대기
        for (Thread t : safeThreads) {
            t.join();
        }
        
        System.out.println("동기화된 계좌 최종 잔액 (예상: 10,000): " + safeAccount.getBalance());
    }
}
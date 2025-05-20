package study7;

class BankAccount {
    private int balance = 0;
    
    // 동기화되지 않은 메소드 - 문제 발생 가능
    public void depositUnsafe(int amount) {
        int newBalance = balance + amount;
        
        // 스레드 스위칭이 발생할 수 있는 상황 시뮬레이션
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {}
        
        balance = newBalance;
    }
    
    // 동기화된 메소드 - 안전
    public synchronized void depositSafe(int amount) {
        int newBalance = balance + amount;
        
        // 스레드 스위칭이 발생할 수 있는 상황 시뮬레이션
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {}
        
        balance = newBalance;
    }
    
    public int getBalance() {
        return balance;
    }
}
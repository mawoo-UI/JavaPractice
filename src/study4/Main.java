package study4;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);
        
        try {
            account.withdraw(1500);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
            System.out.println("현재 잔액: " + e.getBalance());
            System.out.println("출금 시도 금액: " + e.getWithdrawalAmount());
            System.out.println("부족한 금액: " + e.getDeficit());
        }
    }
}
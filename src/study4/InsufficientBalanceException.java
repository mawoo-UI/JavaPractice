package study4;

public class InsufficientBalanceException extends Exception {
    private final double balance;
    private final double withdrawalAmount;
    
    public InsufficientBalanceException(String message, double balance, double withdrawalAmount) {
        super(message);
        this.balance = balance;
        this.withdrawalAmount = withdrawalAmount;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public double getWithdrawalAmount() {
        return withdrawalAmount;
    }
    
    public double getDeficit() {
        return withdrawalAmount - balance;
    }
}

package study4;

public class BankAccount {
	private double balance;
	
	public BankAccount(double initialBalance) {
		this.balance = initialBalance;
		
	}
	public void withdraw(double amount) throws InsufficientBalanceException {
		if (amount > balance) {
			throw new InsufficientBalanceException(
					"잔액 부족: 출금 금액이 계좌 잔액을 초과합니다.", amount, amount);
		}
		
		balance -= amount;
	}
}

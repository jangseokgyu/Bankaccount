//Model MVC 'M' 계산.
import javax.swing.JOptionPane;

public class BankAccount {
	private int balance;
	
	public BankAccount(int initial_amount) {
		if(initial_amount >= 0)
			balance = initial_amount;
		else
			balance = 0;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public boolean deposit(int amount) {
		boolean result = false;
		if(amount < 0)
			JOptionPane.showMessageDialog(null,"잘못된 입금액이라 무시합니다.");
		else {
			balance = balance + amount;
			result = true;
		}
		return result;
	}
	
	public boolean withdraw(int amount) {
		boolean result = false;
		if(amount < 0)
			JOptionPane.showMessageDialog(null, "잘못된 출금액이라 무시합니다.");
		else if(amount > balance)
			JOptionPane.showMessageDialog(null,"잔고가 부족합니다.");
		else {
			balance -=amount;
		}
		return result;
	}
	
	
}

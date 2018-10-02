//controller MVC 'C'
public class AccountController {
	private BankReader reader;
	private BankWriter writer;
	private BankAccount account;
	
	public AccountController(BankReader r, BankWriter w, BankAccount a) {
		reader = r;
		account = a;
		writer = w;
	}
	
	public void processTransaction()
	{
		char command = reader.readCommand("명령 D/W/Q와 금액을 입력하세요.");
		switch(command) {
		case 'Q':
			return;
		case 'D':
		{
			int amount = reader.readAmount();
			if(account.deposit(amount))
				writer.showTransaction("입금 $", amount);
			else {
				writer.showTransaction("입금 오류 ", amount);
				break;
				}
		}
		case 'W':
		{
			int amount = reader.readAmount();
			if(account.withdraw(amount))
				writer.showTransaction("출금 $", amount);
			else {
				writer.showTransaction("출금 오류 ", amount);
				break;
			}
		}
		default:
			writer.showTransaction("잘못된 명령 "+command);
		}
		this.processTransaction();
	}
}
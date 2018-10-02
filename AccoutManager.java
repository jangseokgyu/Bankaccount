
public class AccountManager {
	public static void main(String[] args)
	{
		BankReader reader = new BankReader();
		BankAccount account = new BankAccount(0);
		BankWriter writer = new BankWriter("은행계좌 관리", account);
		AccountController controller = new AccountController(reader,writer,account);
		controller.processTransaction();
	}

}

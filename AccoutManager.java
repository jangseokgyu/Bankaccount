//구동 클래스
public class AccountManager {
    public static void main(String[] args) { 
        BankReader reader = new BankReader();
        BankAccount primary_account = new BankAccount(0);
        BankWriter primary_writer = new BankWriter(primary_account);
        BankAccount secondary_account = new BankAccount(0);
        BankWriter secondary_writer = new BankWriter(secondary_account);
        AccountController controller = new AccountController(reader,
                primary_account, primary_writer, secondary_account,
                secondary_writer);
        controller.processTransactions();
    }
}
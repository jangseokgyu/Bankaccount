import java.text.DecimalFormat;

class BankWriter 
{
    private BankAccount bank;
    private String last_transaction = "";

    public BankWriter(BankAccount b) {
        bank = b;
    }

    public String unconvert(int i) {
        return new DecimalFormat("0.00").format(i/100.0);
    }
//메세지와 금액에 해당하는 최근거래를 화면에 출력
    public void setTransaction(String message, int amount)
    { 
        last_transaction = message + " " + unconvert(amount);
        System.out.println("transaction: " + last_transaction);
    }
//메세지에 해당하는 최근 거래를 화면에 출력
    public void setTransaction(String message)
    { 
        last_transaction = message;
        System.out.println("transaction: " + last_transaction);
    }

}

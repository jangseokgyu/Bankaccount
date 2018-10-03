
class BankAccount 
{
    private int balance;
//계좌 잔고를 initial로 초기화
    public BankAccount(int initial_amount) {
         if (initial_amount >= 0)
             balance = initial_amount;
         else
             balance = 0;
    }
//잔액반환
    public int getBalance() {
        return balance;
    }
//양수일때 잔액에 더하기
    public boolean deposit(int amount) {
        boolean result = false;
        if (amount < 0)
             System.out.println("invalid deposit amount");
         else {
             balance = balance + amount;
             result = true;
         }
         return result;
    }
//양수일때 잔액에서 출고
    public boolean withdraw(int amount) {
        boolean result = false;
        if (amount < 0)
            System.out.println("invalid withdraw amount");
        else if (amount > balance)
            System.out.println("not enough balance");
        else {
            balance = balance - amount;
            result = true;
        }
        return result;
    }
}
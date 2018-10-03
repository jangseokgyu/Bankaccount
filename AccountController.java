class AccountController
{
    private BankReader reader; // input view
    private BankAccount primary_account, secondary_account, account;
    private BankWriter primary_writer, secondary_writer, writer;
//객체 조기화
    public AccountController (BankReader r, BankAccount a1,BankWriter w1, BankAccount a2, BankWriter w2)
    {
        reader = r;
        primary_account = a1;
        primary_writer = w1;
        secondary_account = a2;
        secondary_writer = w2;
        account = primary_account;
        writer = primary_writer;
    }

    public void resetAccount (BankAccount new_account,BankWriter new_writer) {
        account = new_account;//account가 일종의 temp
        writer = new_writer;//BankWriter의 객체 temp
    }
//하나의 거래 수행
    public void processTransactions()
    {
        char command = reader.readCommand("명령 P/S/D/W/Q/T/I와 금액을 입력하세요.");

        switch (command) {
            case 'P':
                resetAccount(primary_account, primary_writer);
                break;
            case 'S':
                resetAccount(secondary_account, secondary_writer);
                break;
            case 'Q':
                System.out.println("Quit");
                return;
            case 'D':
                { 
                    System.out.println("Deposit");
                    int amount = reader.readAmount();//첫글자 제외 00.00 달러를 센트로 변환하여 저장
                    if (account.deposit(amount)) writer.setTransaction("deposit $", amount); //true시  amount에 .00붙여 출력
                    else writer.setTransaction("deposit error ", amount);
                    break;
                }
            case 'W':
                { 
                    System.out.println("Withdraw");
                    int amount = reader.readAmount();
                    if (account.withdraw(amount)) writer.setTransaction("withdraw $", amount);
                    else writer.setTransaction("withdraw error ", amount);
                    break;
                }
            case 'T':
            {
            	System.out.println("Transfer");
            	int amount = reader.readAmount();
                // 'T 금액', 활성 계좌에서 비활성 계좌로 금액만큼 이체
            	if (account.withdraw(amount)) writer.setTransaction("Transfer $", amount); //true시  amount에 .00붙여 출력
                else {
                	writer.setTransaction("Transfer error please retyping ", amount);
                	break;
                }
            	
            	if (account == primary_account)
            		resetAccount(secondary_account, secondary_writer);
            	else if (account == secondary_account)
            		resetAccount(primary_account, primary_writer);
            	
            	if(account.deposit(amount))
            		;
            
            	if (account == primary_account)
            		resetAccount(secondary_account, secondary_writer);
            	else if (account == secondary_account)
            		resetAccount(primary_account, primary_writer);
                break;
            }
            case 'I':	
            {
            	System.out.println("Interest");
            	double interest = (double)reader.readAmount()/100.0;
            	if((int)interest > 1 || (int)interest < 0) 
            	{
            		System.out.println("이율은 0~1범위의 실수 입니다. ");
            		break;
            	}
            	int temp = account.getBalance();
            	double tempt = (double)temp*interest;
            	if(account.deposit((int)tempt))
            		;
            	
                // 'I 이율', 활성 계좌의 금액을 이율만큼 증가
                break;
            }
            default:
                writer.setTransaction("invalid commpand: " + command);
        }
        // 모든 계좌의 정보를 출력합니다.
        System.out.println("=======================");
        System.out.println("== currently active : " + ((account == primary_account) ? "primary" : "secondary"));
        System.out.println("== primary account : " + primary_writer.unconvert(primary_account.getBalance()));
        System.out.println("== secondary account : " + secondary_writer.unconvert(secondary_account.getBalance()));
        System.out.println("=======================");

        this.processTransactions();
    }
}

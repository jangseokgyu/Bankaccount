import java.util.Scanner;

class BankReader 
{
    private String input_line = "";
//명령어가 무엇인지 보고 첫 알파벳글자를 반환
    public char readCommand(String message) {
        Scanner scan = new Scanner(System.in);  // Reading from System.in
        System.out.println(message);
        input_line = scan.nextLine().toUpperCase();
        return input_line.charAt(0);
    }
//첫글자 제외 00.00 달러를 센트로 변환하여 반환
    public int readAmount()
    {
        int answer = 0;
        String s = input_line.substring(1, input_line.length());

        if(s.length() > 0) {
            double dollars_cents = new Double(s).doubleValue();
            answer = (int)(dollars_cents*100);
        } else
            System.out.println("invalid command - input amount: 0");
        return answer;
    }
}

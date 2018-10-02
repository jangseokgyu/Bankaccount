import java.awt.*;
import javax.swing.*;
import java.text.*;

public class BankWriter extends JPanel {
	private int WIDTH = 300;
	private int HEIGHT = 200;
	private BankAccount bank;
	private String last_transaction = "";
	
	public BankWriter(String title, BankAccount b) {
		bank = b;
		JFrame f = new JFrame();
		f.getContentPane().add(this);
		f.setTitle(title);
		f.setSize(WIDTH,HEIGHT);
		f.setBackground(Color.white);
		f.setVisible(true);
	}
	
	private String unconvert(int i) {
		return new DecimalFormat("0.00").format(i/100.0);
	}
	
	public void showTransaction(String message, int amount) {
		last_transaction = message + " " + unconvert(amount);
		this.repaint();
	}
	
	public void showTransaction(String message) {
		last_transaction = message;
		this.repaint();
	}
	
	public void paintComponet(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0,0,WIDTH,HEIGHT);
		g.setColor(Color.black);
		int text_margin = 50;
		int text_baseline = 50;
		g.drawString(last_transaction,  text_margin,text_baseline);
		g.drawString("현재 잔고는 $" + unconvert(bank.getBalance()),text_margin, text_baseline + 20);
		}
}

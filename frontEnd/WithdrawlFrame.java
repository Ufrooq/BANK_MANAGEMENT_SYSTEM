import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WithdrawlFrame extends JFrame {
	JLabel l1;
	JButton b1, b2, b3, b4, b5, b6, b7;
	Client cl;
	String[] money = { "500", "1000", "5000", "10000", "15000", "20000" };

	WithdrawlFrame(Client c) {
		cl = c;
		setSize(700, 600);
		setTitle("Withdrawl Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		l1 = new JLabel("SELECT FROM GIVEN OPTIONS");
		l1.setBounds(240, 50, 300, 50);
		add(l1);
		b1 = new JButton("500");
		b1.setBounds(100, 150, 100, 100);
		b2 = new JButton("1000");
		b2.setBounds(100, 270, 100, 100);
		b3 = new JButton("5000");
		b3.setBounds(100, 390, 100, 100);
		b4 = new JButton("10000");
		b4.setBounds(450, 150, 100, 100);
		b5 = new JButton("15000");
		b5.setBounds(450, 270, 100, 100);
		b6 = new JButton("20000");
		b6.setBounds(450, 390, 100, 100);

		b7 = new JButton("Return");
		b7.setBounds(250, 490, 155, 60);

		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);
		add(b7);

		MyActionListener a = new MyActionListener();
		b1.addActionListener(a);
		b2.addActionListener(a);
		b3.addActionListener(a);
		b4.addActionListener(a);
		b5.addActionListener(a);
		b6.addActionListener(a);
		b7.addActionListener(a);

		setVisible(true);
		setResizable(false);
	}

	public class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			FileOperations fo = new FileOperations();
			String matchMoney = "";
			for (String mon : money) {
				if (ae.getActionCommand().equals(mon)) {
					matchMoney = mon;
					break;
				}
			}
			if (matchMoney.equals("500") || matchMoney.equals("1000") ||
					matchMoney.equals("5000") || matchMoney.equals("10000")
					|| matchMoney.equals("15000") || matchMoney.equals("20000")) {
				if (cl.getAccount().getBalance() >= Integer.parseInt(matchMoney)) {
					JOptionPane.showMessageDialog(null, "Amount withdrawn Successfully");
					double b = cl.getAccount().getBalance() - Integer.parseInt(matchMoney);
					cl.getAccount().setBalance(b);
					String name = cl.getName();
					String AccountNo = cl.getAccount().getAccountNum();
					fo.updateBalance(name, AccountNo, b);
				} else {
					JOptionPane.showMessageDialog(null, "Insufficient Balance");
				}
			} else {
				dispose();
				ATMFrame af = new ATMFrame(cl);
			}
		}
	}
}
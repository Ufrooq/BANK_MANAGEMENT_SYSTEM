import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DepositFrame extends JFrame {
	JLabel l1;
	JTextField t1;
	JButton b1, b2, b3, b4, b5, b6, b7, b8;
	String[] array = { "500", "1000", "5000", "10000", "20000", "50000" };

	Client cl;

	DepositFrame(Client c) {
		cl = c;

		setSize(700, 600);
		setTitle("Withdrawl Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		l1 = new JLabel("ENTER AMOUNT OR SELECT FROM GIVEN OPTIONS");
		l1.setBounds(180, 50, 300, 30);
		add(l1);
		t1 = new JTextField();
		t1.setBounds(220, 100, 80, 40);
		add(t1);
		b8 = new JButton("Deposit");
		b8.setBounds(320, 100, 100, 40);
		b1 = new JButton("500");
		b1.setBounds(100, 150, 100, 100);
		b2 = new JButton("1000");
		b2.setBounds(100, 270, 100, 100);
		b3 = new JButton("5000");
		b3.setBounds(100, 390, 100, 100);
		b4 = new JButton("10000");
		b4.setBounds(450, 150, 100, 100);
		b5 = new JButton("20000");
		b5.setBounds(450, 270, 100, 100);
		b6 = new JButton("50000");
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
		add(b8);

		MyActionListener a = new MyActionListener();
		b1.addActionListener(a);
		b2.addActionListener(a);
		b3.addActionListener(a);
		b4.addActionListener(a);
		b5.addActionListener(a);
		b6.addActionListener(a);
		b7.addActionListener(a);
		b8.addActionListener(a);

		setVisible(true);
		setResizable(false);
	}

	public class MyActionListener implements ActionListener {
		String match = "";

		public void actionPerformed(ActionEvent ae) {
			FileOperations fo = new FileOperations();
			for (int i = 0; i < array.length; i++) {
				if (ae.getActionCommand().equals(array[i])) {
					match = array[i];
					break;
				}
			}
			if (ae.getActionCommand().equals(match)) {
				JOptionPane.showMessageDialog(null, "Amount Deposited Successfully");
				double increment = Double.parseDouble(match);
				double b = cl.getAccount().getBalance() + increment;
				cl.getAccount().setBalance(b);
				String name = cl.getName();
				String AccountNo = cl.getAccount().getAccountNum();
				fo.updateBalance(name, AccountNo, b);
			} else if (ae.getActionCommand().equals("Deposit")) {
				if (t1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Enter some amount");
				} else {
					Double amount = Double.parseDouble(t1.getText());
					if (amount > 50000) {
						JOptionPane.showMessageDialog(null, "Amount should be less than 50000");
					} else {
						JOptionPane.showMessageDialog(null, "Amount Deposited Successfully");
						double b = cl.getAccount().getBalance() + amount;
						cl.getAccount().setBalance(b);
						String name = cl.getName();
						String AccountNo = cl.getAccount().getAccountNum();
						fo.updateBalance(name, AccountNo, b);
					}
				}
			} else if (ae.getActionCommand().equals("Return")) {
				dispose();
				ATMFrame af = new ATMFrame(cl);
			}
		}
	}
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ATMFrame extends JFrame {
	JButton b1, b2, b3;
	Client cl;

	ATMFrame(Client c) {
		cl = c;
		setSize(700, 600);
		setTitle("ATM Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(3, 1));

		b1 = new JButton("Withdraw");
		b2 = new JButton("Deposit");
		b3 = new JButton("Return");

		add(b1);
		add(b2);
		add(b3);

		MyActionListener a = new MyActionListener();
		b1.addActionListener(a);
		b2.addActionListener(a);
		b3.addActionListener(a);

		setVisible(true);
		setResizable(false);
	}

	public class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if (ae.getActionCommand().equals("Withdraw")) {
				dispose();
				WithdrawlFrame w = new WithdrawlFrame(cl);
			} else if (ae.getActionCommand().equals("Deposit")) {
				dispose();
				DepositFrame d = new DepositFrame(cl);

			} else if (ae.getActionCommand().equals("Return")) {
				dispose();
				ClientFrame cf = new ClientFrame(cl);
			}

		}
	}
}
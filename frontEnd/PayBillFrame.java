import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class PayBillFrame extends JFrame {
	JLabel l1;
	JTextField t1;
	JButton b1, b2;

	Client cl;

	PayBillFrame(Client c) {
		cl = c;
		setSize(400, 350);
		setTitle("Pay Bill Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		l1 = new JLabel("Enter Bill Amount: ");
		l1.setBounds(50, 50, 270, 100);
		t1 = new JTextField();
		t1.setBounds(210, 80, 100, 40);
		b1 = new JButton("Pay");
		b2 = new JButton("Return");
		b1.setBounds(50, 180, 100, 30);
		b2.setBounds(180, 180, 100, 30);

		add(l1);
		add(t1);
		add(b1);
		add(b2);

		MyActionListener a = new MyActionListener();
		b1.addActionListener(a);
		b2.addActionListener(a);

		setVisible(true);
		setResizable(false);
	}

	public class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			ValidationsClass v = new ValidationsClass();
			FileOperations fo = new FileOperations();
			if (ae.getActionCommand().equals("Pay")) {
				if (v.checkNumber(t1.getText())) {
					JOptionPane.showMessageDialog(null, "Enter digits only");
				} else {
					Double paid = Double.parseDouble(t1.getText());
					if (paid < cl.getAccount().getBalance()) {
						JOptionPane.showMessageDialog(null, "Bill Paid Successfully");
						double b = cl.getAccount().getBalance() - paid;
						String name = cl.getName();
						String AccountNo = cl.getAccount().getAccountNum();

						fo.updateBalance(name, AccountNo, b);
					} else {
						JOptionPane.showMessageDialog(null, "Insufficient Balance to Pay Bill");
					}
				}
			} else if (ae.getActionCommand().equals("Return")) {
				dispose();
				BillsFrame b = new BillsFrame(cl);
			}
		}
	}

}
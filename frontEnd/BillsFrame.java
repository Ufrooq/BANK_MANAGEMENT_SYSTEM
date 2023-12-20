import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BillsFrame extends JFrame {
	JButton b1, b2, b3, b4, b5;
	Client cl;

	BillsFrame(Client c) {
		cl = c;
		setSize(700, 600);
		setTitle("Bills Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		b1 = new JButton("Electricity Bill");
		b1.setBounds(100, 50, 500, 100);
		b2 = new JButton("Gas Bill");
		b2.setBounds(100, 170, 500, 100);
		b3 = new JButton("Water Bill");
		b3.setBounds(100, 290, 500, 100);
		b4 = new JButton("Phone Bill");
		b4.setBounds(100, 410, 500, 100);
		b5 = new JButton("Return");
		b5.setBounds(500, 520, 100, 30);

		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);

		MyActionListener a = new MyActionListener();
		b1.addActionListener(a);
		b2.addActionListener(a);
		b3.addActionListener(a);
		b4.addActionListener(a);
		b5.addActionListener(a);

		setVisible(true);
		setResizable(false);
	}

	public class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if (ae.getActionCommand().equals("Electricity Bill")) {
				dispose();
				PayBillFrame p = new PayBillFrame(cl);
			} else if (ae.getActionCommand().equals("Gas Bill")) {
				dispose();
				PayBillFrame p = new PayBillFrame(cl);
			} else if (ae.getActionCommand().equals("Water Bill")) {
				dispose();
				PayBillFrame p = new PayBillFrame(cl);
			} else if (ae.getActionCommand().equals("Phone Bill")) {
				dispose();
				PayBillFrame p = new PayBillFrame(cl);
			} else if (ae.getActionCommand().equals("Return")) {
				dispose();
				ClientFrame cf = new ClientFrame(cl);
			}
		}
	}

}
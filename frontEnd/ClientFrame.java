import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientFrame extends JFrame {
	JButton b1, b2, b3, b4;
	Client cl;

	ClientFrame(Client c) {
		cl = c;
		setSize(700, 600);
		setTitle("Client Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(4, 1));

		b1 = new JButton("Check Balance");
		// b1.setBounds(100,150,200,200);
		b2 = new JButton("Pay Bills");
		// b2.setBounds(380,150,200,200);
		b3 = new JButton("Use ATM");
		// b3.setBounds(600,500,80,50);
		b4 = new JButton("Sign Out");

		add(b1);
		add(b2);
		add(b3);
		add(b4);

		MyActionListener a = new MyActionListener();
		b1.addActionListener(a);
		b2.addActionListener(a);
		b3.addActionListener(a);
		b4.addActionListener(a);

		setVisible(true);
		setResizable(false);
	}

	public class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if (ae.getActionCommand().equals("Check Balance")) {
				JOptionPane.showMessageDialog(null, "Your current Balance is: " + cl.getAccount().getBalance() + "Rs.");
			} else if (ae.getActionCommand().equals("Pay Bills")) {
				dispose();
				BillsFrame b = new BillsFrame(cl);
			} else if (ae.getActionCommand().equals("Use ATM")) {
				dispose();
				ATMFrame at = new ATMFrame(cl);
			} else if (ae.getActionCommand().equals("Sign Out")) {
				dispose();
				HomePage m = new HomePage();
			}
		}
	}
}
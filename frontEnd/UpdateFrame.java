import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UpdateFrame extends JFrame {
	JLabel l1, l2;
	JTextField t1, t2;
	JButton b1, b2, b3;

	UpdateFrame() {
		setSize(400, 400);
		setTitle("Update Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		l1 = new JLabel("Search By Name/AccNum");
		l1.setBounds(40, 60, 120, 40);
		t1 = new JTextField();
		t1.setBounds(180, 60, 140, 40);
		l2 = new JLabel("Enter New Pin");
		l2.setBounds(40, 120, 130, 40);
		t2 = new JTextField();
		t2.setBounds(180, 120, 140, 40);
		b1 = new JButton("Update");
		b1.setBounds(30, 210, 80, 100);
		b2 = new JButton("Clear");
		b2.setBounds(160, 210, 80, 100);
		b3 = new JButton("Return");
		b3.setBounds(290, 210, 80, 100);

		add(l1);
		add(t1);
		add(l2);
		add(t2);
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
			ValidationsClass v = new ValidationsClass();
			if (ae.getActionCommand().equals("Update")) {
				FileOperations fo = new FileOperations();
				if (t1.getText().equals("") || t2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Fill Both Boxes");
				} else if (v.checkNumber(t2.getText())) {
					JOptionPane.showMessageDialog(null, "PLEASE PROVIDE DIGITS FOR PIN");
					t2.setText("");
				} else {
					String str = t1.getText();
					int pin = Integer.parseInt(t2.getText());
					fo.updateClient(str, pin);
				}
			} else if (ae.getActionCommand().equals("Clear")) {
				t1.setText("");
				t2.setText("");
			} else if (ae.getActionCommand().equals("Return")) {
				dispose();
				AdminFrame a = new AdminFrame();
			}
		}
	}
}
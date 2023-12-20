import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManagerAccessFrame extends JFrame {
	JLabel l1, l2;
	JTextField t1, t2;
	JButton b1, b2, b3;

	ManagerAccessFrame() {
		setSize(500, 350);
		setTitle("Manager Access Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		l1 = new JLabel("Enter UserName");
		l1.setBounds(40, 60, 100, 40);
		t1 = new JTextField();
		t1.setBounds(140, 60, 140, 35);
		l2 = new JLabel("Enter Password");
		l2.setBounds(40, 120, 100, 40);
		t2 = new JTextField();
		t2.setBounds(140, 120, 140, 35);
		b1 = new JButton("Enter");
		b1.setBounds(30, 210, 100, 30);
		b2 = new JButton("Clear");
		b2.setBounds(160, 210, 100, 30);
		b3 = new JButton("Return");
		b3.setBounds(290, 210, 100, 30);

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
			if (ae.getActionCommand().equals("Enter")) {
				if (t1.getText().equals("") || t2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Fill both boxes");
				} else {
					String uName = t1.getText();
					String pass = t2.getText();
					FileOperations fo = new FileOperations();
					if (fo.getManagerAccess(uName, pass)) {
						dispose();
						ManagerFrame mf = new ManagerFrame();
					} else {
						JOptionPane.showMessageDialog(null, "Invalid UserName or Password");
					}
				}
			} else if (ae.getActionCommand().equals("Clear")) {
				t1.setText("");
				t2.setText("");
			} else if (ae.getActionCommand().equals("Return")) {
				dispose();
				HomePage m = new HomePage();
			}
		}
	}
}
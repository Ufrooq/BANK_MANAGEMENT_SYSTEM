import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DeleteFrame extends JFrame {
	JLabel l1;
	JTextField t1;
	JButton b1, b2, b3;

	DeleteFrame() {
		setSize(400, 400);
		setTitle("Delete Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		l1 = new JLabel("Enter Name/AccNum");
		l1.setBounds(40, 60, 120, 40);
		t1 = new JTextField();
		t1.setBounds(180, 60, 140, 40);
		b1 = new JButton("Delete");
		b1.setBounds(30, 210, 80, 100);
		b2 = new JButton("Clear");
		b2.setBounds(160, 210, 80, 100);
		b3 = new JButton("Return");
		b3.setBounds(290, 210, 80, 100);

		add(l1);
		add(t1);
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
			if (ae.getActionCommand().equals("Delete")) {
				FileOperations fo = new FileOperations();
				if (t1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Fill the Box");
				} else {
					String str = t1.getText();
					fo.deleteClient(str);
				}
			} else if (ae.getActionCommand().equals("Clear")) {
				t1.setText("");
			} else if (ae.getActionCommand().equals("Return")) {
				dispose();
				AdminFrame a = new AdminFrame();
			}
		}
	}
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManagerFrame extends JFrame {
	JButton b1, b2, b3, b4, b5, b6;

	ManagerFrame() {
		setSize(700, 600);
		setTitle("Manager Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(6, 1));

		b1 = new JButton("View All Admins");
		b2 = new JButton("Search an Admin");
		b3 = new JButton("Update an Admin");
		b4 = new JButton("Delete an Admin");
		b6 = new JButton("Create Admin Account");
		b5 = new JButton("Sign Out");

		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b6);
		add(b5);

		MyActionListener a = new MyActionListener();
		b1.addActionListener(a);
		b2.addActionListener(a);
		b3.addActionListener(a);
		b4.addActionListener(a);
		b5.addActionListener(a);
		b6.addActionListener(a);

		setVisible(true);
		setResizable(false);
	}

	public class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if (ae.getActionCommand().equals("View All Admins")) {
				FileOperations fo = new FileOperations();
				fo.readAdminFile();
			} else if (ae.getActionCommand().equals("Search an Admin")) {
				dispose();
				SearchAdminFrame s = new SearchAdminFrame();
			} else if (ae.getActionCommand().equals("Update an Admin")) {
				dispose();
				UpdateAdminFrame u = new UpdateAdminFrame();
			} else if (ae.getActionCommand().equals("Delete an Admin")) {
				dispose();
				DeleteAdminFrame d = new DeleteAdminFrame();

			} else if (ae.getActionCommand().equals("Create Admin Account")) {
				dispose();
				AdminCreationFrame ac = new AdminCreationFrame();

			} else if (ae.getActionCommand().equals("Sign Out")) {
				dispose();
				HomePage m = new HomePage();
			}
		}
	}
}
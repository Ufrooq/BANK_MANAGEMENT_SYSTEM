import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminFrame extends JFrame {
	JButton b1, b2, b3, b4, b5, b6;

	AdminFrame() {
		setSize(700, 600);
		setTitle("Admin Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(6, 1));

		b1 = new JButton("View All Clients");
		// b1.setBounds(100,150,200,200);
		b2 = new JButton("Search a Client");
		// b2.setBounds(380,150,200,200);
		b3 = new JButton("Update a Client");
		// b3.setBounds(600,500,80,50);
		b4 = new JButton("Delete a Client");
		b5 = new JButton("Sign Out");
		b6 = new JButton("CLIENTS WITH SAME PIN");

		add(b1);
		add(b2);
		add(b3);
		add(b4);
		add(b5);
		add(b6);

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
			if (ae.getActionCommand().equals("View All Clients")) {
				FileOperations fo = new FileOperations();
				fo.readClientFile();
			} else if (ae.getActionCommand().equals("Search a Client")) {
				dispose();
				SearchFrame s = new SearchFrame();
			} else if (ae.getActionCommand().equals("Update a Client")) {
				dispose();
				UpdateFrame u = new UpdateFrame();
			} else if (ae.getActionCommand().equals("Delete a Client")) {
				dispose();
				DeleteFrame u = new DeleteFrame();

			} else if (ae.getActionCommand().equals("CLIENTS WITH SAME PIN")) {
				dispose();
				CLIENTWITHSAMEPINFRAME a = new CLIENTWITHSAMEPINFRAME();

			} else if (ae.getActionCommand().equals("Sign Out")) {
				dispose();
				HomePage m = new HomePage();
			}
		}
	}
}
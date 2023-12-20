import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.EOFException;
import java.util.*;

public class NewFrame extends JFrame {
	JButton b1, b2, b3, b4, b5, b6;

	NewFrame() {
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(5, 1));

		b1 = new JButton("Add");
		b2 = new JButton("Search");
		b3 = new JButton("Update");
		b4 = new JButton("Display");
		b5 = new JButton("Exit");

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

	}

	public class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if (ae.getActionCommand().equals("Add")) {
				dispose();
				NewFrame a = new NewFrame();
			} else if (ae.getActionCommand().equals("Search")) {
				dispose();
				SearchFrame s = new SearchFrame();
			} else if (ae.getActionCommand().equals("Update")) {
				dispose();
				UpdateFrame u = new UpdateFrame();

			} else if (ae.getActionCommand().equals("Display")) {
				FileOperations fo = new FileOperations();
				fo.readAdminFile();
			} else if (ae.getActionCommand().equals("Exit")) {
				System.exit(1);
			}

		}
	}
}
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class AccountCreationFrame extends JFrame {
	MyLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14;
	JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12;
	JButton b1, b2, b3;
	MyLabel backgroundImage;
	ImageIcon image;

	Runner runner = new Runner();

	AccountCreationFrame() {
		setSize(600, 400);
		setTitle("Account Creation Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		try {
			image = new ImageIcon(
					"./File/leon-dewiwje-ldDmTgf89gU-unsplash.jpg",
					"Bird image");
		} catch (Exception e) {
			System.out.println("Ima not found !!");
		}

		l1 = new MyLabel("Name");
		l1.setBounds(20, 20, 60, 30);
		add(l1);
		t1 = new JTextField();
		t1.setBounds(120, 20, 140, 20);
		add(t1);
		l2 = new MyLabel("Age");
		l2.setBounds(20, 40, 60, 30);
		add(l2);
		t2 = new JTextField();
		t2.setBounds(120, 45, 140, 20);
		add(t2);
		l3 = new MyLabel("Gender");
		l3.setBounds(20, 65, 60, 30);
		add(l3);
		t3 = new JTextField();
		t3.setBounds(120, 70, 140, 20);
		add(t3);
		l4 = new MyLabel("Account No.");
		l4.setBounds(20, 90, 100, 30);
		add(l4);
		t4 = new JTextField();
		t4.setBounds(120, 95, 140, 20);
		add(t4);
		l5 = new MyLabel("Pin");
		l5.setBounds(20, 115, 60, 30);
		add(l5);
		t5 = new JTextField();
		t5.setBounds(120, 120, 140, 20);
		add(t5);
		l6 = new MyLabel("Balance");
		l6.setBounds(20, 140, 60, 30);
		add(l6);
		t6 = new JTextField();
		t6.setBounds(120, 145, 140, 20);
		add(t6);
		l7 = new MyLabel("DateOfBirth: ");
		l7.setBounds(20, 165, 100, 30);
		add(l7);
		l8 = new MyLabel("Day");
		l8.setBounds(130, 165, 50, 30);
		add(l8);
		t7 = new JTextField();
		t7.setBounds(180, 170, 40, 20);
		add(t7);
		l9 = new MyLabel("Month");
		l9.setBounds(240, 165, 50, 30);
		add(l9);
		t8 = new JTextField();
		t8.setBounds(290, 170, 40, 20);
		add(t8);
		l10 = new MyLabel("Year");
		l10.setBounds(350, 165, 50, 30);
		add(l10);
		t9 = new JTextField();
		t9.setBounds(400, 170, 40, 20);
		add(t9);
		l11 = new MyLabel("Address: ");
		l11.setBounds(20, 190, 100, 30);
		add(l11);
		l12 = new MyLabel("House");
		l12.setBounds(130, 190, 50, 30);
		add(l12);
		t10 = new JTextField();
		t10.setBounds(180, 195, 40, 20);
		add(t10);
		l13 = new MyLabel("Street");
		l13.setBounds(240, 190, 50, 30);
		add(l13);
		t11 = new JTextField();
		t11.setBounds(290, 195, 40, 20);
		add(t11);
		l14 = new MyLabel("City");
		l14.setBounds(350, 190, 50, 30);
		add(l14);
		t12 = new JTextField();
		t12.setBounds(400, 195, 70, 20);
		add(t12);

		b1 = new JButton("Create");
		b1.setBounds(20, 250, 140, 50);
		add(b1);
		b2 = new JButton("Clear");
		b2.setBounds(200, 250, 140, 50);
		add(b2);
		b3 = new JButton("Return");
		b3.setBounds(380, 250, 140, 50);
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
			FileOperations fo = new FileOperations();
			if (ae.getActionCommand().equals("Create")) {
				if (t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("")
						|| t4.getText().equals("") ||
						t5.getText().equals("") || t6.getText().equals("") || t7.getText().equals("")
						|| t8.getText().equals("") ||
						t9.getText().equals("") || t10.getText().equals("") || t11.getText().equals("")
						|| t12.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Fill All the Text Fields");
				} else if (v.checkString(t1.getText()) || v.checkAge(t2.getText()) || v.checkGender(t3.getText()) ||
						v.checkNumber(t4.getText()) || v.checkNumber(t5.getText()) || v.checkNumber(t6.getText()) ||
						v.checkDay(t7.getText()) || v.checkMonth(t8.getText()) || v.checkYear(t9.getText()) ||
						v.checkNumber(t10.getText()) || v.checkNumber(t11.getText()) || v.checkString(t12.getText())) {
					JOptionPane.showMessageDialog(null, "ERROR IN INPUT");
				} else if (fo.ifAccountExist(t4.getText())) {
					JOptionPane.showMessageDialog(null, "This Account No Already Exixts");
					t4.setText("");
				} else {
					String name = t1.getText();
					int age = Integer.parseInt(t2.getText());
					String gender = t3.getText();
					String accNum = t4.getText();
					int pin = Integer.parseInt(t5.getText());
					Double balance = Double.parseDouble(t6.getText());
					int day = Integer.parseInt(t7.getText());
					int month = Integer.parseInt(t8.getText());
					int year = Integer.parseInt(t9.getText());
					int home = Integer.parseInt(t10.getText());
					int street = Integer.parseInt(t11.getText());
					String city = t12.getText();
					runner.inserting_into_db(gender, accNum, city);

					Date d = new Date();
					Account acc = new Account(accNum, pin, balance, d);
					Address ads = new Address(home, street, city);
					Client c = new Client(name, age, gender, ads, acc, day, month, year);
					JOptionPane.showMessageDialog(null, c.toString());
					fo.addClient(c);
					t1.setText("");
					t2.setText("");
					t3.setText("");
					t4.setText("");
					t5.setText("");
					t6.setText("");
					t7.setText("");
					t8.setText("");
					t9.setText("");
					t10.setText("");
					t11.setText("");
					t12.setText("");
				}
			} else if (ae.getActionCommand().equals("Clear")) {
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				t8.setText("");
				t9.setText("");
				t10.setText("");
				t11.setText("");
				t12.setText("");
			} else if (ae.getActionCommand().equals("Return")) {
				dispose();
				ClientIntermediateFrame c = new ClientIntermediateFrame();
			}
		}

	}

}

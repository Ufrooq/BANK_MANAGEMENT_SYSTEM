import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class AdminCreationFrame extends JFrame {
	JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
	JButton b1, b2, b3;

	Runner runner = new Runner();

	AdminCreationFrame() {
		setSize(600, 400);
		setTitle("Admin Creation Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		l1 = new JLabel("Name");
		l1.setBounds(20, 20, 60, 30);
		add(l1);
		t1 = new JTextField();
		t1.setBounds(120, 20, 140, 20);
		add(t1);
		l2 = new JLabel("Age");
		l2.setBounds(20, 50, 60, 30);
		add(l2);
		t2 = new JTextField();
		t2.setBounds(120, 55, 80, 20);
		add(t2);
		l3 = new JLabel("Gender");
		l3.setBounds(20, 80, 60, 30);
		add(l3);
		t3 = new JTextField();
		t3.setBounds(120, 85, 80, 20);
		add(t3);
		l4 = new JLabel("UserName");
		l4.setBounds(20, 110, 100, 30);
		add(l4);
		t4 = new JTextField();
		t4.setBounds(120, 115, 80, 20);
		add(t4);
		l5 = new JLabel("PinCode");
		l5.setBounds(20, 140, 60, 30);
		add(l5);
		t5 = new JTextField();
		t5.setBounds(120, 145, 80, 20);
		add(t5);

		l6 = new MyLabel("DateOfBirth: ");
		l6.setBounds(20, 165, 100, 30);
		add(l6);
		l7 = new MyLabel("Day");
		l7.setBounds(130, 165, 50, 30);
		add(l7);
		t6 = new JTextField();
		t6.setBounds(180, 170, 40, 20);
		add(t6);
		l8 = new MyLabel("Month");
		l8.setBounds(240, 165, 50, 30);
		add(l8);
		t7 = new JTextField();
		t7.setBounds(290, 170, 40, 20);
		add(t7);
		l9 = new MyLabel("Year");
		l9.setBounds(350, 165, 50, 30);
		add(l9);
		t8 = new JTextField();
		t8.setBounds(400, 170, 40, 20);
		add(t8);
		l10 = new MyLabel("Admin ID");
		l10.setBounds(230, 60, 80, 20);
		add(l10);
		t9 = new JTextField();
		t9.setBounds(300, 60, 140, 20);
		add(t9);

		b1 = new JButton("Create");
		b1.setBounds(20, 250, 140, 100);
		add(b1);
		b2 = new JButton("Clear");
		b2.setBounds(200, 250, 140, 100);
		add(b2);
		b3 = new JButton("Return");
		b3.setBounds(380, 250, 140, 100);
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
			FileOperations fo = new FileOperations();
			if (ae.getActionCommand().equals("Create")) {
				ValidationsClass v = new ValidationsClass();
				if (t1.getText().equals("") || t2.getText().equals("") || t3.getText().equals("")
						|| t4.getText().equals("") ||
						t5.getText().equals("") || t6.getText().equals("") ||
						t7.getText().equals("") || t8.getText().equals("")
						|| t9.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Fill All the Text Fields");
				} else if (v.checkString(t1.getText()) || v.checkAge(t2.getText()) ||
						v.checkGender(t3.getText())
						|| v.checkNumber(t5.getText()) ||
						v.checkDay(t6.getText()) || v.checkMonth(t7.getText()) ||
						v.checkYear(t8.getText())) {
					JOptionPane.showMessageDialog(null, "ERROR IN INPUT");

				} else if (fo.ifAdminExist(t4.getText())) {
					JOptionPane.showMessageDialog(null, "This Admin Account No Already Exixts");
					t4.setText("");
				} else if (fo.getAdminId(Integer.parseInt(t9.getText())) == true) {
					JOptionPane.showMessageDialog(null, "THE ADMIN ALREADY EXIST");
					t9.setText("");
				}

				else {
					String name = t1.getText();
					int age = Integer.parseInt(t2.getText());
					String gender = t3.getText();
					String uName = t4.getText();
					int pin = Integer.parseInt(t5.getText());
					int day = Integer.parseInt(t6.getText());
					int month = Integer.parseInt(t7.getText());
					int year = Integer.parseInt(t8.getText());
					int admin_id = Integer.parseInt(t9.getText());
					String dob = year + " - " + month + " - " + day;
					Admin ad = new Admin(name, age, gender, uName, pin, day, month, year, admin_id);
					JOptionPane.showMessageDialog(null, ad.toString());
					String jsonData = convertDataToJson(name, age, gender, pin, dob);
					runner.inserting_into_db("POST", jsonData, "customer/accountCreation");

				}
			}

			else if (ae.getActionCommand().equals("Clear")) {
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
			} else if (ae.getActionCommand().equals("Return")) {
				dispose();
				ManagerFrame ma = new ManagerFrame();
			}
		}
	}

	public String convertDataToJson(
			String name, int age, String gender,
			int pin, String dob) {

		String jsonInputString = """
				{
				"name": "%s",
				"age": %d,
				"gender": "%s",
				"pin": %d,
				"dob": "%s",
				}
				""";

		String jsonData = String.format(jsonInputString, name, age, gender, pin, dob);

		return jsonData;
	}
}

// import javax.swing.*;

// import java.awt.*;
// import java.awt.event.*;

// public class AdminCreationFrame extends JFrame {
// JTextField t1, t2, t3, t4, t5, t6, t7, t8;
// JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;
// JButton b1, b2, b3;

// Runner runner = new Runner();

// AdminCreationFrame() {
// setSize(600, 400);
// setTitle("Admin Creation Frame");
// setDefaultCloseOperation(EXIT_ON_CLOSE);
// setLayout(null);

// l1 = new JLabel("Name");
// l1.setBounds(20, 20, 60, 30);
// add(l1);
// t1 = new JTextField();
// t1.setBounds(120, 20, 140, 20);
// add(t1);
// l2 = new JLabel("Age");
// l2.setBounds(20, 50, 60, 30);
// add(l2);
// t2 = new JTextField();
// t2.setBounds(120, 55, 80, 20);
// add(t2);
// l3 = new JLabel("Gender");
// l3.setBounds(20, 80, 60, 30);
// add(l3);
// t3 = new JTextField();
// t3.setBounds(120, 85, 80, 20);
// add(t3);
// l4 = new JLabel("UserName");
// l4.setBounds(20, 110, 100, 30);
// add(l4);
// t4 = new JTextField();
// t4.setBounds(120, 115, 80, 20);
// add(t4);
// l5 = new JLabel("PinCode");
// l5.setBounds(20, 140, 60, 30);
// add(l5);
// t5 = new JTextField();
// t5.setBounds(120, 145, 80, 20);
// add(t5);

// l6 = new MyLabel("DateOfBirth: ");
// l6.setBounds(20, 165, 100, 30);
// add(l6);
// l7 = new MyLabel("Day");
// l7.setBounds(130, 165, 50, 30);
// add(l7);
// t6 = new JTextField();
// t6.setBounds(180, 170, 40, 20);
// add(t6);
// l8 = new MyLabel("Month");
// l8.setBounds(240, 165, 50, 30);
// add(l8);
// t7 = new JTextField();
// t7.setBounds(290, 170, 40, 20);
// add(t7);
// l9 = new MyLabel("Year");
// l9.setBounds(350, 165, 50, 30);
// add(l9);
// t8 = new JTextField();
// t8.setBounds(400, 170, 40, 20);
// add(t8);

// b1 = new JButton("Create");
// b1.setBounds(20, 250, 140, 100);
// add(b1);
// b2 = new JButton("Clear");
// b2.setBounds(200, 250, 140, 100);
// add(b2);
// b3 = new JButton("Return");
// b3.setBounds(380, 250, 140, 100);
// add(b3);

// MyActionListener a = new MyActionListener();
// b1.addActionListener(a);
// b2.addActionListener(a);
// b3.addActionListener(a);

// setVisible(true);
// setResizable(false);
// }

// public class MyActionListener implements ActionListener {
// public void actionPerformed(ActionEvent ae) {
// FileOperations fo = new FileOperations();
// if (ae.getActionCommand().equals("Create")) {
// ValidationsClass v = new ValidationsClass();
// if (t1.getText().equals("") || t2.getText().equals("") ||
// t3.getText().equals("")
// || t4.getText().equals("") ||
// t5.getText().equals("") || t6.getText().equals("") ||
// t7.getText().equals("") || t8.getText().equals("")) {
// JOptionPane.showMessageDialog(null, "Fill All the Text Fields");
// } else if (v.checkString(t1.getText()) || v.checkAge(t2.getText()) ||
// v.checkGender(t3.getText())
// || v.checkNumber(t5.getText()) ||
// v.checkDay(t6.getText()) || v.checkMonth(t7.getText()) ||
// v.checkYear(t8.getText())) {
// JOptionPane.showMessageDialog(null, "ERROR IN INPUT");

// } else if (fo.ifAdminExist(t4.getText())) {
// JOptionPane.showMessageDialog(null, "This Admin Account No Already Exixts");
// t4.setText("");
// } else {
// String name = t1.getText();
// int age = Integer.parseInt(t2.getText());
// String gender = t3.getText();
// String uName = t4.getText();
// int pin = Integer.parseInt(t5.getText());
// int day = Integer.parseInt(t6.getText());
// int month = Integer.parseInt(t7.getText());
// int year = Integer.parseInt(t8.getText());
// String dob = year + " - " + month + " - " + day;
// String jsonData = convertDataToJson(name, age, gender, pin, dob);
// runner.inserting_into_db("POST", jsonData, "customer/accountCreation");
// Admin ad = new Admin(name, age, gender, uName, pin, day, month, year);
// JOptionPane.showMessageDialog(null, ad.toString());
// fo.addAdmin(ad);
// }
// }

// else if (ae.getActionCommand().equals("Clear")) {
// t1.setText("");
// t2.setText("");
// t3.setText("");
// t4.setText("");
// t5.setText("");
// } else if (ae.getActionCommand().equals("Return")) {
// dispose();
// ManagerFrame ma = new ManagerFrame();
// }
// }

// public String convertDataToJson(
// String name, int age, String gender,
// int pin, String dob) {

// String jsonInputString = """
// {
// "name": "%s",
// "age": %d,
// "gender": "%s",
// "pin": %d,
// "dob": "%s",
// }
// """;

// String jsonData = String.format(jsonInputString, name, age, gender, pin,
// dob);

// return jsonData;
// }
// }
// }
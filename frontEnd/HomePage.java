import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class HomePage extends JFrame {
	Button b1, b2, b3, b4;
	ImageIcon image;
	JLabel backgroundImage, welcome;

	HomePage() {

		setSize(800, 600);
		setTitle("PUBLIC BANK");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		try {
			image = new ImageIcon(
					"./File/photo-1616803140344-6682afb13cda.jpg",
					"Bird image");
		} catch (Exception e) {
			System.out.println("Ima not found !!");
		}

		Font myfont = new Font(Font.SANS_SERIF, Font.ITALIC, 30);
		welcome = new JLabel("MEEZAN BANK");
		welcome.setForeground(Color.WHITE);
		welcome.setBounds(460, 380, 600, 100);
		welcome.setFont(myfont);
		b1 = new Button("Manager");
		b1.setBounds(30, 120, 230, 70);
		b2 = new Button("Admin");
		b2.setBounds(30, 220, 230, 70);
		b3 = new Button("Client");
		b3.setBounds(30, 320, 230, 70);
		b4 = new Button("Exit");
		b4.setBounds(30, 430, 230, 60);

		backgroundImage = new JLabel(image);
		backgroundImage.setBounds(0, -20, this.getWidth(), this.getHeight());
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);

		this.add(welcome);
		this.add(backgroundImage);

		MyActionListener a = new MyActionListener();
		b1.addActionListener(a);
		b2.addActionListener(a);
		b3.addActionListener(a);
		b4.addActionListener(a);

		setResizable(false);
		setVisible(true);
	}

	public class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if (ae.getActionCommand().equals("Manager")) {
				dispose();
				ManagerAccessFrame ma = new ManagerAccessFrame();
			} else if (ae.getActionCommand().equals("Admin")) {
				dispose();
				AdminIntermediateFrame aa = new AdminIntermediateFrame();
			} else if (ae.getActionCommand().equals("Client")) {
				dispose();
				ClientIntermediateFrame ci = new ClientIntermediateFrame();
			} else if (ae.getActionCommand().equals("Exit")) {
				System.exit(1);
			}
		}
	}
}
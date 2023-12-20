import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClientIntermediateFrame extends JFrame {
	Button b1, b2, b3;
	ImageIcon image;
	JLabel background;

	ClientIntermediateFrame() {
		setSize(700, 600);
		setTitle("Client Intermediate Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		try {
			image = new ImageIcon("./File/clientback.jpeg", "uydyuyf");
		} catch (Exception e) {
			System.out.println("image not found");
		}

		b1 = new Button("Create Account");
		b1.setBounds(40, 150, 240, 60);
		// b1.setFont(getFont());
		b2 = new Button("Sign In");
		b2.setBounds(40, 250, 240, 60);
		b3 = new Button("Return");
		b3.setBounds(40, 350, 240, 60);

		background = new JLabel(image);
		background.setBounds(0, 0, this.getWidth(), this.getHeight());
		add(b1);
		add(b2);
		add(b3);
		this.add(background);

		MyActionListener a = new MyActionListener();
		b1.addActionListener(a);
		b2.addActionListener(a);
		b3.addActionListener(a);

		setVisible(true);
		setResizable(false);
	}

	public class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			if (ae.getActionCommand().equals("Create Account")) {
				dispose();
				AccountCreationFrame ac = new AccountCreationFrame();
			} else if (ae.getActionCommand().equals("Sign In")) {
				dispose();
				SignInFrame ca = new SignInFrame();
			} else if (ae.getActionCommand().equals("Return")) {
				dispose();
				HomePage m = new HomePage();
			}
		}
	}

}
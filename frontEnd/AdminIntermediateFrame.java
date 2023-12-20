import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminIntermediateFrame extends JFrame {
	Button b1, b2, b3;
	ImageIcon image;
	JLabel background;

	AdminIntermediateFrame() {
		setSize(700, 600);
		setTitle("Admin Intermediate Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		try {
			image = new ImageIcon("./File/clientback.jpeg", "uydyuyf");
		} catch (Exception e) {
			System.out.println("image not found");
		}

		b2 = new Button("Sign In");
		b2.setBounds(110, 350, 240, 60);
		b3 = new Button("Return");
		b3.setBounds(110, 440, 240, 60);

		background = new JLabel(image);
		background.setBounds(0, 0, this.getWidth(), this.getHeight());

		add(b2);
		add(b3);
		this.add(background);

		MyActionListener a = new MyActionListener();
		b2.addActionListener(a);
		b3.addActionListener(a);

		setVisible(true);
		setResizable(false);
	}

	public class MyActionListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {

			if (ae.getActionCommand().equals("Sign In")) {
				dispose();
				AdminAccessFrame ca = new AdminAccessFrame();
			} else if (ae.getActionCommand().equals("Return")) {
				dispose();
				HomePage m = new HomePage();
			}
		}
	}

}
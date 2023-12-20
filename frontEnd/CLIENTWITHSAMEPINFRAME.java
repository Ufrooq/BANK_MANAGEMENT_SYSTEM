
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CLIENTWITHSAMEPINFRAME extends JFrame {
    JLabel l1;
    JTextField t1;
    JButton b1, b2;

    CLIENTWITHSAMEPINFRAME() {
        setSize(400, 400);
        setTitle("CLIENT WITH SAME PIN");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        l1 = new JLabel("Pin");
        l1.setBounds(40, 60, 100, 40);
        t1 = new JTextField();
        t1.setBounds(140, 60, 140, 40);

        b1 = new JButton("Enter");
        b1.setBounds(30, 210, 80, 100);
        b2 = new JButton("Return");
        b2.setBounds(290, 210, 80, 100);

        add(l1);
        add(t1);
        add(b1);
        add(b2);

        MyActionListener a = new MyActionListener();
        b1.addActionListener(a);
        b2.addActionListener(a);

        setVisible(true);
        setResizable(false);
    }

    public class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent ae) {
            ValidationsClass v = new ValidationsClass();
            FileOperations fo = new FileOperations();
            if (ae.getActionCommand().equals("Enter")) {
                if (t1.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill both boxes");
                } else if (v.checkNumber(t1.getText())) {
                    JOptionPane.showMessageDialog(null, "ENTER DIGITS");
                } else {
                    int p = Integer.parseInt(t1.getText());
                    fo.display_same_pin(p);
                    dispose();
                    AdminFrame frAdmin = new AdminFrame();

                }
            } else if (ae.getActionCommand().equals("Return")) {
                dispose();
                AdminFrame frAdmin = new AdminFrame();
            }
        }
    }
}

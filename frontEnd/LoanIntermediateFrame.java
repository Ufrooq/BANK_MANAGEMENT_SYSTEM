import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoanIntermediateFrame extends JFrame {

    JLabel l1, l2;
    JTextField t1, t2;
    Button b1, b2, b3;

    LoanIntermediateFrame() {
        setSize(500, 400);
        setTitle("Loan Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        l1 = new JLabel("Enter Account No.");
        l1.setBounds(40, 60, 120, 40);
        t1 = new JTextField();
        t1.setBounds(160, 60, 140, 40);
        l2 = new JLabel("Enter Pin");
        l2.setBounds(40, 120, 100, 40);
        t2 = new JTextField();
        t2.setBounds(160, 150, 140, 40);
        Font myfont = new Font(Font.DIALOG, Font.BOLD, 20);
        b1 = new Button("Enter");
        b1.setFont(myfont);
        b1.setBounds(30, 250, 100, 50);
        b2 = new Button("Clear");
        b2.setFont(myfont);
        b2.setBounds(160, 250, 100, 50);
        b3 = new Button("Return");
        b3.setFont(myfont);
        b3.setBounds(290, 250, 100, 50);

        add(l1);
        add(t1);
        add(l2);
        add(t2);
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
            ValidationsClass v = new ValidationsClass();
            if (ae.getActionCommand().equals("Enter")) {
                if (t1.getText().equals("") || t2.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill both boxes");
                } else if (v.checkNumber(t1.getText()) || v.checkNumber(t2.getText())) {
                    JOptionPane.showMessageDialog(null, "ERROR IN INPUT");
                } else {
                    String accNum = t1.getText();
                    int pin = Integer.parseInt(t2.getText());
                    FileOperations fo = new FileOperations();
                    if (fo.getClientAccess(accNum, pin)) {
                        dispose();
                        Client c = fo.getClient(accNum, pin);
                        LOANFRAME cf = new LOANFRAME(c);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Account no or Password");
                    }
                }
            } else if (ae.getActionCommand().equals("Clear")) {
                t1.setText("");
                t2.setText("");
            } else if (ae.getActionCommand().equals("Return")) {
                dispose();
                HomePage g = new HomePage();
            }
        }
    }

}

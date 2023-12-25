import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LOANFRAME extends JFrame {
    Client c;
    JLabel l1, l2, l3, l4, l5;
    JTextField t1, t2, t3, t4, t5;
    Button b1, b2, b3;

    Runner runner = new Runner();

    LOANFRAME(Client c1) {
        c = c1;
        setSize(500, 500);
        setTitle("Loan Frame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        l1 = new JLabel("Account No.");
        l1.setBounds(40, 60, 120, 40);
        t1 = new JTextField();
        t1.setBounds(160, 60, 140, 40);
        t1.setText(c1.getAccount().getAccountNum());

        l2 = new JLabel("Loan Amount");
        l2.setBounds(40, 120, 120, 40);
        t2 = new JTextField();
        t2.setBounds(160, 120, 140, 40);

        l3 = new JLabel("Loan Date");
        l3.setBounds(40, 180, 120, 40);
        t3 = new JTextField();
        t3.setBounds(160, 180, 140, 40);

        l4 = new JLabel("Return Date");
        l4.setBounds(40, 240, 120, 40);
        t4 = new JTextField();
        t4.setBounds(160, 240, 140, 40);

        l5 = new JLabel("Per Month Return");
        l5.setBounds(40, 300, 120, 40);
        t5 = new JTextField();
        t5.setBounds(160, 300, 140, 40);

        Font myfont = new Font(Font.DIALOG, Font.BOLD, 20);
        b1 = new Button("Enter");
        b1.setFont(myfont);
        b1.setBounds(30, 370, 100, 50);
        b2 = new Button("Clear");
        b2.setFont(myfont);
        b2.setBounds(160, 370, 100, 50);
        b3 = new Button("Return");
        b3.setFont(myfont);
        b3.setBounds(290, 370, 100, 50);

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(l5);
        add(t5);

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
                if (t2.getText().equals("") || t3.getText().equals("") || t4.getText().equals("")
                        || t5.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Fill both boxes");
                } else if (v.checkNumber(t1.getText()) || v.checkNumber(t2.getText())) {
                    JOptionPane.showMessageDialog(null, "ERROR IN INPUT");
                } else {
                    String accNum = t1.getText();
                    int loanAmount = Integer.parseInt(t2.getText());
                    String loanDate = t3.getText();
                    String returnDate = t4.getText();
                    String permonthReturn = t5.getText();

                    String jsonData = convertDataToJson(accNum, loanAmount, loanDate,
                            returnDate, permonthReturn);
                    runner.inserting_into_db("POST", jsonData, "customer/loan");

                    // FileOperations fo = new FileOperations();
                    // if (fo.getClientAccess(accNum, pin)) {
                    // dispose();
                    // Client c = fo.getClient(accNum, pin);
                    // ClientFrame cf = new ClientFrame(c);
                    // } else {
                    // JOptionPane.showMessageDialog(null, "Invalid Account no or Password");
                    // }
                }
            } else if (ae.getActionCommand().equals("Clear")) {
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
            } else if (ae.getActionCommand().equals("Return")) {
                dispose();
                HomePage m = new HomePage();
            }
        }
    }

    public String convertDataToJson(String accNum, int loanAmount, String loanDate,
            String returnDate, String permonthReturn) {

        String jsonInputString = """
                {
                "accNum" : "%s",
                "loanAmount": %d,
                "loanDate": "%s",
                "returnDate": "%s",
                "permonthReturn" : "%s"
                }
                """;

        String jsonData = String.format(
                jsonInputString,
                accNum, loanAmount, loanDate,
                returnDate, permonthReturn);

        return jsonData;
    }

}

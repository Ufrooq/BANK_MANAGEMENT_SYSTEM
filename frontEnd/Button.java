import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

public class Button extends JButton {
    Button(String text) {
        Font myfont = new Font(Font.DIALOG, Font.PLAIN, 25);
        this.setText(text);
        this.setFont(myfont);
        this.setFocusable(false);
        this.setBackground(Color.black);
        this.setForeground(Color.white);
    }
}

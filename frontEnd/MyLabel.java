import java.awt.Font;

import javax.swing.JLabel;

public class MyLabel extends JLabel {
    MyLabel(String text) {
        Font myfont = new Font(Font.SERIF, Font.BOLD, 17);
        this.setText(text);
        this.setFont(myfont);
    }
}

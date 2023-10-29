package dashboard;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom() {
        setUI(new ScrollBarWin11UI());
        setPreferredSize(new Dimension(15, 15));
        //setForeground(new Color(48, 144, 216));
        setBackground(Color.WHITE);
    }
}
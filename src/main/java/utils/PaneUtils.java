package main.java.utils;

import javax.swing.*;
import java.awt.*;

public class PaneUtils {
    public JLabel gridLabel(String text) {
        JLabel label = new JLabel(text, 0);
        label.setBorder(BorderFactory.createRaisedBevelBorder());
        return label;
    }

    public JLabel gridLabel(String text, Boolean bold) {
        JLabel label = new JLabel(text, 0);
        label.setBorder(BorderFactory.createRaisedBevelBorder());
        if (bold){
            Font font = label.getFont();
            //label.setFont(font.deriveFont(font.getStyle() | Font.BOLD));
        }
        return label;
    }
}

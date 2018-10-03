package main.java.utils;

import javax.swing.*;

public class PaneUtils {
    public JLabel gridLabel(String text) {
        JLabel label = new JLabel(text, 0);
        label.setBorder(BorderFactory.createRaisedBevelBorder());
        return label;
    }
}

package ss12;

import javax.swing.*;
import java.awt.*;

public class FrameTwo extends JFrame {
    public FrameTwo(String received) {
        setTitle("Frame Two");
        setSize(300,200);
        setLayout(new FlowLayout());
        JLabel lbl = new JLabel("Received: " + received);
        add(lbl);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
package ss12;

import javax.swing.*;
import java.awt.*;

public class FrameOne extends JFrame {
    public FrameOne() {
        setTitle("Frame One");
        setSize(300,200);
        setLayout(new FlowLayout());

        JTextField field = new JTextField("Hello from Frame One", 20);
        add(field);

        JButton btn = new JButton("Send to Frame Two");
        add(btn);
        btn.addActionListener(e -> {
            String input = field.getText();
            FrameTwo f2 = new FrameTwo(input);
            f2.setVisible(true);
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}

package ss12;

import javax.swing.*;
import java.awt.*;

public class BasicDrawingFrame extends JFrame {
    public BasicDrawingFrame() {
        setTitle("Basic Drawing");
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.drawLine(50,50,150,50);
        g.setColor(Color.BLUE);
        g.drawRect(50,70,100,50);
        g.fillRect(200,70,100,50);
        g.setColor(Color.GREEN);
        g.drawOval(50,150,100,50);
        g.fillOval(200,150,100,50);
        g.setColor(Color.BLACK);
        g.drawString("Basic Shapes", 150,250);
    }
}
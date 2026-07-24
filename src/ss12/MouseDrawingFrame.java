package ss12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MouseDrawingFrame extends JFrame {
    private DrawPanel drawPanel;
    private Color currentColor = Color.RED;
    private int currentWidth = 10;

    public MouseDrawingFrame() {
        setTitle("Mouse Drawing");
        setSize(600, 400);
        setLayout(new BorderLayout());

        // لوحة الرسم
        drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);

        // لوحة التحكّم
        JPanel controls = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        gbc.gridx = 0; gbc.gridy = 0;
        Color[] colors = { Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN, Color.BLACK, Color.WHITE };
       for (Color c : colors) {
    JButton btn = new JButton();
    btn.setBackground(c);
    btn.setPreferredSize(new Dimension(30,30));
    btn.setOpaque(true);
    btn.setBorderPainted(false);

    btn.addActionListener(e -> currentColor = c);
    controls.add(btn, gbc);
    gbc.gridx++;
}

        gbc.gridx = 0; gbc.gridy++;
        controls.add(new JLabel("Width:"), gbc);
        gbc.gridx++;
        SpinnerNumberModel mdl = new SpinnerNumberModel(currentWidth, 1, 50, 1);
        JSpinner spinner = new JSpinner(mdl);
        spinner.addChangeListener(e -> currentWidth = (Integer) spinner.getValue());
        controls.add(spinner, gbc);

        gbc.gridx = 0; gbc.gridy++;
        JButton clearBtn = new JButton("Clear");
        clearBtn.addActionListener(e -> drawPanel.clear());
        controls.add(clearBtn, gbc);

        add(controls, BorderLayout.EAST);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    class DrawPanel extends JPanel implements MouseListener, MouseMotionListener {
        private List<Line> lines = new ArrayList<>();
        private Line currentLine;

        public DrawPanel() {
            setBackground(Color.WHITE);
            addMouseListener(this);
            addMouseMotionListener(this);
        }

        public void clear() {
            lines.clear();
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            for (Line ln : lines) {
                g2.setStroke(new BasicStroke(ln.width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g2.setColor(ln.color);
                List<Point> pts = ln.points;
                for (int i = 1; i < pts.size(); i++) {
                    Point p1 = pts.get(i-1), p2 = pts.get(i);
                    g2.drawLine(p1.x,p1.y,p2.x,p2.y);
                }
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            currentLine = new Line(currentColor, currentWidth);
            currentLine.points.add(e.getPoint());
            lines.add(currentLine);
        }
        @Override
        public void mouseDragged(MouseEvent e) {
            currentLine.points.add(e.getPoint());
            repaint();
        }

        public void mouseReleased(MouseEvent e) {}
        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mouseMoved(MouseEvent e) {}
    }

    class Line {
        List<Point> points = new ArrayList<>();
        Color color;
        int width;
        Line(Color c, int w) { color = c; width = w; }
    }
}

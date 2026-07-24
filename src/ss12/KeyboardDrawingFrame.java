package ss12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class KeyboardDrawingFrame extends JFrame {
    public KeyboardDrawingFrame() {
        setTitle("Keyboard Drawing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // لوحة الرسم المركزية
        DrawPanel drawPanel = new DrawPanel();
        add(drawPanel, BorderLayout.CENTER);

        // شريط تعليمات في الأسفل
        JLabel instructions = new JLabel("Use ← ↑ → ↓ to move the circle. Press C to change color.");
        instructions.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        add(instructions, BorderLayout.SOUTH);

        setSize(500, 400);
        setLocationRelativeTo(null); // توسيط النافذة على الشاشة
        setVisible(true);

        // ضمان تركيز لوحة الرسم كي تستقبل مفاتيح الكيبورد
        SwingUtilities.invokeLater(drawPanel::requestFocusInWindow);
    }

    public static void main(String[] args) {
        // تشغيل الواجهة على الـ EDT
        SwingUtilities.invokeLater(KeyboardDrawingFrame::new);
    }
}

class DrawPanel extends JPanel {
    private int x = 100, y = 100, diameter = 50;
    private Color color = Color.MAGENTA;
    private final int STEP = 10;

    public DrawPanel() {
        setBackground(Color.WHITE);
        setFocusable(true);

        // Key Bindings: تحريك ودوران اللون
        setupKeyBinding("LEFT",  0,  STEP,  0,   () -> x = Math.max(0, x - STEP));
        setupKeyBinding("RIGHT", 0,  STEP,  0,   () -> x = Math.min(getWidth() - diameter, x + STEP));
        setupKeyBinding("UP",    0,  STEP,  0,   () -> y = Math.max(0, y - STEP));
        setupKeyBinding("DOWN",  0,  STEP,  0,   () -> y = Math.min(getHeight() - diameter, y + STEP));
        setupKeyBinding("C",     0,  STEP,  0,   this::randomizeColor);
    }

    private void setupKeyBinding(String key, int... dummy) {
        setupKeyBinding(key, 0,0,0, () -> {});
    }

    private void setupKeyBinding(String key, int dummy1, int dummy2, int dummy3, Runnable action) {
        InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        im.put(KeyStroke.getKeyStroke(key), key);
        am.put(key, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                action.run();
                repaint();
            }
        });
    }

    private void randomizeColor() {
        color = new Color(
            (float)Math.random(),
            (float)Math.random(),
            (float)Math.random()
        );
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);
    }
}

package ss12;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}

class MainFrame extends JFrame {
    private final String[] options = {
        "Basic Drawing",
        "Keyboard Drawing",
        "Mouse Drawing",
        "Data Transfer"
    };

    private final String[] descriptions = {
        // وصف لكل خيار
        "• Basic Drawing:\n  يتيح الرسم الحرّ باستخدام واجهة Graphics الأساسية.\n  يمكنك الضغط والسحب لتشكيل أشكال بسيطة.",
        "• Keyboard Drawing:\n  يستقبل أحداث لوحة المفاتيح (مفاتيح الأسهم، الحروف).\n  عند الضغط على مفتاح معيّن، يُرسم شكل أو ينتقل المؤشر.",
        "• Mouse Drawing:\n  يتيح الرسم بالماوس: اضغط واستمر في السحب لتخطيط مسار حرّ.",
        "• Data Transfer:\n  يوضح طريقة نقل البيانات بين نوافذ أو مكونات مختلفة.\n  مثال على إرسال واستقبال كائنات بين Frames."
    };

    private JList<String> list;
    private JTextArea descriptionArea;
    private JButton openButton;

    public MainFrame() {
        setTitle("Graphics App – مثال رسم");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        initComponents();
    }

    private void initComponents() {
        // قائمة الخيارات
        list = new JList<>(options);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);

        // منطقة الوصف
        descriptionArea = new JTextArea();
        descriptionArea.setEditable(false);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setText(descriptions[0]);

        // زر الفتح
        openButton = new JButton("Open Example");
        openButton.addActionListener(e -> openSelectedExample());

        // عند تغيير الاختيار، حدّث النص في منطقة الوصف
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int idx = list.getSelectedIndex();
                if (idx >= 0) {
                    descriptionArea.setText(descriptions[idx]);
                }
            }
        });

        // تقسيم المساحة بين القائمة والوصف
        JSplitPane split = new JSplitPane(
            JSplitPane.HORIZONTAL_SPLIT,
            new JScrollPane(list),
            new JScrollPane(descriptionArea)
        );
        split.setDividerLocation(150);

        // تجميع المكونات في الإطار
        getContentPane().setLayout(new BorderLayout(5, 5));
        getContentPane().add(split, BorderLayout.CENTER);
        getContentPane().add(openButton, BorderLayout.SOUTH);
    }

    private void openSelectedExample() {
        int choice = list.getSelectedIndex();
        switch (choice) {
            case 0 -> new BasicDrawingFrame();
            case 1 -> new KeyboardDrawingFrame();
            case 2 -> new MouseDrawingFrame();
            case 3 -> new FrameOne();
            default -> System.exit(0);
        }
    }
}

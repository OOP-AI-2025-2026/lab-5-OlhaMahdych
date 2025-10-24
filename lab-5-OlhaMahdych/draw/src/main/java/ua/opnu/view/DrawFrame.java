package ua.opnu.view;

import ua.opnu.model.DrawShape;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * Головне вікно програми. Фрейм (клас JFrame) є контейнером верхнього рівня
 */
public class DrawFrame extends JFrame {

    // Область для малювання фігур
    private PaintSurface surface;

    // У конструкторі створюємо GUI
    public DrawFrame(String title) {
        super(title);

        // Завершити програму при закритті вікна
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Використовуємо розмітку BorderLayout
        this.setLayout(new BorderLayout());

        // Створюємо об’єкт області малювання
        surface = new PaintSurface();

        // Додаємо верхню панель із кнопками
        this.add(setButtonPanel(), BorderLayout.NORTH);

        // Додаємо область для малювання фігур у фрейм
        this.add(surface, BorderLayout.CENTER);

        // Встановлюємо розмір вікна
        this.setPreferredSize(new Dimension(800, 600));

        // Підганяємо розмір під вміст
        this.pack();

        // Робимо фрейм видимим
        this.setVisible(true);
    }

    /*
     * Створює та налаштовує верхню панель із кнопками.
     */
    private JPanel setButtonPanel() {

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(Color.CYAN);
        buttonPanel.setBorder(new LineBorder(Color.BLACK, 2));

        // 1. Кнопка Rectangle
        BigTextButton rect = new BigTextButton("Rectangle");
        rect.addActionListener(e -> surface.setShapeType(DrawShape.SHAPE_RECTANGLE));
        buttonPanel.add(rect);

        // 2. Кнопка Rounded Rectangle
        BigTextButton roundedRect = new BigTextButton("Rounded rect.");
        roundedRect.addActionListener(e -> surface.setShapeType(DrawShape.SHAPE_ROUNDED_RECT));
        buttonPanel.add(roundedRect);

        // 3. Кнопка Ellipse
        BigTextButton ellipseBtn = new BigTextButton("Ellipse");
        ellipseBtn.addActionListener(e -> surface.setShapeType(DrawShape.SHAPE_ELLIPSE));
        buttonPanel.add(ellipseBtn);

        // 4. Кнопка Clear
        BigTextButton clearBtn = new BigTextButton("Clear");
        clearBtn.addActionListener(e -> surface.clearShapes());
        buttonPanel.add(clearBtn);

        return buttonPanel;
    }
}

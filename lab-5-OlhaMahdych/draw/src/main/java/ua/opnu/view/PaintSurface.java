package ua.opnu.view;

import ua.opnu.model.DrawShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Поверхня для малювання фігур.
 */
public class PaintSurface extends JComponent {

    // Список фігур, які намальовані на поверхні
    private final List<DrawShape> shapes = new ArrayList<>();

    // Тип поточної фігури
    private int shapeType;

    // Початкова та кінцева точки малювання
    private Point startDrag;
    private Point endDrag;

    // Перелік кольорів
    private final List<Color> colors = Arrays.asList(
            Color.YELLOW, Color.MAGENTA, Color.CYAN, Color.RED, Color.BLUE, Color.PINK
    );

    public PaintSurface() {
        shapeType = 0;
        super.setPreferredSize(new Dimension(400, 400));

        // Обробник натискання кнопки миші
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                startDrag = new Point(e.getX(), e.getY());
                endDrag = startDrag;
                repaint();
            }

            public void mouseReleased(MouseEvent e) {
                DrawShape shape = DrawShape.newInstance(shapeType);
                shape.setStartPoint(startDrag);
                shape.setEndPoint(endDrag);
                shapes.add(shape);
                startDrag = null;
                endDrag = null;
                repaint();
            }
        });

        // Обробник перетягування миші
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                endDrag = new Point(e.getX(), e.getY());
                repaint();
            }
        });
    }

    // Встановлення типу фігури
    public void setShapeType(int type) {
        this.shapeType = type;
    }

    // Очищення всіх фігур з поверхні
    public void clearShapes() {
        shapes.clear();
        repaint();
    }

    // Малювання всієї поверхні
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // 1. Згладжування
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // 2. Сітка
        paintBackgroundGrid(g2);
        // 3. Товщина ліній
        g2.setStroke(new BasicStroke(2));
        // 4. Напівпрозорість
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.50f));

        // Малюємо всі фігури
        shapes.forEach(s -> {
            g2.setPaint(Color.BLACK);
            g2.draw(s.getShape());
            g2.setPaint(colors.get(shapes.indexOf(s) % 6));
            g2.fill(s.getShape());
        });

        // Малюємо фігуру, яка зараз створюється
        if (startDrag != null && endDrag != null) {
            g2.setPaint(Color.LIGHT_GRAY);
            DrawShape shape = DrawShape.newInstance(shapeType);
            g2.draw(shape.getShape(startDrag, endDrag));
        }
    }

    // Малювання сітки
    private void paintBackgroundGrid(Graphics2D g2) {
        g2.setPaint(Color.LIGHT_GRAY);

        // Вертикальні лінії
        for (int i = 0; i < getSize().width; i += 10) {
            Shape line = new Line2D.Float(i, 0, i, getSize().height);
            g2.draw(line);
        }

        // Горизонтальні лінії
        for (int i = 0; i < getSize().height; i += 10) {
            Shape line = new Line2D.Float(0, i, getSize().width, i);
            g2.draw(line);
        }
    }
}

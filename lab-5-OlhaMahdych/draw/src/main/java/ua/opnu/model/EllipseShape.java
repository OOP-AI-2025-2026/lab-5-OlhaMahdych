package ua.opnu.model;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/*
 * Клас "Еліпс" для малювання
 */
public class EllipseShape extends DrawShape {

    // Конструктор без параметрів
    public EllipseShape() {
        super();
    }


    // Повертає об'єкт Ellipse2D для малювання
    @Override
    public Shape getShape(Point startPoint, Point endPoint) {
        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);
        int width = Math.abs(startPoint.x - endPoint.x);
        int height = Math.abs(startPoint.y - endPoint.y);
        return new Ellipse2D.Double(x, y, width, height);
    }
}

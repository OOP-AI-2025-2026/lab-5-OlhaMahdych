package ua.opnu.model;

import java.awt.*;
import java.awt.geom.Rectangle2D;

/*
 * Клас "Прямокутник" для малювання
 */
public class RectangleShape extends DrawShape {

    public RectangleShape() {
        super();
    }

    public RectangleShape(Point startPoint, Point endPoint) {
        super(startPoint, endPoint);
    }

    @Override
    public Shape getShape(Point startPoint, Point endPoint) {
        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);
        int width = Math.abs(startPoint.x - endPoint.x);
        int height = Math.abs(startPoint.y - endPoint.y);
        return new Rectangle2D.Double(x, y, width, height);
    }
}

package ua.opnu.model;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

/*
 * Клас "Закруглений прямокутник" для малювання
 */
public class RoundedRectangleShape extends DrawShape {

    public RoundedRectangleShape() {
        super();
    }

    public RoundedRectangleShape(Point startPoint, Point endPoint) {
        super(startPoint, endPoint);
    }

    @Override
    public Shape getShape(Point startPoint, Point endPoint) {
        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);
        int width = Math.abs(startPoint.x - endPoint.x);
        int height = Math.abs(startPoint.y - endPoint.y);
        int arcWidth = 20;
        int arcHeight = 20;
        return new RoundRectangle2D.Double(x, y, width, height, arcWidth, arcHeight);
    }
}

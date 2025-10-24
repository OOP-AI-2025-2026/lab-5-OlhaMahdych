package ua.opnu.model;

import java.awt.*;


/**
 * Клас DrawShape — базовий клас для всіх фігур, які можна малювати.
 * Зберігає початкову та кінцеву точки фігури та надає методи для створення конкретних типів фігур.
 */

public class DrawShape {

    // Константи для типів фігур
    public static final int SHAPE_RECTANGLE = 0;
    public static final int SHAPE_ROUNDED_RECT = 1;    // Прямокутник із заокругленими кутами
    public static final int SHAPE_ELLIPSE = 2;         // Еліпс


    // Метод для створення нової фігури потрібного типу
    public static DrawShape newInstance(int shapeType) {
        DrawShape shape = null;
        if (shapeType == SHAPE_RECTANGLE) {
            shape = new RectangleShape();
        } else if (shapeType == SHAPE_ROUNDED_RECT) {
            shape = new RoundedRectangleShape();
        } else if (shapeType == SHAPE_ELLIPSE) {
            shape = new ua.opnu.model.EllipseShape();
        }
        return shape;
    }

    // Початкова та кінцева точки
    private Point startPoint;
    private Point endPoint;

    // Конструктор без параметрів
    public DrawShape() {
        this(new Point(0, 0), new Point(0, 0));
    }

    // Конструктор з початковими координатами
    public DrawShape(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    // Метод повертає фігуру, яку можна намалювати
    public Shape getShape() {
        return this.getShape(startPoint, endPoint);
    }

    // За замовчуванням повертає null — перевизначається в дочірніх класах
    public Shape getShape(Point startPoint, Point endPoint) {
        return null;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }
}

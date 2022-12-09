/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Triangle extends AbstractShapeClass {

    Point point2;
    Point point3;

    public Triangle(Point position, Point point2, Point point3) {
        super(position);
        this.point2 = point2;
        this.point3 = point3;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Point getPoint3() {
        return point3;
    }

    public void setPoint3(Point point3) {
        this.point3 = point3;
    }

    @Override
    public void draw(Graphics canvas) {
        int x1 = (int) getPosition().getX();
        int x2 = (int) getPoint2().getX();
        int x3 = (int) getPoint3().getX();
        int y1 = (int) getPosition().getY();
        int y2 = (int) getPoint2().getY();
        int y3 = (int) getPoint3().getY();
        int x[] = {x1, x2, x3};
        int y[] = {y1, y2, y3};
        Color oldColor = canvas.getColor();
        canvas.setColor(this.getFillColor());
        canvas.fillPolygon(x, y, 3);
        canvas.setColor(this.getColor());
        canvas.drawPolygon(x, y, 3);
        canvas.setColor(oldColor);
    }

    @Override
    public void moveTo(Point point) {

        int x_difference = point.x - this.getDraggingpoint().x;
        int y_difference = point.y - this.getDraggingpoint().y;
        // System.out.println("x difference " + x_difference +" y difference "+ y_difference);
        int newX = this.getPosition().x + x_difference;
        int newY = this.getPosition().y + y_difference;
        
        int newX2 = this.getPoint2().x + x_difference;
        int newY2 = this.getPoint2().y + y_difference;
        
        int newX3 = this.getPoint3().x + x_difference;
        int newY3 = this.getPoint3().y + y_difference;
        
        this.setPosition(new Point(newX, newY));
        this.setPoint2(new Point(newX2, newY2));
        this.setPoint3(new Point(newX3, newY3));
        this.setDraggingpoint(new Point(getDraggingpoint().x + x_difference, getDraggingpoint().y + y_difference));
    }

    static double area(Point position, Point point2, Point point3) {
        return Math.abs((position.x * (point2.y - point3.y) + point2.x * (point3.y - position.y)
                + point3.x * (position.y - point2.y)) / 2.0);
    }

    @Override
    public boolean contains(Point point) {
        /* Calculate area of triangle ABC */
        double A = area(getPosition(), point2, point3);

        /* Calculate area of triangle PBC */
        double A1 = area(point, point2, point3);

        /* Calculate area of triangle PAC */
        double A2 = area(getPosition(), point, point3);

        /* Calculate area of triangle PAB */
        double A3 = area(getPosition(), point2, point);

        /* Check if sum of A1, A2 and A3 is same as A */
        return (A == A1 + A2 + A3);
    }

}

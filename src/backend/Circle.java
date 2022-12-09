/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author LENOVO
 */
public class Circle extends AbstractShapeClass {

    private int radius;

    public Circle(Point position, int radius) {
        super(position);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw(Graphics canvas) {
        Color oldColor = canvas.getColor();
        canvas.setColor(this.getColor());
        canvas.drawOval(this.getPosition().x, this.getPosition().y, 2 * this.getRadius(), 2 * this.getRadius());
        canvas.setColor(this.getFillColor());
        canvas.fillOval(this.getPosition().x, this.getPosition().y, 2 * this.getRadius(), 2 * this.getRadius());
        canvas.setColor(oldColor);
    }

    public static double distance(Point A, Point B) {
        return Math.sqrt((Math.pow((A.x - B.x), 2) + Math.pow((A.y - B.y), 2)));
    }

    @Override
    public void moveTo(Point point) {

        int x_difference = point.x - this.getDraggingpoint().x;
        int y_difference = point.y - this.getDraggingpoint().y;
        // System.out.println("x difference " + x_difference +" y difference "+ y_difference);
        int newX = this.getPosition().x + x_difference;
        int newY = this.getPosition().y + y_difference;
        this.setPosition(new Point(newX, newY));
        this.setDraggingpoint(new Point(getDraggingpoint().x + x_difference, getDraggingpoint().y + y_difference));
    }

    @Override
    public boolean contains(Point point) {
        Point center = new Point(this.getPosition().x + radius, this.getPosition().y + radius); //? - or +
        return distance(center, point) <= radius;
    }

}

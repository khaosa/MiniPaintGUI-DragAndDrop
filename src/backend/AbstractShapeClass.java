/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.*;
/**
 *
 * @author LENOVO
 */
abstract public class AbstractShapeClass implements Shape, Moveable {

    private Point position;
    private Color color;
    private Color fillColor;
    private Point DraggingPoint;

    public AbstractShapeClass(Point position) {
        this.position = position;
    }

    @Override
    abstract public boolean contains(Point point);

    @Override
    abstract public void moveTo(Point point);

    @Override
    abstract public void draw(Graphics canvas);

    @Override
    public Point getDraggingpoint() {
        return DraggingPoint;
    }

    @Override
    public void setDraggingpoint(Point point) {
        this.DraggingPoint = point;
    }

    @Override
    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public Point getPosition() {
        return this.position;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setFillColor(Color color) {
        this.fillColor = color;
    }

    @Override
    public Color getFillColor() {
        return this.fillColor;
    }

}

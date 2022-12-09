/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

/**
 *
 * @author LENOVO
 */
public class Rectangle extends AbstractShapeClass {
    
    private int height;
    private int width;
    
    public Rectangle(Point position, int height, int width) {
        super(position);
        this.height = height;
        this.width = width;
    }    
    
    public int getHeight() {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
    public int getWidth() {
        return width;
    }
    
    public void setWidth(int width) {
        this.width = width;
    }
    
    @Override
    public void draw(Graphics canvas) {
        Color oldColor = canvas.getColor();
        canvas.setColor(this.getFillColor());
        canvas.fillRect(this.getPosition().x, this.getPosition().y, this.getWidth(), this.getHeight());
        canvas.setColor(this.getColor());
        canvas.drawRect(this.getPosition().x, this.getPosition().y, this.getWidth(), this.getHeight());
        canvas.setColor(oldColor);
        
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
        
        return (point.x >= this.getPosition().x && point.x <= this.getPosition().x + width)
                && (point.y >= this.getPosition().y && point.y <= this.getPosition().y + height);
    }
    
}

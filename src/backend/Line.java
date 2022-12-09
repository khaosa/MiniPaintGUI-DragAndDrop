package backend;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author LENOVO
 */
public class Line extends AbstractShapeClass {

    private Point endPoint;

    public Line(Point position, Point endPoint) {
        super(position);
        this.endPoint = endPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public void draw(Graphics canvas) {
        Color oldColor = canvas.getColor();
        canvas.setColor(this.getColor());
        canvas.drawLine(this.getPosition().x, this.getPosition().y, this.getEndPoint().x, this.getEndPoint().y);
        canvas.setColor(oldColor);
    }

    @Override
    public boolean contains(Point point) {

        int dy = this.getEndPoint().y - this.getPosition().y;
        int dx = this.getEndPoint().x - this.getPosition().x;

        int dy_clickedLine = point.y - this.getPosition().y;
        int dx_clickedLine = point.x - this.getPosition().x;

        if (dx == 0) //original line is a vertical line
        {
            if (dy > 0) // dy is positive; y_endPoint is bigger than y_startPoint
            {
                return (point.y <= this.getEndPoint().y && point.y >= this.getPosition().y) && (point.x == this.getPosition().x);
            } else // dy is negative; y_startPoint is bigger than y_endPoint
            {
                return (point.y >= this.getEndPoint().y && point.y <= this.getPosition().y) && (point.x == this.getPosition().x);
            }
        }

        if (dx_clickedLine == 0) // clickedPoint x coordinate is the same as start point
        {
            if (point.y == this.getPosition().y) {
                return true;
            } else {
                return false;
            }
        }

        int m1 = dy / dx;                             // get slope of original drawn line  

        int m2 = dy_clickedLine / dx_clickedLine;     // get slope of startPoint and clickedPoint

        if (m1 != m2) {
            return false;
        } else {     //////////// same slope
            if (dy > 0) // dy is positive; y_endPoint is bigger than y_startPoint
            {
                return point.y <= this.getEndPoint().y && point.y >= this.getPosition().y;
            } else {   // dy is negative; y_startPoint is bigger than y_endPoint
                return point.y >= this.getEndPoint().y && point.y <= this.getPosition().y;
            }
        }

    }

    @Override
    public void moveTo(Point point) {
        int x_difference = point.x - this.getDraggingpoint().x;
        int y_difference = point.y - this.getDraggingpoint().y;
        Point newPosition = new Point((this.getPosition().x + x_difference), (this.getPosition().y + y_difference));
        Point newEndPoints = new Point((this.getEndPoint().x + x_difference), (this.getEndPoint().y + y_difference));
        this.setPosition(newPosition);
        this.setEndPoint(newEndPoints);
        this.setDraggingpoint(new Point(getDraggingpoint().x + x_difference, getDraggingpoint().y + y_difference));

    }

}

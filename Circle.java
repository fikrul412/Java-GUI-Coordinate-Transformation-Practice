import java.awt.geom.Ellipse2D;

public class Circle extends Ellipse2D.Double {
    public Circle(double x, double y, double height, double width){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
    public void setPos(double xcor, double ycor){
        this.x = xcor;
        this.y = ycor;
    }
}

package L01WorkingWithAbstractions.Lab.P02PointInRectangle;

public class Rectangle {
    private Point topRight;
    private Point bottomLeft;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains (Point point){
        boolean isInXAxis = point.getX() >= bottomLeft.getX() && point.getX() <= topRight.getX();
        boolean isInYAxis = point.getY() >= bottomLeft.getY() && point.getY() <= topRight.getY();
        return isInXAxis && isInYAxis;
    }
}

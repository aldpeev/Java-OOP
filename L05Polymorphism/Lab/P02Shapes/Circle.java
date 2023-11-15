package L05Polymorphism.Lab.P02Shapes;

public class Circle extends Shape{
    private Double radius;

    public Circle(Double radius) {
        setRadius(radius);
    }

    @Override
    public void calculatePerimeter() {
        Double perimeter = 2 * radius;
        setPerimeter(perimeter);
    }

    @Override
    public void calculateArea() {
        Double area = Math.PI * Math.pow(radius, 2);
        setArea(area);
    }

    public final Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}

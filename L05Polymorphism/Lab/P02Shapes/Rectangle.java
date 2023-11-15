package L05Polymorphism.Lab.P02Shapes;

public class Rectangle extends Shape{
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        setHeight(height);
        setWidth(width);
    }

    @Override
    public void calculatePerimeter() {
        Double perimeter = 2 * height + 2 * width;
        setPerimeter(perimeter);
    }

    @Override
    public void calculateArea() {
        Double area = height * width;
        setArea(area);
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }
}

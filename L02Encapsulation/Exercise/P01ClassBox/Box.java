package L02Encapsulation.Exercise.P01ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        checkBoxSideParam(length,"Length");
        this.length = length;
    }

    private void setWidth(double width) {
        checkBoxSideParam(width,"Width");
        this.width = width;
    }

    private void setHeight(double height) {
        checkBoxSideParam(height,"Height");
        this.height = height;
    }

    private void checkBoxSideParam (double num, String side){
        if (num <= 0){
            throw new IllegalArgumentException(String.format("%s cannot be zero or negative.", side));
        }
    }

    public double calculateSurfaceArea() {
        return 2 * (length * height) + 2 * (length * width) + 2 * (height * width);
    }

    public double calculateLateralSurfaceArea() {
        return 2 * (length * height) + 2 * (width * height);
    }

    public double calculateVolume() {
        return length * width * height;
    }

    @Override
    public String toString(){
        return "Hi, bitch, I'm from the child class";
    }
}

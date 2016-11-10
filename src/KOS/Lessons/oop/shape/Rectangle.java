package KOS.Lessons.oop.shape;

public class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double square() {
        return width*height;
    }

    @Override
    public double perimetr() {
        return 2*(width+height);
    }

    @Override
    public void print() {
        System.out.println("I am Rectangle ");
    }
}

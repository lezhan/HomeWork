package KOS.Lessons.oop.shape;

public class Circle implements Shape {
    private double radius;
    private static final double PI = 3.14;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double square() {
        return PI*radius*radius;
    }

    @Override
    public double perimetr() {
        return 2*PI*radius;
    }

    @Override
    public void print() {
        System.out.println("I am Circle");
    }
}

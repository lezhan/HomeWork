package KOS.Lessons.oop.shape;

public class Triangle implements Shape {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    @Override
    public double square() {
        return Math.sqrt(0.5*perimetr() * (0.5*perimetr() - a) * (0.5 *perimetr() - b) * (0.5 * perimetr() - c));
    }

    @Override
    public double perimetr() {
        return a + b + c;
    }

    @Override
    public void print() {
        System.out.println("I am triangle");
    }
}

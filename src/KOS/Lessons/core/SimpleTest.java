package KOS.Lessons.core;

class Class1 {
    Class1(int i) {
        System.out.println("Class1(int)");
    }


}

public class SimpleTest extends Class1 {
    SimpleTest(double d) {              // 1
        this((int) d);
        System.out.println("Class2(double)");
    }

    SimpleTest(int i) {
        super(1);
        //super(i);                 // 2
        System.out.println("Class2(int)");
    }

    public static void main(String[] args) {
        new SimpleTest(0.0);
    }
}
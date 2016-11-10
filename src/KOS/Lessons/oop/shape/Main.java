package KOS.Lessons.oop.shape;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> shapeList = new ArrayList<>();
        shapeList.add(new Circle(2.34));
        shapeList.add(new Rectangle(2, 4));
        shapeList.add(new Triangle(2, 4, 7));

        for (Shape shape : shapeList){
            shape.print();
            System.out.println("Perimetr = " + shape.perimetr());
            System.out.println("Square = " + shape.square());
            System.out.println();


//            public class Bar {
//                public static void main(String args[]) {
//                    label:
//                    for (int i = 0; i < 5; ++i) {
//                        for (int j = 0; j < 5; ++j) {
//                            if (i > 2) break label;
//                            System.out.print(j);
//                        }
//                        System.out.print(" ");
//                    }
//                }
//            }

        }
    }
}

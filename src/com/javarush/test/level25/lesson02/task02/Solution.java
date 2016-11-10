package com.javarush.test.level25.lesson02.task02;

/* Машину на СТО не повезем!
Инициализируйте поле wheels используя данные из loadWheelNamesFromDB.
Обработайте некорректные данные.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
*/
//public class Solution {
//    public enum Wheel {
//        FRONT_LEFT,
//        FRONT_RIGHT,
//        BACK_LEFT,
//        BACK_RIGHT
//    }
//
//    public static class Car {
//        protected List<Wheel> wheels;
//
//
//
//        protected String[] loadWheelNamesFromDB() {
//            //this method returns mock data
//            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
//        }
//    }
//}


import java.util.Arrays;
import java.util.List;

public class Solution {
    public enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car(){
            wheels = Arrays.asList(Wheel.values());
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }
}

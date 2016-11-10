package com.javarush.test.level23.lesson06.task01;

/* Как выбрать нужное?
В методе main присвойте объекту Object obj экземпляр класса Lessons
Константу Lessons и класс Lessons менять нельзя.
*/
public class Solution {
    public static final String TEST = "test";

    public static class TEST {
        @Override
        public String toString() {
            return "test class";
        }
    }

    static Object obj;

    public static void main(String[] args) {
        Solution.TEST test = new Solution.TEST();
        obj = test;
        System.out.println(obj);
    }
}

//
//package com.javarush.test.level23.lesson06.task01;
//
///* Как выбрать нужное?
//В методе main присвойте объекту Object obj экземпляр класса Lessons
//Константу Lessons и класс Lessons менять нельзя.
//*/
//public class Solution {
//    public static final String Lessons = "test";
//
//    public static class Lessons {
//        @Override
//        public String toString() {
//            return "test class";
//        }
//    }
//
//    static Object obj;
//
//    public static void main(String[] args) {
//        obj = Solution.Lessons;
//        System.out.println(obj);
//    }
//}

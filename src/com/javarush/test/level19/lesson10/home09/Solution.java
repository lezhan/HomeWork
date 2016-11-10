package com.javarush.test.level19.lesson10.home09;
/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        String reclama = "JavaRush - курсы Java онлайн";
        PrintStream console = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
        testString.printSomething();
        System.setOut(console);
        String text = byteArrayOutputStream.toString();
        String[] stringArr = text.split(System.lineSeparator());
        for (int i = 0; i < stringArr.length; i++) {
            if(i % 2 == 0 && i != 0) System.out.println(reclama);
            System.out.println(stringArr[i]);
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}



//public class Solution {
//    public static TestString testString = new TestString();
//
//    public static void main(String[] args) {
//        String reklama = "JavaRush - курсы Java онлайн";
//        PrintStream console = System.out;
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        PrintStream printStream = new PrintStream(byteArrayOutputStream);
//        System.setOut(printStream);
//        testString.printSomething();
//        System.setOut(console);
//        String text = byteArrayOutputStream.toString();
//        String[] strArr = text.split(System.lineSeparator());
//        for (int i = 0; i < strArr.length; i++)
//        {
//            System.out.println(strArr[i]);
//            if (i % 2 != 0 && i != 0) System.out.println(reklama);
//        }
//    }
//
//    public static class TestString {
//        public void printSomething() {
//            System.out.println("first");
//            System.out.println("second");
//            System.out.println("third");
//            System.out.println("fourth");
//            System.out.println("fifth");
//        }
//    }
//}
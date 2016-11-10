package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream byteArrOS = new PrintStream(byteArrayOutputStream);
        System.setOut(byteArrOS);
        testString.printSomething();
        System.setOut(console);
        String[] strings = byteArrayOutputStream.toString().split(" ");
        int result = 0;
        if (strings[1].equals("+")) result = Integer.parseInt(strings[0]) + Integer.parseInt(strings[2]);
        else if (strings[1].equals("-")) result = Integer.parseInt(strings[0]) - Integer.parseInt(strings[2]);
        else if (strings[1].equals("*")) result = Integer.parseInt(strings[0]) * Integer.parseInt(strings[2]);
        System.out.println(byteArrayOutputStream.toString().replaceAll("[\n\r]","") + result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}


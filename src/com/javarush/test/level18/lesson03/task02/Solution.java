package com.javarush.test.level18.lesson03.task02;

import java.io.FileInputStream;
import java.util.Scanner;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        int min = inputStream.read();
        while (inputStream.available() > 0){
            int data = inputStream.read();
            if (data < min) min = data;
        }
        System.out.println(min);
        inputStream.close();
    }
}








//
//public class Solution {
//    public static void main(String[] args) throws Exception {
//        Scanner scanner = new Scanner(System.in);
//        String fileName = scanner.nextLine();
//        FileInputStream inputStream = new FileInputStream(fileName);
//        int min = inputStream.read();
//        while (inputStream.available() > 0){
//            int data = inputStream.read();
//            if (data < min) min = data;
//        }
//        System.out.println(min);
//        inputStream.close();
//    }
//}
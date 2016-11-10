package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки ввода-вывода.

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException    {
        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(scanner.nextLine()));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(scanner.nextLine()));
        while (bufferedReader.ready()){
            String[] line = bufferedReader.readLine().split(" ");
            for (String s : line){
                if (s.matches("\\d+")){
                    bufferedWriter.write(s + " ");
                }
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
        scanner.close();
    }
}

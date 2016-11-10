package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки ввода-вывода.
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(scanner.nextLine()));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(scanner.nextLine()));
        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();
            line = line.replace('.', '!');
            bufferedWriter.write(line);
        }
        bufferedReader.close();
        bufferedWriter.close();
        scanner.close();
    }
}

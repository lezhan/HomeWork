package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
*/

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader(scanner.nextLine());
        FileWriter fileWriter = new FileWriter(scanner.nextLine());
        while (fileReader.ready()){
            char[] data = new char[20];
            int count = fileReader.read(data);
            for (int i = 0; i < count; i++)
            {
                if (i % 2 != 0) fileWriter.write(data[i]);
            }

        }
        scanner.close();
        fileReader.close();
        fileWriter.close();
    }
}

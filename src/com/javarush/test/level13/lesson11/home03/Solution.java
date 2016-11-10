package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть закрыть файл и поток.
*/

import java.io.*;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        InputStream inputStream = new FileInputStream(scanner.nextLine());

        while (inputStream.available() > 0){
            System.out.println((char)inputStream.read());
        }
        inputStream.close();
        scanner.close();
    }
}

package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести все строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        String string = "";
        Scanner scanner = new Scanner(System.in);
        File logFile = new File(scanner.nextLine());
        FileWriter fileWriter = new FileWriter(logFile);
        ArrayList<String> list = new ArrayList<String>();
        while (true){
            string = scanner.nextLine();
            list.add(string);
            if (string.equals("exit")) break;
        }
        for (String s : list)
        {
            fileWriter.write(s + "\n");
        }
        scanner.close();
        fileWriter.close();
    }
}

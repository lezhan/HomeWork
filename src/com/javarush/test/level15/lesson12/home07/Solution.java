package com.javarush.test.level15.lesson12.home07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* Файл в статическом блоке
1. Инициализируй константу Constants.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
2. В статическом блоке считай из файла с именем Constants.FILE_NAME все строки и добавь их по-отдельности в
List lines.
3. Закрой поток ввода методом close().
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    public static void read() throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(Constants.FILE_NAME));
        String string = null;
        while ((string = bufferedReader.readLine()) != null)
        {
            lines.add(string);
        }
        bufferedReader.close();
    }

    public static void main(String[] args) throws IOException
    {
        read();
        for (String l : lines)
        System.out.println(l);
    }
}

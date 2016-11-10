package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых

        \ С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки ввода-вывода

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());
        int count = 0;
        while (fileInputStream.available() > 0){

            int data = fileInputStream.read();
            if (data == 44) count++;
        }
        System.out.println(count);
        bufferedReader.close();
        fileInputStream.close();
    }
}
